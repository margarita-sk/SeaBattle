package battle.exception;

public class WrongCoordinateException extends RuntimeException {

    public WrongCoordinateException(String coordinate) {
        super(String.format("Wrong %s coordinate", coordinate));
    }
}
