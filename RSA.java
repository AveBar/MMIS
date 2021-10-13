package end;

import java.util.ArrayList;
import java.util.Iterator;

public class RSA {
    private static long simpleOne = 7;
    private static long simpleTwo = 11;
    private static ArrayList<Long> list = Task_5.eratosfenPrimes((int) Math.pow(3, 10));
    private final static char[] Alpha = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    private final static byte[] pos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};

    public static void main(String[] args) {
        long multiplication = simpleOne * simpleTwo;
        long functionEller = (simpleOne - 1) * (simpleTwo - 1);
        System.out.println("Эллер = " + functionEller);
        long number_E = chooseNumber(functionEller);
        System.out.println("Чилос 'е' " + number_E);
        long protectKey = chooseProtectKey(functionEller, number_E);
        System.out.println("Число 'd' " + protectKey);
        long letter = cipherLetter('б', number_E, multiplication);
        System.out.println(openMessage(letter, protectKey, multiplication));
    }

    private static long chooseNumber(long functionEller) {
        Iterator<Long> iterator = list.iterator();
        while (iterator.hasNext()) {
            long n = iterator.next();
            if (functionEller % n != 0) {
                return n;
            }
        }
        return 0;
    }

    private static long chooseProtectKey(long functionEller, long number_E) {
        if (number_E * pow(number_E, functionEller - 1, functionEller) % functionEller == 1) {
            return pow(number_E, functionEller - 1, functionEller);
        } else {
            return number_E;
        }
    }

    private static long pow(long a, long j, long mod) {
        if (j == 1) {
            return a;
        }
        if (j % 2 == 0) {
            long t = pow(a, j / 2, mod);
            return t * t % mod;
        } else {
            return pow(a, j - 1, mod) * a % mod;
        }
    }

    private static long cipherLetter(char letter, long number_E, long multiplication) {
        for (int i = 0; i < Alpha.length; i++) {
            if (letter == Alpha[i]) {
                return pow(pos[i], number_E, multiplication) % multiplication;
            }
        }
        return 0;
    }

    private static long openMessage(long letter, long protectKey, long multiplication) {
        return pow(letter, protectKey, multiplication) % multiplication;
    }
}

