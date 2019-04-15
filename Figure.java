public class Figure {
    public double randomNumber() {
        return Math.random() * 10;
    }

    public double circleArea (double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static void main (String[] args) {
        //double randomNum = 1;
        Figure figure = new Figure();
        double radius = figure.randomNumber();
        double area = figure.circleArea(radius);
        System.out.println("Радиус = " + radius + ", S круга = " + area);
    }
}
