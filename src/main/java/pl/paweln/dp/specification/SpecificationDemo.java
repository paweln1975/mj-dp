package pl.paweln.dp.specification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class SpecificationDemo {
    private static final Logger logger = LoggerFactory.getLogger(Specification.class);

    public static void demo() {
        List<Product> products = new LinkedList<>();
        products.add(new Product("Pencil 1", Color.BLUE, Size.SMALL));
        products.add(new Product("Pencil 2", Color.BLUE, Size.LARGE));

        logger.info("Specification demo ...");

        ProductFilter productFilter = new ProductFilter();
        productFilter.filter(products,
                new AndSpecification<>(
                        new ColorSpecification(Color.BLUE),
                        new SizeSpecification(Size.SMALL)
                )
            ).forEach(product -> logger.info("Filtered Product: " + product));
    }
}
