import java.util.function.Function;

/**
 * This is the base class to have lazy variables in the project
 * The idea is to trigger its computation only if/when the value is needed
 * @param <T> The return type of the lazy computation
 *
 *  @author Mariano Lucchetta
 */
public abstract class AbstractLazy<T> {
    private T finalValue;
    private volatile boolean bitmap;
    private Function<Void, T> applyFunc;

    public AbstractLazy(Function<Void, T> func) {
        applyFunc = func;
    }

    public T lzyCompute() {
        synchronized(this) {
            if(!bitmap) {
                finalValue = applyFunc.apply(null);
                bitmap = true;
            }
            return finalValue;
        }
    }

    @Override
    public String toString() {
        if(bitmap) {
            return finalValue.toString();
        } else {
            return lzyCompute().toString();
        }
    }
}
