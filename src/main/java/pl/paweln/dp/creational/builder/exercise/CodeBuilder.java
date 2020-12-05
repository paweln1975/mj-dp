package pl.paweln.dp.creational.builder.exercise;

import java.util.LinkedList;
import java.util.List;

public class CodeBuilder {
    private List<Field> fieldList = new LinkedList<>();
    private String className;
    public CodeBuilder(String className)
    {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        this.fieldList.add(new Field(type, name));
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("public class ")
                .append(className)
                .append(System.lineSeparator())
                .append("{")
                .append(System.lineSeparator());
        for (Field f : this.fieldList) {
            builder.append("  public ")
                    .append(f.type)
                    .append(" ")
                    .append(f.name)
                    .append(";")
                    .append(System.lineSeparator());
        }
        builder.append("}");

        return builder.toString();
    }

    class Field {
        private String name;
        private String type;

        public Field(String type, String name) {
            this.name = name;
            this.type = type;
        }
    }
}
