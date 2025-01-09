public interface Figure {
    double getArea();

    double getPerimeter();

    String getFillColor();

    String getBorderColor();

    default double calculatePerimeter() {
        return getPerimeter();
    }

    default double calculateArea() {
        return getArea();
    }

    default void printInfo() {
        System.out.println("площадь: " + getArea() + ". периметр: " + getPerimeter() + ". цвет границ: " + getBorderColor() + ". цвет фона: " + getFillColor());
    }
}
