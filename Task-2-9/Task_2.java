package end;

public class Task_2 {
    public static void main(String[] args) {
        System.out.println(Ordinary.NOD(30, 6));
    }
}
class Ordinary {
    public static int NOD(int one, int two) {
        while ((one != 0) && (two != 0)) {
            if (one > two) {
                one = one % two;
            } else {
                two = two % one;
            }
        }
        return one + two;
    }
}

class NotOrdinary {
    public static void NOD(int one, int two) {

    }
}
