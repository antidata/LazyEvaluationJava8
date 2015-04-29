import java.util.function.Function;

public class LazyString extends AbstractLazy<String> {
    public LazyString(Function<Void, String> func) {
        super(func);
    }

    public static AbstractLazy<String> get(Function<Void, String> func) {
        return new LazyString(func);
    }
}
