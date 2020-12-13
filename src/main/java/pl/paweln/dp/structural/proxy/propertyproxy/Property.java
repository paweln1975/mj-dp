package pl.paweln.dp.structural.proxy.propertyproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Property <T> {
    private static final Logger logger = LoggerFactory.getLogger(Property.class);

    private T value;
    private String name;
    private Object obj;

    public Property(T value, String name, Object obj) {
        this.value = value;
        this.name = name;
        this.obj = obj;
        logger.info("Setting Property:"+this.name + " to value:" + this.value + " of " + obj.toString());
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
        logger.info("Setting Property:"+this.name + " to value:" + this.value + " of " + obj.toString());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property<?> property = (Property<?>) o;

        return value != null ? value.equals(property.value) : property.value == null;
    }

    @Override
    public int hashCode()
    {
        return value != null ? value.hashCode() : 0;
    }
}
