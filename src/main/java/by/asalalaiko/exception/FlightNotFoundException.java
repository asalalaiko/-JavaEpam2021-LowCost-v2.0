package by.asalalaiko.exception;


public class FlightNotFoundException extends RuntimeException{

    public FlightNotFoundException() {
    }

    public FlightNotFoundException(String name) {
        super("Could not find flight with name " + name);
    }

    public FlightNotFoundException(Long id) {
        super("Could not find flight with ID " + id);
    }


}
