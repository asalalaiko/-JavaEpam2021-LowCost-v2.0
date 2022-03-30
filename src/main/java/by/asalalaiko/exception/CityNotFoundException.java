package by.asalalaiko.exception;


public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException() {
    }

    public CityNotFoundException(Long id) {
        super("Could not find city with ID " + id);
    }

    public CityNotFoundException(String name) {
        super("Could not find city with name " + name);
    }

}
