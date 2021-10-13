package end;

public class Task_8 {

    public static final int FIELD_SIZE = 256;
    public static final int POLYNOMIAL = 29;
    static final public short[] INDEX = generateLogTable();
    static final short[] ALPHA = generateExpTable();

    public static void main(String[] args) {
    }

    public static short add(int a, int b) {
        return (short) (a ^ b);
    }

    public static short sub(int a, int b) {
        return (short) (a ^ b);
    }

    public static short multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            int A = INDEX[a];
            int B = INDEX[b];
            int res = A + B;
            if (255 <= res) {
                res -= 255;
            }
            return ALPHA[res];
        }
    }

    public static short divide(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            System.out.println("Деление на 0");
        }
        int A = INDEX[a];
        int B = INDEX[b];
        int res = A - B;
        if (255 <= res) {
            res -= 255;
        }
        return ALPHA[res];
    }

    public static short exp(int a, int n) {
        if (n == 0) {
            return 1;
        } else if (a == 0) {
            return 0;
        } else {
            int A = INDEX[a];
            int res = A * n;
            while (255 <= res) {
                res -= 255;
            }
            return ALPHA[res];
        }
    }

    public static short[] generateLogTable() {
        short[] res = new short[FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            res[i] = -1;
        }
        int b = 1;
        for (int log = 0; log < FIELD_SIZE - 1; log++) {
            if (res[b] != -1) {
                throw new RuntimeException("Не полином");
            }
            res[b] = (short) log;
            b = (b << 1);
            if (FIELD_SIZE <= b) {
                b = ((b - FIELD_SIZE) ^ POLYNOMIAL);
            }
        }
        return res;
    }

    public static short[] generateExpTable() {
        final short[] res = new short[FIELD_SIZE];
        for (int i = 1; i < FIELD_SIZE; i++) {
            int log = INDEX[i];
            res[log] = (short) i;
        }
        return res;
    }
}
