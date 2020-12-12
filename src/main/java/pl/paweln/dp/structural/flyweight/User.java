package pl.paweln.dp.structural.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class User {
    private static List<String> stringList = new ArrayList<>();
    private int[] names;

    public User(String fullName) {
        Function<String, Integer> getOrAdd = (String s) -> {
            int idx = stringList.indexOf(s);
            if (idx != -1) {
                return idx;
            } else {
                stringList.add(s);
                return stringList.size() -1;
            }
        };

        names = Arrays.stream(fullName.split(" ")).mapToInt(getOrAdd::apply).toArray();
    }

    public String getFirstName() {
        return this.names.length > 0 ? stringList.get(this.names[0]) : "";

    }

    public String getLastName() {
        return this.names.length > 1 ? stringList.get(this.names[1]) : "";
    }

    public static int getNameCacheSize() {
        return stringList.size();
    }
}
