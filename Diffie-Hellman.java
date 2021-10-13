import java.math.BigInteger;

public class DiffieHellman {

    static BigInteger p = BigInteger.valueOf(23);
    static BigInteger g = BigInteger.valueOf(5);
     staticint a  =6;
    static int b = 15;

    public static void main(String[] args) {
        BigInteger A = g.pow(a).mod(p);
        BigInteger B = g.pow(b).mod(p);
        BigInteger Apow_b = A.pow(b).mod(p);
        BigInteger Bpow_a = B.pow(a).mod(p);
        BigInteger g_pow_a_and_b = g.pow(a*b).mod(p);
        System.out.println(A);
        System.out.println(B);
        System.out.println(Apow_b);
        System.out.println(Bpow_a);
        System.out.println(g_pow_a_and_b);
    }


}
