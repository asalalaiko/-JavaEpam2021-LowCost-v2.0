package by.asalalaiko.exception;


public class TicketNotFoundException extends RuntimeException{

    public TicketNotFoundException() {
    }

    public TicketNotFoundException(Long id) {
        super("Could not find ticket with ID " + id);
    }


}
