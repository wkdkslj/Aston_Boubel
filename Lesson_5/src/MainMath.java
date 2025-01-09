public class MainMath {
    public static void main(String[] args) {
        Figure circle = new Circle(2, "черный", "зелёный");
        Figure rectange = new Rectangle(2, 3, "фиолетовый", "розовый");
        Figure traingle = new Traingle(3, 4, 5, "красный", "оранжевый");

        printFigureInfo("круг", circle);
        printFigureInfo("прямоугольник", rectange);
        printFigureInfo("треугольник", traingle);
    }

    private static void printFigureInfo(String name, Figure figure) {
        System.out.println(name + ":");
        figure.printInfo();
    }
}