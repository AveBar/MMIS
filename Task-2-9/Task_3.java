/* передает уравнение вида a * x + b = 0 */
packageend;

import java.math.BigInteger;

public class Task_3 {
    public static void main(String[] args) {
 Line(0, 0);
    }
    
    private static void Line(int a, int b) {
        BigInteger A = BigInteger.valueOf(Integer.valueOf(a));
        BigInteger B = BigInteger.valueOf(Integer.valueOf(b));
        if (a != 0) {
            BigInteger X = (Bdivide(A)).multiply(BigInteger.valueOf(-));
            System.out.println("x = " + X + " уравнение.");
 } else if (b != 0) {
            System.out.println("Решения нет");
 } else {
            System.out.println("X - любое число");
        }
    }
}
