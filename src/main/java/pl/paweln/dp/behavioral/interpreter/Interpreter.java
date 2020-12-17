package pl.paweln.dp.behavioral.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Interpreter {
    public static List<Token> lex(String input) {
        List<Token> tokens = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '+':
                    tokens.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token(Token.Type.MINUS, "-"));
                    break;
                case '(':
                    tokens.add(new Token(Token.Type.LPAREN, "("));
                    break;
                case ')':
                    tokens.add(new Token(Token.Type.RPAREN, ")"));
                    break;
                default:
                    StringBuilder sb = new StringBuilder("" + input.charAt(i));
                    for (int j = i + 1; j < input.length(); j++) {
                        if (Character.isDigit(input.charAt(j))) {
                            sb.append(input.charAt(j));
                            ++i;
                        } else {
                            tokens.add(new Token(Token.Type.INTEGER, sb.toString()));
                            break;
                        }
                    }
                    break;
                }
            }
        return tokens;
    }


    public static Element parse (List<Token> tokens) {
        BinaryOperation result = new BinaryOperation();
        boolean flag = false;

        for (int i = 0; i < tokens.size(); ++i) {
            switch (tokens.get(i).type) {
                case INTEGER:
                    IntegerValue integerValue = new IntegerValue(Integer.parseInt(tokens.get(i).text));
                    if (!flag) {
                        result.left = integerValue;
                        flag = true;
                    } else {
                        result.right = integerValue;
                    }
                    break;
                case PLUS:
                    result.type = BinaryOperation.Type.ADDITION;
                    break;
                case MINUS:
                    result.type = BinaryOperation.Type.SUBTRACTION;
                    break;
                case LPAREN:
                    int j = i; // location of right paren
                    for (; j < tokens.size(); ++j)
                        if (tokens.get(j).type == Token.Type.RPAREN)
                            break;
                    List<Token> subExpr = tokens.stream()
                            .skip(i + 1)
                            .limit(j - i - 1)
                            .collect(Collectors.toList());
                    Element elem = parse(subExpr);
                    if (!flag) {
                        result.left = elem;
                        flag = true;
                    } else {
                        result.right = elem;
                    }
                    i = j;
                    break;
            }
        }

        return result;
    }
}

