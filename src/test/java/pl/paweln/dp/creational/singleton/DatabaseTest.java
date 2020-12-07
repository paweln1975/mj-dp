package pl.paweln.dp.creational.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.singleton.depinjection.CityDatabase;
import pl.paweln.dp.creational.singleton.depinjection.ConfigurableRecordFinder;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class DatabaseTest {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseTest.class);

    @Test
    public void testConfigurableRecordFinder() {
        logger.info("Configurable Record Finder test ...");
        ConfigurableRecordFinder finder = new ConfigurableRecordFinder(new DummyDatabase());

        int total = finder.getTotalPopulation(
                Arrays.asList("alpha", "gamma")
        );

        Assert.assertEquals(4, total);
    }
}

class DummyDatabase implements CityDatabase {
    private Dictionary<String, Integer> data = new Hashtable<>();

    public DummyDatabase() {
        data.put("alpha", 1);
        data.put("beta", 2);
        data.put("gamma", 3);
    }
    @Override
    public int getPopulation(String cityName) {
        return data.get(cityName);
    }
}
