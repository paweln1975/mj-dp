package pl.paweln.dp.specification;

public class AndSpecification<T> implements Specification<T> {
    Specification<T> left;
    Specification<T> right;

    public AndSpecification(Specification<T> left, Specification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfied(T item) {
        return left.isSatisfied(item) && right.isSatisfied(item);
    }
}
