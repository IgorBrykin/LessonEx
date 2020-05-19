package my.array.exeption;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, int i, int j) {
        super(message + " В ячейке текст" + i + ":" + j);
    }

}
