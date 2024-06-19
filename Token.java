

public class Token {
    public enum Type {
        NUMBER, VAR, ASSIGN, MULTIPLY, DIVIDE, CONFIG, PLUS,
        MINUS, UPDATE, COMPUTE, SHOW, KEYWORD,
        LPAREN, RPAREN, LBRACE, RBRACE, SEMICOLON, CONFIGS,
        ASSIGMENT, STRING, OPERATOR, IDENTIFIER, REFERENCES, BRACES, PRINT, REFERENCE, ASSIGNMENT

    }


    public final Type type;
    public  final String value;

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