package CoffeeBrewer.Cup4;

/**
 * Created by HanWei on 8/12/2016.
 */
interface Visitable {
    void accept(Visitor visitor);
}

interface Visitor {
    void visit(Circle circle);

    void visit(Square square);

    void visit(Rectangle rectangle);
}

public class AreaVisitor implements Visitor {
    private double total = 0;  //total area

    public void visit(Circle circle) {
        total += Math.PI * Math.pow(circle.getRadius(), 2);
    }

    public void visit(Square square) {
        total += Math.pow(square.getLengthOfSide(), 2);
    }

    public void visit(Rectangle rectangle) {
        total += rectangle.getHeight() * rectangle.getWidth();
    }

    public double getTotal() {
        return total;
    }
}

class PerimeterVisitor implements Visitor {
    private double total = 0; //total perimeter

    public void visit(Circle circle) {
        total += 2 * Math.PI * circle.getRadius();
    }

    public void visit(Square square) {
        total += 4 * square.getLengthOfSide();
    }

    public void visit(Rectangle rectangle) {
        total += 2 * rectangle.getWidth() + 2 * rectangle.getHeight();
    }

    public double getTotal() {
        return total;
    }
}

// TODO: (5) modify Circle, Rectangle and Square classes to implement Visitable
class Circle implements Visitable {
    private double radius;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}


class Rectangle implements Visitable {
    private double width;
    private double height;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

class Square implements Visitable {
    private double lengthOfSide;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    Square(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    public double getLengthOfSide() {
        return lengthOfSide;
    }
}