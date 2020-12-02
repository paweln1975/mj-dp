package pl.paweln.dp.specification;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpecificationTest {
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
        ProductFilter productFilter = new ProductFilter();
        long productCount = productFilter.filter(this.products, new ColorSpecification(Color.RED)).count();

        Assert.assertEquals(1, productCount);
    }

    @Test
    public void testFilterBySize() {
        ProductFilter productFilter = new ProductFilter();
        long productCount = productFilter.filter(this.products, new SizeSpecification(Size.SMALL)).count();

        Assert.assertEquals(2, productCount);
    }

    @Test
    public void testFilterBySizeAndColor() {
        ProductFilter productFilter = new ProductFilter();
        long productCount = productFilter.filter(this.products,
                new AndSpecification<>(
                        new ColorSpecification(Color.GREEN),
                        new SizeSpecification(Size.SMALL)
                )
                ).count();

        Assert.assertEquals(1, productCount);
    }

}
