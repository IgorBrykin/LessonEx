package my.array.exeption;

public class MyArraySizeException extends Exception {

    public MyArraySizeException(String message) {
        super(message + " Массив не соответствует");
    }
}
