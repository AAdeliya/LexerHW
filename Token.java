

public class Token {
    public enum Type {
        ASSIGNMENT, OPERATOR, NUMBER, STRING, REFERENCE, CONFIG, UPDATE, COMPUTE, SHOW, CONFIGS, IDENTIFIER
    }

    private final Type type;
    private final String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
        //
    }

    @Override
    public String toString() {
        return "Token{" + "type=" + type + ", value='" + value + '\'' + '}';
    }
}