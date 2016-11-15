package BeanGrinder.Week8.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by HanWei on 9/11/2016.
 */
public class Calculator {
    /**
     * @param expression: a String representing multi-unit expression, as defined in the problem set
     * @return the value of the expression, as a number possibly followed by units, e.g. "72pt", "3", or "4.882in"
     */
    public String evaluate(String expression) {
        Lexer lexer = new Lexer(expression);
        Parser parser = new Parser(lexer);
        return parser.evaluate().toString();
    }

    public static void main(String[] args) {
        MultiUnitCalculator calculator = new MultiUnitCalculator();
        String result;
        String expression;

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
        expression = "2 + (1 * 5)in - 3"; //
        result = calculator.evaluate(expression);
        System.out.println(result);
    }
}

/**
 * Calculator lexical analyzer.
 */
class Lexer {
    /**
     * Token in the stream.
     */
    static class Token {
        final Type type;
        final String text;

        Token(Type type, String text) {
            this.type = type;
            this.text = text;
        }

        Token(Type type) {
            this(type, null);
        }
    }

    @SuppressWarnings("serial")
    static class TokenMismatchException extends RuntimeException {
    }

    private final BufferedReader input;

    Lexer(String input) {
        StringReader sr = new StringReader(input);
        this.input = new BufferedReader(sr);
    }

    /**
     * Generates a new token from the input stream.
     *
     * @throws TokenMismatchException
     *             if no token can be matched to the input
     * @return the next token from the input stream or null if there is none.
     */
    Token next() {
        try {
            // skip white space
            int next;
            do
                next = input.read();
            while (isWhitespace(next));

            switch (next) {
                case -1:
                    // nothing to read
                    return null;
                case '(':
                    return new Token(Type.L_PAREN);
                case ')':
                    return new Token(Type.R_PAREN);
                case '+':
                    return new Token(Type.PLUS);
                case '-':
                    return new Token(Type.MINUS);
                case '*':
                    return new Token(Type.TIMES);
                case '/':
                    return new Token(Type.DIVIDE);
                case 'i':
                    next = input.read();
                    if (next == 'n')
                        return new Token(Type.INCH);
                    else
                        throw new TokenMismatchException();
                case 'p':
                    next = input.read();
                    if (next == 't')
                        return new Token(Type.POINT);
                    else
                        throw new TokenMismatchException();
            }

            // rule DIGIT?+ ['.' DIGIT*]
            final StringBuilder sb = new StringBuilder();
            // DIGIT
            if (isDigit(next) || next == '.') {
                if (next != '.') {
                    sb.append((char) next);

                    // DIGIT*
                    while (true) {
                        input.mark(1);
                        next = input.read();
                        if (isDigit(next)) {
                            sb.append((char) next);
                        } else
                            break;
                    }
                }

                // '.'
                if (next == '.') {
                    sb.append((char) next);

                    // DIGIT *
                    while (true) {
                        input.mark(1);
                        next = input.read();
                        if (isDigit(next)) {
                            sb.append((char) next);
                        } else
                            break;
                    }
                }

                // non-digit, reset
                if (!isDigit(next))
                    input.reset();

                return new Token(Type.NUMBER, sb.toString());
            }

            throw new TokenMismatchException();
        } catch (IOException io) {
            return null;
        }
    }

    private boolean isDigit(int i) {
        return (i >= '0' && i <= '9');
    }

    private boolean isWhitespace(int i) {
//        return i == ' ' || i == '    ';
        return i == ' ' || i == '\t';
    }
}


/**
 * Calculator parser. All values are measured in pt.
 */
class Parser {
    @SuppressWarnings("serial")
    static class ParserException extends RuntimeException {
    }

    /**
     * Type of values.
     */
    private enum ValueType {
        POINTS, INCHES, SCALAR
    };

    /**
     * Internal value is always in points.
     */
    public class Value {
        double value;
        double value1;
        ValueType type;

        public Value(double value, ValueType type) {
            this.value = value;
            this.type = type;
        }

        public void convert(ValueType type) {
            if (this.type == type) {
                return;
            } else {
                switch (type) {
                    case INCHES:
                        if (this.type == ValueType.SCALAR) {
                            this.value *= PT_PER_IN;
                        }
                        this.type = type;
                        return;
                    case POINTS:
                        this.type = type;
                        return;
                }
                throw new ParserException();
            }
        }

        @Override
        public String toString() {
            switch (type) {
                case INCHES:
                    value = value / PT_PER_IN;
                    value1 = Math.round(value*100.0)/100.0;
                    return value1 + " in";
                case POINTS:
                    value1 = Math.round(value*100.0)/100.0;
                    return value1 + " pt";
                default:
                    value1 = Math.round(value*100.0)/100.0;
                    return "" + value1;
            }
        }
    }

    private static final double PT_PER_IN = 72;
    private final Lexer lexer;
    private Lexer.Token current;

    Parser(Lexer lexer) {
        this.lexer = lexer;
        advance();
    }

    /**
     * Parses and evaluates according to the initial production rule.
     */
    Value evaluate() {
        Value value = composite();
        // at this point there should be nothing left in the expression
        if (current != null) {
            throw new ParserException();
        }

        return value;
    }

    /**
     * modifies current to lexer's next token
     */
    private void advance() {
        this.current = lexer.next();
    }

    /**
     * Type of the current token or null if the current token is null.
     *
     * @return Type of current if not null
     */
    private Type token() {
        return current == null ? null : current.type;
    }

    // UNARY
    /**
     *
     * @return a Value representing the value of the expression immediately to
     *         the right
     */
    private Value unary() {
        Value value;

        // L_PAREN COMPOSITE R_PAREN
        if (token() == Type.L_PAREN) {
            advance();
            value = composite();
            if (token() == Type.R_PAREN) {
                advance();
            } else {
                throw new ParserException();
            }

            // NUMBER [IN | PT]
        } else if (token() == Type.NUMBER) {
            value = new Value(Double.valueOf(current.text), ValueType.SCALAR);
            advance();
        } else {
            throw new ParserException();
        }

        if (token() == Type.POINT) {
            advance();
            value.convert(ValueType.POINTS);

        } else if (token() == Type.INCH) {
            advance();
            value.convert(ValueType.INCHES);

        }
        return value;
    }

    // COMPOSITE
    /**
     *
     *
     * @return Value of
     */
    private Value composite() {
        // MINUS UNARY
        /*
         * if (token() == Type.MINUS) { advance(); Value sub = unary(); return new
         * Value(-sub.value, sub.type); }
         */
        final Value left = unary();
        final Type type = token();

        // UNARY UNIT
        if (type == Type.INCH) {
            advance();
            switch (left.type) {
                case INCHES:
                    return left;
                case POINTS:
                    return new Value(left.value, ValueType.INCHES);
                case SCALAR:
                    return new Value(left.value * PT_PER_IN, ValueType.INCHES);
            }
        }

        if (type == Type.POINT) {
            advance();
            switch (left.type) {
                case INCHES:
                    return new Value(left.value, ValueType.POINTS);
                case POINTS:
                    return left;
                case SCALAR:
                    return new Value(left.value, ValueType.POINTS);
            }
        }

        // UNARY (PLUS | MINUS | TIMES | DIVIDE) UNARY
        if (type == Type.PLUS || type == Type.MINUS || type == Type.DIVIDE || type == Type.TIMES) {
            advance();
            Value right = unary();

            // inherit unit of the left expression unless one of them is a
            // scalar
            ValueType units;
            if (left.type == ValueType.SCALAR)
                units = right.type;
            else if (right.type == ValueType.SCALAR)
                units = left.type;
            else if (type == Type.DIVIDE)
                units = ValueType.SCALAR;
            else
                units = left.type;

            // convert scalars to inches if necessary
            double leftValue = left.value;
            double rightValue = right.value;
            if (units == ValueType.INCHES) {
                if (left.type == ValueType.SCALAR) {
                    leftValue *= PT_PER_IN;
                }
                if (right.type == ValueType.SCALAR) {
                    rightValue *= PT_PER_IN;
                }
            }

            // perform operations
            switch (type) {
                case PLUS:
                    return new Value(leftValue + rightValue, units);
                case MINUS:
                    return new Value(leftValue - rightValue, units);
                case DIVIDE:
                    if (units == ValueType.INCHES) {
                        return new Value(leftValue * PT_PER_IN / rightValue, units);
                    }
                    return new Value(leftValue / rightValue, units);
                case TIMES:
                    if (units == ValueType.INCHES) {
                        return new Value(leftValue * rightValue / PT_PER_IN, units);
                    }
                    return new Value(leftValue * rightValue, units);
            }
        }

        // UNARY
        return left;
    }
}

////****