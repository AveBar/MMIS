package end;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        ArrayList<BigInteger> A_i = new ArrayList<>();
        ArrayList<BigInteger> M_i = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество уравнений:");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Введите остаток от деления уравнения:");
            A_i.add(BigInteger.valueOf(scanner.nextInt()));
            System.out.println("Введите модуль уравнения:");
            M_i.add(BigInteger.valueOf(scanner.nextInt()));
        }
        BigInteger M_0 = fullMOD(M_i);
        ArrayList<BigInteger> M_i_from_M_0 = M_i_from_M_0(M_0, M_i);
        ArrayList<BigInteger> y_i = new ArrayList<>();
        for (int i = 0; i < A_i.size(); i++) {
            int y = 0;
            while (true) {
                if ((M_i_from_M_0.get(i).multiply(BigInteger.valueOf(y)).mod(M_i.get(i))).compareTo( A_i.get(i))==0) {
                    y_i.add(BigInteger.valueOf(y));
                    break;
                }
                y++;
            }
        }
        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 0; i < 3; i++) {
            sum = M_i_from_M_0.get(i).multiply(y_i.get(i)).add(sum);
        }
        System.out.println("x = " + sum.mod(M_0));
    }

    private static ArrayList M_i_from_M_0(BigInteger M_0, ArrayList M_i) {
        ArrayList<BigInteger> M_i_from_M_0 = new ArrayList<>();
        for (int i = 0; i < M_i.size(); i++) {
            M_i_from_M_0.add(M_0.divide((BigInteger) M_i.get(i)));
        }
        return M_i_from_M_0;
    }

    static BigInteger fullMOD(ArrayList arr) {
        BigInteger mod = BigInteger.valueOf(1);
        for (Object num : arr) {
            mod = mod.multiply((BigInteger) num);
        }
        System.out.println("mod = " + mod);
        return mod;
    }
}
