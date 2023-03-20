package HW1.HW_1_3;

public class Circle extends Figure {
    private static final int PI = 3;
    private int radius;

    private void example (int radius, Figure circle){
        int areaCirle = area(radius,PI);
        System.out.println("Площадь круга = " + areaCirle);
    }

    @Override
    public int area(int radius, int PI) {
        return radius*radius*PI;
    }
}
