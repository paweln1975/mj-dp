package pl.paweln.dp.specification;

public interface Specification <T> {
    boolean isSatisfied(T item);
}
