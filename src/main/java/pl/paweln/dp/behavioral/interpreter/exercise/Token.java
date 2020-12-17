package pl.paweln.dp.behavioral.interpreter.exercise;

public class Token {
    public enum Type {
        INTEGER,
        PLUS,
        MINUS,
        VARIABLE
    }
    protected Type type;
    protected String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

}
