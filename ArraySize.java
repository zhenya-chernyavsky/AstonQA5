public class ArraySize {

    // Проверка размера массива
    public void checkArraySize(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен иметь 4 строки.");
        }

        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Массива должен иметь 4 столбца.");
            }
        }
    }

    // Суммирование элементов массива
    public int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        checkArraySize(array);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Здесь неверные данные [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArraySize checker = new ArraySize();

        // Неправильный массив 1

        String[][] arrayFail = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15",}
        };

        // Неправильный массив 2

        String[][] arrayError = {
                {"1", "$", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Правильный массив

        String[][] arrayCorrect= {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = checker.sumArray(arrayFail);
            System.out.println("Сумма элементов в arrayFail: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка в arrayFail: " + e.getMessage());
        }

        try {
            int sum = checker.sumArray(arrayError);
            System.out.println("Сумма элементов в arrayError: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка в arrayError: " + e.getMessage());
        }

        try {
            int sum = checker.sumArray(arrayCorrect);
            System.out.println("Сумма элементов в arrayCorrect: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка в arrayCorrect: " + e.getMessage());
        }
    }
}