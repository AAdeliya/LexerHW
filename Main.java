
public class Main {
    public static void main(String[] args) {
        String input = """
            if %num_users > 1000
            update "status" = "high load"
            else
            update "status" = "normal load"
            end
            """;

       Lexer lexer = new Lexer(input);
        for (Token token : lexer.getTokens()) {
            System.out.println(token);
        }
    }}