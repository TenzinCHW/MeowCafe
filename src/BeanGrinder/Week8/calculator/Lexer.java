package BeanGrinder.Week8.calculator;

import java.util.ArrayList;

/**
 * Calculator lexical analyzer.
 */
//public class Lexer {
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
