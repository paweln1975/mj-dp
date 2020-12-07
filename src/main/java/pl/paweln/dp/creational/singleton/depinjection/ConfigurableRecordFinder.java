package pl.paweln.dp.creational.singleton.depinjection;

import java.util.List;

public class ConfigurableRecordFinder {
    private CityDatabase cityDatabase;

    public ConfigurableRecordFinder(CityDatabase database) {
        this.cityDatabase = database;
    }

    public int getTotalPopulation(List<String> cityNamesList) {
        int result = 0;
        for (String name : cityNamesList)
            result += this.cityDatabase.getPopulation(name);
        return result;
    }
}
