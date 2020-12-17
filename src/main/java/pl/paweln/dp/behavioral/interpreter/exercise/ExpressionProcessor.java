package pl.paweln.dp.behavioral.interpreter.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionProcessor {
    public Map<Character, Integer> variables = new HashMap<>();

    public int calculate(String expression)
    {
        return parse(lex(expression), variables);
    }

    private static List<Token> lex(String input) {
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '+':
                    tokens.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token(Token.Type.MINUS, "-"));
                    break;
                default:
                    StringBuilder sb = new StringBuilder("" + input.charAt(i));

                    if (Character.isDigit(input.charAt(i))) {

                        if (i == input.length()-1) {
                            tokens.add(new Token(Token.Type.INTEGER, sb.toString()));
                            break;
                        }

                        for (int j = i + 1; j < input.length(); j++) {
                            if (Character.isDigit(input.charAt(j))) {
                                sb.append(input.charAt(j));
                                ++i;
                            } else {
                                tokens.add(new Token(Token.Type.INTEGER, sb.toString()));
                                break;
                            }
                        }
                    } else {

                        if (i == input.length()-1) {
                            tokens.add(new Token(Token.Type.VARIABLE, sb.toString()));
                            break;
                        }

                        for (int j = i + 1; j < input.length(); j++) {
                            if ((int)input.charAt(j) >= 97 && (int)input.charAt(j) <= 122) { // character ascii
                                sb.append(input.charAt(j));
                                ++i;
                            } else {
                                tokens.add(new Token(Token.Type.VARIABLE, sb.toString()));
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return tokens;
    }

    private static int parse(List<Token> tokens, Map<Character, Integer> variables) {
        int result = 0;

        try {
            if (tokens.size() > 0) {
                result = getIntegerValue(tokens.get(0), variables);
            }
            int nextValue;
            for (int i = 1; i < tokens.size(); i++) {
                if (i % 2 == 1) { // operator
                    if (tokens.get(i).type == Token.Type.PLUS || tokens.get(i).type == Token.Type.MINUS) {
                        nextValue = getIntegerValue(tokens.get(i + 1), variables);
                        switch (tokens.get(i).type) {
                            case PLUS:
                                result += nextValue;
                                break;
                            case MINUS:
                                result -= nextValue;
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return result;
    }

    private static int getIntegerValue(Token token, Map<Character, Integer> variables) throws Exception {
        int result;
        if (token.type == Token.Type.INTEGER) {
            result = Integer.parseInt(token.value);
        } else if (token.type == Token.Type.VARIABLE && token.value.length() == 1) {
            if (variables.containsKey(token.value.charAt(0))) {
                result = variables.get(token.value.charAt(0));
            } else {
                throw new Exception("No int value");
            }
        } else {
            throw new Exception("No int value");
        }
        return result;
    }

}
