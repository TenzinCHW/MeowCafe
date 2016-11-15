package BeanGrinder.Week8.calculator;

//import BeanGrinder.Week8.calculator.Lexer.Token;

import java.util.ArrayList;

/*
 * TODO (optional) define your grammar here
 */

/**
 * Calculator parser. All values are measured in pt.
 */
//class Parser {
//
//    @SuppressWarnings("serial")
//    static class ParserException extends RuntimeException {
//    }
//
//    /**
//     * Type of values.
//     */
//    private enum ValueType {
//        POINTS, INCHES, SCALAR
//    }
//
//    ;
//
//    /**
//     * Internal value is always in points.
//     */
//    public class Value {
//        final double value;
//        final ValueType type;
//
//        Value(double value, ValueType type) {
//            this.value = value;
//            this.type = type;
//        }
//
//        @Override
//        public String toString() {
//            switch (type) {
//                case INCHES:
//                    return value / PT_PER_IN + " in";
//                case POINTS:
//                    return value + " pt";
//                default:
//                    return "" + value;
//            }
//        }
//    }
//
//    private static final double PT_PER_IN = 72;
//    private final Lexer lexer;
//
//    Parser(Lexer lexer) {
//        this.lexer = lexer;
//    }
//
//    public Value evaluate() {
//        double eval = parse();
//        ValueType type = detType();
//
//        Value value = new Value(eval, type);
//        return value;
//    }
//
//
//    private double parse() {
//        int count = 0;
//        ArrayList<Token> tokens = lexer.getProblem();
//        ArrayList<Token> toSolve = new ArrayList<Token>();
//        double result = 0;
//        Token op = null;
//        boolean left = false;
//
//        while (count < tokens.size()) {
//            Token currentToken = tokens.get(count);
//            if (currentToken.type == Type.L_PAREN) {
//                // Dealing with literals that come before parenthesis
//                if (!toSolve.isEmpty()) {
//                    result = solve(result, solve(toSolve), op);
//                    toSolve.clear();
//                    left = false;
//                }
//
//                count++;
//                currentToken = tokens.get(count);
//                while (currentToken.type != Type.R_PAREN) {
//                    toSolve.add(currentToken);
//                    count++;
//                    currentToken = tokens.get(count);
//                }
//                result = solve(result, solve(toSolve), op);
//                toSolve.clear();
//                op = null;
//                if (count + 1 < tokens.size()) {
//                    if (tokens.get(count + 1).type == Type.INCH) {
//                        result = convertInch((double) result);
//                        count++;
//                    } else if (tokens.get(count + 1).type == Type.POINT) {
//                        count++;
//                    }
//                }
//            } else if (currentToken.type == Type.PLUS || currentToken.type == Type.MINUS || currentToken.type == Type.TIMES || currentToken.type == Type.DIVIDE) {
//                // I think this can actually just be boiled down to checking
//                // whether the left side is a number or number + unit and the right side is a number
//                if (count - 1 >= 0) {
//                    if (count - 2 >= 0) {
//                        if (tokens.get(count - 2).type == Type.NUMBER && (tokens.get(count - 1).type == Type.INCH || tokens.get(count - 1).type == Type.INCH) && tokens.get(count + 1).type == Type.NUMBER) {
//                            toSolve.add(currentToken);
//                        } else {
//                            op = currentToken;
//                        }
//                    } else if (tokens.get(count - 1).type == Type.NUMBER && tokens.get(count + 1).type == Type.NUMBER) {
//                        toSolve.add(currentToken);
//                    } else {
//                        op = currentToken;
//                    }
//                } else {
//                    op = currentToken;
//                }
//            } else {
//                if (!left) {
//                    toSolve.add(currentToken);
//                    left = true;
//                    if (count + 1 < tokens.size()) {
//                        if (tokens.get(count + 1).type == Type.INCH || tokens.get(count + 1).type == Type.POINT) {
//                            toSolve.add(tokens.get(count + 1));
//                            count++;
//                        }
//                    } else {
//                        result = solve(result, solve(toSolve), op);
//                    }
//                } else {
//                    toSolve.add(currentToken);
//                    if (count + 1 < tokens.size()) {
//                        if (tokens.get(count + 1).type == Type.INCH || tokens.get(count + 1).type == Type.POINT) {
//                            toSolve.add(tokens.get(count + 1));
//                            count++;
//                        }
//                    }
//                    result = solve(result, solve(toSolve), op);
//                    left = false;
//                    op = null;
//                    toSolve.clear();
//                }
//            }
//            count++;
//
//        }
//        return result;
//    }
//
//    private ValueType detType() {
//        ValueType type = null;
//        Type one;
//        Type two = null;
//        ArrayList<Token> orderOfParenAndType = new ArrayList<Token>();
//
//        for (Token token :
//                lexer.getProblem()) {
//            if (token.type == Type.INCH || token.type == Type.POINT || token.type == Type.L_PAREN || token.type == Type.R_PAREN) {
//                orderOfParenAndType.add(token);
//            }
//        }
//
//        if (orderOfParenAndType.size() > 0) {
//            if (orderOfParenAndType.get(0).type == Type.INCH){
//                type = ValueType.INCHES;
//            }else if (orderOfParenAndType.get(0).type == Type.POINT){
//                type = ValueType.POINTS;
//            }else {
//                int count = 0;
//                while (count + 1 < orderOfParenAndType.size()){
//                    if (orderOfParenAndType.get(count).type == Type.R_PAREN && orderOfParenAndType.get(count+1).type == Type.INCH){
//                        type = ValueType.INCHES;
//                        break;
//                    }else if (orderOfParenAndType.get(count).type == Type.R_PAREN && orderOfParenAndType.get(count+1).type == Type.POINT){
//                        type = ValueType.POINTS;
//                        break;
//                    }
//                    count++;
//                }
//                if (type == null){
//                    count = 0;
//                    while (count + 1 < orderOfParenAndType.size()){
//                        if (orderOfParenAndType.get(count).type == Type.L_PAREN && orderOfParenAndType.get(count+1).type == Type.INCH){
//                            type = ValueType.INCHES;
//                            break;
//                        }else if (orderOfParenAndType.get(count).type == Type.L_PAREN && orderOfParenAndType.get(count+1).type == Type.POINT){
//                            type = ValueType.POINTS;
//                            break;
//                        }
//                        count++;
//                    }
//                }
//            }
//        }
//
//        if (type == null) {
//            type = ValueType.SCALAR;
//        }
//        return type;
//    }
//
//    private double solve(ArrayList<Token> list) {
//        Token op = null;
//        Token first = null;
//        Token second = null;
//
//        if (list.size() <= 2) {
//            double number = Double.parseDouble(list.get(0).text);
//            if (list.size() == 2) {
//                if (list.get(1).type == Type.INCH) {
//                    number = convertInch((double) number);
//                }
//            }
//            return number;
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).type == Type.NUMBER && first == null) {
//                first = list.get(i);
//            } else if (list.get(i).type == Type.NUMBER && second == null) {
//                second = list.get(i);
//            } else if (list.get(i).type == Type.PLUS || list.get(i).type == Type.MINUS || list.get(i).type == Type.TIMES || list.get(i).type == Type.DIVIDE) {
//                op = list.get(i);
//            } else if (list.get(i).type == Type.INCH) {
//                if (list.get(i - 1) == first) {
//                    first = convertInch((Token) first);
//                } else if (list.get(i - 1) == second) {
//                    second = convertInch((Token) second);
//                }
//            }
//        }
//
//        if (op.type == Type.PLUS) {
//            return Double.parseDouble(first.text) + Double.parseDouble(second.text);
//        } else if (op.type == Type.MINUS) {
//            return Double.parseDouble(first.text) - Double.parseDouble(second.text);
//        } else if (op.type == Type.TIMES) {
//            return Double.parseDouble(first.text) * Double.parseDouble(second.text);
//        } else if (op.type == Type.DIVIDE) {
//            try {
//                return Double.parseDouble(first.text) / Double.parseDouble(second.text);
//            } catch (Exception e) {
//                System.out.println("Cannot divide by 0");
//            }
//        }
//        return -1;
//    }
//
//    private double solve(double result, double arg, Token op) {
//        double cumulative = 0;
//        if (result == 0) {
//            return arg;
//        } else {
//            if (op.type == Type.PLUS) {
//                cumulative = result + arg;
//            } else if (op.type == Type.MINUS) {
//                cumulative = result - arg;
//            } else if (op.type == Type.TIMES) {
//                cumulative = result * arg;
//            } else if (op.type == Type.DIVIDE) {
//                try {
//                    cumulative = result / arg;
//                } catch (Exception e) {
//                    System.out.println("Cannot divide by 0");
//                }
//            }
//        }
//        return cumulative;
//    }
//
//    private double convertInch(double toConvert) {
//        return toConvert * PT_PER_IN;
//    }
//
//    private Token convertInch(Token toConvert) {
//        return new Token(toConvert.type, Double.toString(Double.parseDouble(toConvert.text) * PT_PER_IN));
//    }
//}
//
//
//
//
//class Lexer {
//
//    /**
//     * Token in the stream.
//     */
//    public static class Token {
//        final Type type;
//        final String text;
//
//        Token(Type type, String text) {
//            this.type = type;
//            this.text = text;
//        }
//
//        Token(Type type) {
//            this(type, null);
//        }
//        @Override
//        public String toString(){
//            return String.format(this.text + " " + this.type);
//        }
//    }
//
//    @SuppressWarnings("serial")
//    static class TokenMismatchException extends Exception {
//        @Override
//        public String getMessage(){
//            return "One or more items were not recognized";
//        }
//    }
//
//    private ArrayList<Token> problem;
//
//    public Lexer(String input) throws TokenMismatchException{
//        input = input.replaceAll("\\s", "");
//        problem = new ArrayList<Token>();
//
//        String currentArg;
//        int count = 0;
//        while (count < input.length()) {
//            currentArg = input.substring(count, count + 1);
//            if (currentArg.matches("(\\d||\\.)")) {
//                String number = "";
//                while (currentArg.matches("(\\d||\\.)")) {
//                    number += currentArg;
//                    count++;
//                    if (count < input.length()) {
//                        currentArg = input.substring(count, count + 1);
//                    }else {
//                        break;
//                    }
//                }
//                count--;
//                problem.add(new Token(Type.NUMBER, number));
//            }else if (currentArg.equals("(")) {
//                problem.add(new Token(Type.L_PAREN));
//            } else if (currentArg.equals(")")) {
//                problem.add(new Token(Type.R_PAREN));
//            } else if (currentArg.equals("+")) {
//                problem.add(new Token(Type.PLUS));
//            } else if (currentArg.equals("-")) {
//                problem.add(new Token(Type.MINUS));
//            } else if (currentArg.equals("*")) {
//                problem.add(new Token(Type.TIMES));
//            } else if (currentArg.equals("/")) {
//                problem.add(new Token(Type.DIVIDE));
//            } else if (currentArg.matches("(i|p)") && count < input.length()-1) {
//                currentArg = input.substring(count, count + 2);
//                count++;
//                if (currentArg.equals("in")) {
//                    problem.add(new Token(Type.INCH));
//                } else if (currentArg.equals("pt")) {
//                    problem.add(new Token(Type.POINT));
//                }
//            }else {
//                throw new TokenMismatchException();
//            }
//            count++;
//        }
//    }
//
//    public ArrayList<Token> getProblem(){
//        return problem;
//    }
//}