package OrangeHrm.data;

public class DataLoaderException extends RuntimeException {
    public DataLoaderException(String message,Exception e) {
        super(message,e);
    }

    public DataLoaderException(String message) {
        super(message);
    }
}
