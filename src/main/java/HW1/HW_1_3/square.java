package HW1.HW_1_3;

public class square extends Figure{

    private int side1;
    private int side2;

    private void area() {
        System.out.println("Площадь квадрата");
    }

    @Override
    public int area(int side1, int side2) {
        return side1*side2;
    }
}
