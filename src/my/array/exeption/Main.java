package my.array.exeption;

/*
1. Напишите метод, на вход которого подается двумерный
строковый массив размером 4х4, при подаче массива другого
размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива,
преобразовать в int, и просуммировать. Если в каком-то
элементе массива преобразование не удалось (например,
в ячейке лежит символ или текст вместо числа), должно
быть брошено исключение MyArrayDataException – с детализацией,
в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать
возможные исключения MySizeArrayException и
MyArrayDataException и вывести результат расчета.
*/
public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arr = {
                {"12", "34", "56", "78"},
                {"12", "34", "56", "78"},
                {"12", "34", "56", "78"},
                {"12", "34", "56", "78"}
        };

        String[][] arr2 = {
                {"1w2", "34", "56", "78"},
                {"12", "34", "56", "78"},
                {"12", "34", "56", "78"}
        };

        arraysInit(arr);
        try {
            arraysInit(arr2);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int arraysInit(String[][] arr) throws MyArraySizeException,MyArrayDataException {
        int sumArr = 0;

        try {
            if (arr.length != 4) {
                throw new MyArraySizeException("Массив не соответствует параметрам 4x4");
            }
            for (String[] item : arr) {
                if (item.length != 4) {
                    throw new MyArraySizeException("Массив не соответствует параметрам 4x4");
                }
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                try {
                    sumArr +=Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    new MyArrayDataException(e.getMessage(),i,j);
                    e.printStackTrace();
                }
            }
        }
        return sumArr;
    }
}

