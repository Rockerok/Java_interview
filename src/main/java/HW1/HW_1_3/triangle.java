package HW1.HW_1_3;

public class triangle extends Figure{

    private void area() {
        System.out.println("Площадь треугольника");
    }

    @Override
    public int area(int base, int height) {
        return base*height/2;
    }
}
