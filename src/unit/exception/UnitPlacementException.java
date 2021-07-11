package unit.exception;

public class UnitPlacementException extends RuntimeException {

    public UnitPlacementException(String unit) {
        super(String.format("Can't set the unit %s to the desk!", unit));
    }
}
