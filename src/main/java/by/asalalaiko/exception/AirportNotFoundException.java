package by.asalalaiko.exception;


public class AirportNotFoundException extends RuntimeException{

    public AirportNotFoundException() {
    }

    public AirportNotFoundException(String name) {
        super("Could not find airport with name " + name);
    }

    public AirportNotFoundException(Long id) {
        super("Could not find airport with ID " + id);
    }


}
