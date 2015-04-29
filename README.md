# LazyEvaluationJava8
This repo tries to reproduce Scala lazy evaluation using Java 8 lambdas

`AbstractLazy` is the base class and `LazyString` is an example of the implementation to use lazy evaluation with strings.

## Example
`AbstractLazy<String> lazyString = LazyString.get((Void v) -> superComputationMethod())`
`lazyString.toString()` 
