package ua.com.exeption;

public class InvalidFormatException extends RuntimeException{
    @Override
    public String getMessage() {
        return "You made a mistake";
    }
}
