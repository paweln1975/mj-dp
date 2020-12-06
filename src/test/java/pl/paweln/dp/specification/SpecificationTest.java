package pl.paweln.dp.specification;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpecificationTest {
    private static final Logger logger = LoggerFactory.getLogger(SpecificationTest.class);

    private List<Product> products = new LinkedList<>();

    @Before
    public void setup() {
        Product[] productsTable = {
                new Product("Apple", Color.RED, Size.SMALL),
                new Product("Tree", Color.GREEN, Size.MEDIUM),
                new Product("House", Color.BLUE, Size.LARGE),
                new Product("Apple", Color.GREEN, Size.SMALL)
        };

        products.addAll(Arrays.asList(productsTable));
    }

    @After
    public void cleanup() {
        products.clear();
    }

    @Test
    public void testFilterByColor() {
        logger.info("Specification test [testFilterByColor] ...");
        ProductFilter productFilter = new ProductFilter();
        Specification<Product> specification = new ColorSpecification(Color.RED);
        long productCount = productFilter.filter(this.products, specification).count();

        productFilter.filter(this.products, specification)
                .forEach(product -> logger.info("Filtered product: " + product));
        Assert.assertEquals(1, productCount);
    }

    @Test
    public void testFilterBySize() {
        logger.info("Specification test [testFilterBySize] ...");
        ProductFilter productFilter = new ProductFilter();
        Specification<Product> specification =  new SizeSpecification(Size.SMALL);

        long productCount = productFilter.filter(this.products, specification).count();

        productFilter.filter(this.products, specification)
                .forEach(product -> logger.info("Filtered product: " + product));

        Assert.assertEquals(2, productCount);
    }

    @Test
    public void testFilterBySizeAndColor() {
        logger.info("Specification test [testFilterBySizeAndColor] ...");
        ProductFilter productFilter = new ProductFilter();
        Specification<Product> specification =new AndSpecification<>(
                new ColorSpecification(Color.GREEN),
                new SizeSpecification(Size.SMALL)
        );

        long productCount = productFilter.filter(this.products, specification).count();
        productFilter.filter(this.products, specification)
                .forEach(product -> logger.info("Filtered product: " + product));

        Assert.assertEquals(1, productCount);
    }

}
