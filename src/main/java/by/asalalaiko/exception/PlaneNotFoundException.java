package by.asalalaiko.exception;


public class PlaneNotFoundException extends RuntimeException{

    public PlaneNotFoundException() {
    }

    public PlaneNotFoundException(String name) {
        super("Could not find plane with name " + name);
    }

    public PlaneNotFoundException(Long id) {
        super("Could not find plane with ID " + id);
    }


}
