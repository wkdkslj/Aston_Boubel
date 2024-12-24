import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(rangeOfSum(5, 7));
        checkIfPositiveValue(4);
        System.out.println(checkIfNegativeValue(-300));
        printNTimes("привет", 4);
        System.out.println(year(1969));
        array();
        amptyArray();
        multiplicationArray();
        matrix();
        System.out.println(Arrays.toString(createArray(5, 99)));
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 3, b = -6, sum = a + b;
        String result = sum < 0 ? "Сумма отрицательная" : "Сумма положительная";
        System.out.println(result);
        /*if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }*/
    }

    public static void printColor() {
        int value = -45;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value < 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 7;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean rangeOfSum(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void checkIfPositiveValue(int number) {
        String result = number < 0 ? "отрицательное" : "положительное";
        System.out.println(result);
    }

    public static boolean checkIfNegativeValue(int number) {
        return number < 0;
    }

    public static void printNTimes(String text, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(text);
        }
    }

    public static boolean year(int year) {
        return year % 100 != 0 && (year % 4 == 0 || year % 400 == 0);
    }

    public static void array() {
        int[] array = {1, 0, 1, 1, 0, 1, 1, 1, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void amptyArray() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void multiplicationArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        {
            for (int i = 0; i < array.length; i++) {
                if (array[i] <= 6) {
                    array[i] *= 2;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }

    public static void matrix() {
        int[][] table = new int[5][5];
        for (int i = 0; i < table.length; i++) {
            table[i][i] = 1;
            table[i][table.length - 1 - i] = 1;
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + "");
            }
            System.out.println();
        }
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
