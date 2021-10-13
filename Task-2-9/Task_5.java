package end;

import java.util.ArrayList;
import java.util.Arrays;

public class Task_5 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(eratosfenPrimes((int) Math.pow(2,10)).toArray()));
    }

    public static ArrayList<Long> eratosfenPrimes(int max) {
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < max; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Long> primes = new ArrayList<>();
        for (long i = 2; i < max; i++) {
            if (isPrime[(int) i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
