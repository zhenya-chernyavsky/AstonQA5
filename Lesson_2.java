import java.util.Arrays;

public class Lesson_2 {
    public static void main(String[] args) {
        System.out.println("Задача 1.");
        printThreeWords();
        System.out.println("Задача 2.");
        checkSumSign();
        System.out.println("Задача 3.");
        printColor();
        System.out.println("Задача 4.");
        compareNumbers();
        System.out.println("Задача 5.");
        System.out.println(wholeNumbers(7, 3));
        System.out.println("Задача 6.");
        plusMinus(0);
        System.out.println("Задача 7.");
        System.out.println(trueAndFalse(7));
        System.out.println("Задача 8.");
        stringNumber("Hello",2);
        System.out.println("Задача 9.");
        System.out.println(leapYear(100));
        System.out.println("Задача 10.");
        change();
        System.out.println("Задача 11.");
        oneHundred();
        System.out.println("Задача 12.");
        sixXTwo();
        System.out.println("Задача 13.");
        box();
        System.out.println("Задача 14.");
        System.out.println(Arrays.toString(line(7, 3)));
    }
    /*1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова:
    Orange, Banana, Apple.*/
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    /*2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
    и инициализируйте их любыми значениями, которыми захотите.
    Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
    то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;*/
    public static void checkSumSign() {
        int a = -4;
        int b = 3;
        if (a + b > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    /*3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
    Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
    если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно),
    то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;*/
    public static void printColor() {
        int value = 99;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
                System.out.println("Желтый");
            } else if (value > 100) {
                    System.out.println("Зеленый");
                }
    }
    /*4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
    и инициализируйте их любыми значениями, которыми захотите.
    Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;*/
    public static void compareNumbers() {
        int a = -4;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
                System.out.println("a < b");
            }
    }
    /*5. Напишите метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false.*/
    public static boolean wholeNumbers(int num1, int num2) {
        return num1 + num2 >= 10 && num1 + num2 <= 20;
    }
    /* 6. Напишите метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.*/
    public static void plusMinus(int x) {
        if (x >= 0) {
            System.out.println(x + " -Положительное число");
        } else {
            System.out.println(x + " -Отрицательное число");
        }
        System.out.println(" ");
    }
    /*7. Напишите метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.*/
    public static boolean trueAndFalse(int num) {
        return num < 0;
    }
    /*8. Напишите метод, которому в качестве аргументов передается строка и число,
    метод должен отпечатать в консоль указанную строку, указанное количество раз;*/
    public static void stringNumber(String str, int num) {
        for (int counter = 0; counter < num; counter++){
            System.out.println(str);
        }
    }
    /*9. Напишите метод, который определяет, является ли год високосным,
    и возвращает boolean (високосный - true, не високосный - false).
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.*/
    public static boolean leapYear(int year) {

        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
    /*10. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
    public static void change() {
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
            } else {
                nums[i] = 0;}
        }
    for (int i = 0; i < nums.length; i++) {
        System.out.print(nums[i] + " ");
    }
        System.out.println(" ");
        System.out.println(" ");
    }
    /*11. Задать пустой целочисленный массив длиной 100.
    С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;*/

    public static void oneHundred() {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i+1;
        }
        System.out.println(Arrays.toString(nums));
    }
    /*12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    и числа меньше 6 умножить на 2;*/
    public static void sixXTwo() {
        int[] nums = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] = nums[i] * 2;
            }   else {
            }
    }
        System.out.println(Arrays.toString(nums));
}
    /*13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    (можно только одну из диагоналей, если обе сложно).
    Определить элементы одной из диагоналей можно по следующему принципу:
    индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];*/
    public static void box() {
        int counter = 1;
        int[][] nums = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    nums[i][j] = 1;
                }
            }
        }
        for (int i = 0; i< nums.length; i++) {
            for (int j = 0; j< nums.length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*14. Написать метод, принимающий на вход два аргумента:
    len и initialValue, и возвращающий одномерный массив типа int длиной len,
    каждая ячейка которого равна initialValue.*/
    public static int[] line(int len, int initialValue) {
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = initialValue;
        }
        return nums;
    }

}