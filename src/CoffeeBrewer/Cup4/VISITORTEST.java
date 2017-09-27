package CoffeeBrewer.Cup4;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

/**
 * Created by HanWei on 8/12/2016.
 */
public class VISITORTEST {
    public static void main(String[] args) {
        String ans = "";
        ArrayList<Visitable> items = new ArrayList<Visitable>();
        AreaVisitor areaVisitor = new AreaVisitor();
        PerimeterVisitor perimeterVisitor = new PerimeterVisitor();

        items.add(new Circle(1));
        items.add(new Square(2));
        items.add(new Rectangle(2, 4));
        items.add(new Circle(2));

        for (Visitable item :
                items) {
            item.accept(areaVisitor);
            item.accept(perimeterVisitor);
        }

        ans = "" + Math.ceil(areaVisitor.getTotal());
        System.out.println(ans);

        ans = "" + Math.ceil(perimeterVisitor.getTotal());
        System.out.println(ans);
    }

}
