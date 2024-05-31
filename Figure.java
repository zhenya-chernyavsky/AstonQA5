/*Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
круг, прямоугольник, треугольник.
        Задать для каждой фигуры цвет заливки и цвет границы.

        Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.

        Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных методов в интерфейсе.
*/
public class Figure {
    public static void main(String[] args) {

        Circle circle = new Perimetr();
        System.out.println("Периметр круга " + circle.perimeterC(5));
        System.out.println("Площадь круга " + circle.areaC(5));
        circle.setColors("Красный", "Белый");

        Rectangle rectangle = new Perimetr();
        System.out.println("Периметр прямоугольника " + rectangle.perimeterR(2,3));
        System.out.println("Площадь прямоугольника " + rectangle.areaR(2,3));
        rectangle.setColors("Красный", "Синий");

        Triangle triangle = new Perimetr();
        System.out.println("Периметр треугольника " + triangle.perimeterT(3,4,5));
        System.out.println("Площадь треугольника " + triangle.areaT(3,4));
        triangle.setColors("Желтый", "Синий");
    }
}
class Perimetr implements Circle, Rectangle, Triangle {
    @Override
    public void setColors(String fillColor, String borderColor) {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}
interface Circle {
    default double perimeterC(int r) {
        return 2 * Math.PI * r;
        }
    default double areaC(int r) {
        return Math.PI * r * r;
    }
    void setColors(String fillColor, String borderColor);
    }
interface Rectangle {
    default int perimeterR(int a, int b) {
        return 2 * (a + b);
    }
    default int areaR(int a, int b) {
        return a * b;
    }
    void setColors(String fillColor, String borderColor);
    }
interface Triangle {
    default int perimeterT(int a, int b, int c) {
        return a + b + c;
    }
    default int areaT(int a, int b) {
        return  a * b / 2;
    }
    void setColors(String fillColor, String borderColor);
}