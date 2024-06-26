

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lexer {
    //private final ArrayList<Token> tokens = new ArrayList<>();
    public final String input;
    public  final List<Token> tokens;
    public  int current;

    public Lexer(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
        this.current = 0;
        tokenize();


        //  x = 5;
        //                if (x > 3){
        //                    y = x + 2;
        //                } else {
        //                    y = x * (2 + 3);
        //                    }
        //                    print y//
    }

    public List<Token> tokenize() {
        while (current < input.length()) {
            char ch = input.charAt(current);
            switch (ch) {
                case ' ', '\t', '\n', '\r':
                    current++; // Skip whitespace
                    break;
                case '=':
                    tokens.add(new Token(Token.Type.ASSIGN, "="));
                    current++;

                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '>':
                case '<':

                    tokens.add(new Token(Token.Type.OPERATOR, Character.toString(ch)));
                    current++;
                    break;
                case '(':
                case ')':
                case '{':
                case '}':

                    tokens.add(new Token(Token.Type.BRACES, Character.toString(ch)));
                    current++;
                    break;
                case ';':
                    tokens.add(new Token(Token.Type.SEMICOLON, Character.toString(ch)));
                    current++;
                    break;

                case '"':
                    tokens.add(new Token(Token.Type.STRING, readString()));
                    break;
                case '%':
                    tokens.add(new Token(Token.Type.REFERENCE, readReference()));
                    break;







                default:
                    if (isDigit(ch)) {
                        tokens.add(new Token(Token.Type.NUMBER, readNumber()));
                    } else if (isAlpha(ch)) {
                        String identifier = readIdentifier();
                        tokens.add(new Token(deriveTokenType(identifier), identifier));
                    } else {
                        throw new RuntimeException("Unsupported character: " + ch);
                    }
            }
        }
        return null;
    }

    public Token.Type deriveTokenType(String identifier) {
        return switch (identifier) {
            case "config" -> Token.Type.CONFIG;
            case "update" -> Token.Type.UPDATE;
            case "compute" -> Token.Type.COMPUTE;
            case "show" -> Token.Type.SHOW;
            case "configs" -> Token.Type.CONFIGS;
            case "if" ->Token.Type.KEYWORD;
            case "else" -> Token.Type.KEYWORD;
            case "print" ->Token.Type.KEYWORD;
            case "end"->Token.Type.KEYWORD;
            default -> Token.Type.IDENTIFIER;
        };
    }

    private String readIdentifier() {
        StringBuilder builder = new StringBuilder();
        while (current < input.length() && isAlphaNumeric(input.charAt(current))) {
            builder.append(input.charAt(current));
            current++;
        }
        return builder.toString();
    }

    private String readNumber() {
        StringBuilder builder = new StringBuilder();
        while (current < input.length() && isDigit(input.charAt(current))) {
            builder.append(input.charAt(current));
            current++;
        }
        return builder.toString();
    }

    private String readReference() {
        StringBuilder builder = new StringBuilder();
        current++; // Skip the '%'
        while (current < input.length() && isAlphaNumeric(input.charAt(current))) {
            builder.append(input.charAt(current));
            current++;
        }
        return builder.toString();
    }

    private String readString() {
        StringBuilder builder = new StringBuilder();
        current++; // Skip the initial double quote
        while (current < input.length() && input.charAt(current) != '"') {
            builder.append(input.charAt(current));
            current++;
        }
        current++; // Skip the closing double quote
        return builder.toString();
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }

    private boolean isAlpha(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || c == '_';
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public Iterator<Token> iterator() {
        return tokens.iterator();
    }

    public List<Token> getTokens() {
        return tokens;
    }
}