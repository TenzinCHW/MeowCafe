package BeanGrinder.Week8.calculator;

//import java.io.BufferedReader;

import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Multi-unit calculator.
 */
public class MultiUnitCalculator {

    /**
     * @param expression a String representing a multi-unit expression, as defined in
     *                   the problem set
     * @return the value of the expression, as a number possibly followed by
     * units, e.g. "72pt", "3", or "4.882in"
     */
    public String evaluate(String expression) {
        Lexer2 lexer = new Lexer2(expression);
        Parser2 parser = new Parser2(lexer);
        return parser.evaluate().toString();
    }

    /**
     * Repeatedly reads expressions from the console, and outputs the results of
     * evaluating them. Inputting an empty line will terminate the program.
     *
     * @param args unused
     */
    public static void main(String[] args) throws IOException {
        MultiUnitCalculator calculator;
        String result;

//        Scanner in = new Scanner(System.in);
        String expression;

        calculator = new MultiUnitCalculator();

        expression = "3+2.4"; //= 5.4
        result = calculator.evaluate(expression);
        System.out.println(result);
        expression = "3 + 2.4"; // 5.4
        result = calculator.evaluate(expression);
        System.out.println(result);
        expression = "(3 + 4)*2.4"; //= 16.8
        result = calculator.evaluate(expression);
        System.out.println(result);
        expression = "3in * 2.4"; //= 7.2in
        result = calculator.evaluate(expression);
        System.out.println(result);
        expression = "4pt+(3in*2.4)"; // = 522.4pt
        result = calculator.evaluate(expression);
        System.out.println(result);
        expression = "(3 + 2.4) in"; // = 5.4in
        result = calculator.evaluate(expression);
        System.out.println(result);
        expression = "(3in * 2.4) pt"; // = 518.4pt
        result = calculator.evaluate(expression);
        System.out.println(result);

//		while (true) {
//			// display prompt
//			System.out.print("> ");
//			// read input
//			expression = in.nextLine().trim();
//			// terminate if input empty
//			if (expression.equals(""))
//				break;
//
//			// evaluate
//			calculator = new MultiUnitCalculator();
//			result = calculator.evaluate(expression);
//			// display result
//			System.out.println(result);
//		}
    }
}

class Lexer2 {

    /**
     * Token in the stream.
     */
    public class Token {
        final Type type;
        final String text;

        Token(Type type, String text) {
            this.type = type;
            this.text = text;
        }

        Token(Type type) {
            this(type, null);
        }

        @Override
        public String toString() {
            return String.format(this.text + " " + this.type);
        }
    }

    @SuppressWarnings("serial")
    class TokenMismatchException extends Exception {
        @Override
        public String getMessage() {
            return "One or more items were not recognized";
        }
    }

    private ArrayList<Token> problem;
    private int nextCount = -1;

    public Lexer2(String input) {//throws TokenMismatchException {
        input = input.replaceAll("\\s", "");
        problem = new ArrayList<Token>();

        String currentArg;
        int count = 0;
        while (count < input.length()) {
            currentArg = input.substring(count, count + 1);
            if (currentArg.matches("(\\d||\\.)")) {
                String number = "";
                while (currentArg.matches("(\\d||\\.)")) {
                    number += currentArg;
                    count++;
                    if (count < input.length()) {
                        currentArg = input.substring(count, count + 1);
                    } else {
                        break;
                    }
                }
                count--;
                problem.add(new Token(Type.NUMBER, number));
            } else if (currentArg.equals("(")) {
                problem.add(new Token(Type.L_PAREN));
            } else if (currentArg.equals(")")) {
                problem.add(new Token(Type.R_PAREN));
            } else if (currentArg.equals("+")) {
                problem.add(new Token(Type.PLUS));
            } else if (currentArg.equals("-")) {
                problem.add(new Token(Type.MINUS));
            } else if (currentArg.equals("*")) {
                problem.add(new Token(Type.TIMES));
            } else if (currentArg.equals("/")) {
                problem.add(new Token(Type.DIVIDE));
            } else if (currentArg.matches("(i|p)") && count < input.length() - 1) {
                currentArg = input.substring(count, count + 2);
                count++;
                if (currentArg.equals("in")) {
                    problem.add(new Token(Type.INCH));
                } else if (currentArg.equals("pt")) {
                    problem.add(new Token(Type.POINT));
                }// else {
//                    throw new TokenMismatchException();
//                }
            }// else {
//                throw new TokenMismatchException();
//            }
            count++;
        }
    }

    public Token getNext() {
        if (nextCount < problem.size() - 1) {
            nextCount += 1;
            return problem.get(nextCount);
        }
        return null;
    }
}


class Parser2 {
    @SuppressWarnings("serial")
    static class ParserException extends RuntimeException {
    }

    /**
     * Type of values.
     */
    private enum ValueType {
        POINTS, INCHES, SCALAR
    }

    /**
     * Internal value is always in points.
     */
    public class Value {
        double value;
        ValueType type;

        Value(double value, ValueType type) {
            this.value = value;
            this.type = type;
        }

        public void convert(ValueType type) {
            if (this.type == type) {
                return;
            } else {
                if (type == ValueType.POINTS) {
                    this.type = type;
                } else if (type == ValueType.INCHES) {
                    if (this.type == ValueType.SCALAR) {
                        this.value *= PT_PER_IN;
                    }
                    this.type = type;
                } else {
                    throw new ParserException();
                }
            }
        }

        @Override
        public String toString() {
            switch (type) {
                case INCHES:
                    return Math.round(value / PT_PER_IN * 100.0) / 100.0 + " in";
                case POINTS:
                    return Math.round(value * 100.0) / 100.0 + " pt";
                default:
                    return "" + Math.round(value * 100.0) / 100.0;
            }
        }
    }

    private static final double PT_PER_IN = 72;
    private final Lexer2 lexer;
    private Lexer2.Token lookingAt;

    Parser2(Lexer2 lexer) {
        this.lexer = lexer;
        next();
    }

    Value evaluate() throws ParserException {
        Value val = parse();
        if (lookingAt != null) {
            throw new ParserException();
        }
        return val;
    }

    private Type type() {
        if (lookingAt == null) {
            return null;
        }
        return lookingAt.type;
    }

    private void next() {
        lookingAt = lexer.getNext();
    }

    private Value single() {
        Value one;

        if (type() == Type.L_PAREN) {
            next();
            one = parse();
            if (type() == Type.R_PAREN) {
                next();
            } else {
                throw new ParserException();
            }
        } else if (type() == Type.NUMBER) {
            one = new Value(Double.valueOf(lookingAt.text), ValueType.SCALAR);
            next();
        } else {
            throw new ParserException();
        }

        if (type() == Type.POINT) {
            one.convert(ValueType.POINTS);
            next();
        } else if (type() == Type.INCH) {
            one.convert(ValueType.INCHES);
            next();
        }
        return one;
    }

    private Value parse() {
        Value left = single();
        Type theType = type();

        if (theType == Type.INCH) {
            next();
            if (left.type == ValueType.INCHES) {
                return left;
            } else if (left.type == ValueType.POINTS) {
                return new Value(left.value, ValueType.INCHES);
            } else if (left.type == ValueType.SCALAR) {
                return new Value(left.value * PT_PER_IN, ValueType.INCHES);
            }
        }

        if (theType == Type.POINT) {
            next();
            if (left.type == ValueType.POINTS) {
                return left;
            } else if (left.type == ValueType.INCHES) {
                return new Value(left.value, ValueType.POINTS);
            } else if (left.type == ValueType.SCALAR) {
                return new Value(left.value, ValueType.POINTS);
            }
        }

        if (theType == Type.PLUS || theType == Type.MINUS || theType == Type.TIMES || theType == Type.DIVIDE) {
            next();
            Value right = single();
            ValueType unit;
            if (left.type == ValueType.SCALAR) {
                unit = right.type;
            } else if (theType == Type.DIVIDE) {
                unit = ValueType.SCALAR;
            } else {
                unit = left.type;
            }

            double leftVal = left.value;
            double rightVal = right.value;
            if (unit == ValueType.INCHES) {
                if (left.type == ValueType.SCALAR) {
                    leftVal *= PT_PER_IN;
                }
                if (right.type == ValueType.SCALAR) {
                    rightVal *= PT_PER_IN;
                }
            }

            if (theType == Type.PLUS) {
                return new Value(leftVal + rightVal, unit);
            } else if (theType == Type.MINUS) {
                return new Value(leftVal - rightVal, unit);
            } else if (theType == Type.TIMES) {
                if (unit == ValueType.INCHES) {
                    return new Value(leftVal * rightVal / PT_PER_IN, unit);
                }
                return new Value(leftVal * rightVal, unit);
            } else if (theType == Type.DIVIDE) {
                if (unit == ValueType.INCHES) {
                    return new Value(leftVal / rightVal * PT_PER_IN, unit);
                }
                return new Value(leftVal / rightVal, unit);
            }
        }

        return left;
    }
}

