public class FileAccessException extends Exception {

    public FileAccessException(){
        super("Нет доступа к файлу или файл не существует!");
    }
}