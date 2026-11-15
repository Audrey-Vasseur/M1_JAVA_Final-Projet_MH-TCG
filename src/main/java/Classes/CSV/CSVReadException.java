package Classes.CSV;

public class CSVReadException extends Exception{
    public CSVReadException(String message){
        super(message);
    }

    public CSVReadException(String message, Throwable reason){
        super(message,reason);
    }
}
