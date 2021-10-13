package end;

public class Task_9 {
  
    static int MODULE = 41;
    static int A = 3;
    static int B = 7;
    static int randomX = 7;
    static int randomY;
    static int K;
    static int nextX;
    static int nextY;
    static int nextK;
    static int singular = Integer.MAX_VALUE;

    public static void main(String[] args) {
        checkingSatisfyEquation();
        checkingRandomX();
        findingK();
        findingPointSecond();
        findingNextPoint();
    }

    private static boolean checkingSatisfyEquation() {
        if ((4 * Math.pow(A, 3) + 27 * Math.pow(B, 2)) % MODULE != 0) {
            System.out.println("А и В удоволетворяют условию.");
            return true;
        } else {
            System.out.println("A И В не удоволетворяют условию.");
            return false;
        }
    }

    private static void checkingRandomX() {
        int result = ((int) Math.pow(randomX, 3) + 3 * randomX + 7) % MODULE;
        randomY = findingY(result);
    }

    private static int findingY(int result) {
        for (int y = 1; y < Integer.MAX_VALUE; y++) {
            if (y * y % MODULE == result) {
                return y;
            }
        }
        throw new RuntimeException("Для данного 'x' не существует 'у' ");
    }

    private static void findingK() {
        int partOne = (int) ((3 * Math.pow(randomX, 2) + A) % MODULE);
        int partTwo = randomY * 2;
        for (int k = 0; k < Integer.MAX_VALUE; k++) {
            if (partTwo * k % MODULE == partOne) {
                K = k;
                break;
            }
        }
    }

    private static void findingPointSecond() {
        int temp = (int) (Math.pow(K, 2) - 2 * randomX);
        nextX = Math.floorMod(temp, MODULE);
        temp = K * (randomX - nextX) - randomY;
        nextY = Math.floorMod(temp, MODULE);
        System.out.println("Точка 2 подгруппы: у = " + nextY + " , х = " + nextX);
    }

    private static void findingNextPoint() {
        for (int i = 3; i < singular; i++) {
            int tempK = findingNextPointK();
            int tempX = Math.floorMod((int) (Math.pow(tempK, 2) - randomX - nextX), MODULE);
            int tempY = Math.floorMod((tempK * (randomX - tempX) - randomY), MODULE);
            System.out.println("Точка " + i + " подгруппы: k = " + tempK + " , х = " + tempX + " , y = " + tempY);
            nextX = tempX;
            nextY = tempY;
            nextK = tempK;
            if (nextX == randomX) {
                singular = i + 1;
                System.out.println("Точка бесконечности была найдена.");
            }
        }
    }

    private static int findingNextPointK() {
        int partOne = Math.floorMod((nextY - randomY), MODULE);
        int partTwo = nextX - randomX;
        for (int k = 0; k < Integer.MAX_VALUE; k++) {
            if (Math.floorMod(partTwo * k, MODULE) == partOne) {
                return k;
            }
        }
        throw new RuntimeException("Угловой коэффициент не был найден.");
    }
}
