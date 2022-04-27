package xyz.arraybot.mantis.utils;

import java.util.Optional;
import java.util.function.Function;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class Either<L, R> {
    private final Optional<L> left;
    private final Optional<R> right;

    private Either(Optional<L> left, Optional<R> right) {
        this.left = left;
        this.right = right;
    }

    public static <L, R> Either<L, R> left(L left) {
        return new Either<>(Optional.of(left), Optional.empty());
    }

    public static <L, R> Either<L, R> right(R right) {
        return new Either<>(Optional.empty(), Optional.of(right));
    }

    public <T> T mapReduce(Function<L, T> left, Function<R, T> right) {
        Optional<T> l = this.left.map(left);
        Optional<T> r = this.right.map(right);
        // Why Java cannot do this elegantly is beyond me.
        Optional<T> result = Optional.ofNullable(l.orElse(r.orElse(null)));
        return result.orElseThrow(IllegalStateException::new);
    }
}
