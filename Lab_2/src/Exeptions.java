import java.io.IOException;

class NullDividedException extends Exception{

    public NullDividedException(){

        super("Попытка деления на ноль!");
        //number=num;
    }
}
class FileAccessException extends Exception {

    public FileAccessException(){

        super("Нет доступа к файлу или файл не существует!");
        //number=num;
    }
}
class LargeValueException extends Exception{

    public LargeValueException(){

        super("Слишком большой рамер массива!");
        //number=num;
    }
}