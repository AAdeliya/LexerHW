
public class Main {
    public static void main(String[] args) {
        String input = """
            if %num_users > 1000
            update "status" = "high load"
            else
            update "status" = "normal load"
            end
            """;


        String input2 = """
                x = 5;
                if (x > 3){
                    y = x + 2;
                } else {
                    y = x * (2 + 3);
                    }
                    print y
                """;

       Lexer lexer = new Lexer(input);
        for (Token token : lexer.getTokens()) {
            System.out.println(token);
        }
        Lexer lexer2 = new Lexer(input2);
        for (Token token : lexer2.getTokens()) {
            System.out.println(token);
    }}}