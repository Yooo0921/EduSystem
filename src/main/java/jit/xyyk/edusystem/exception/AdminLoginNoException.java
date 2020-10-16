package jit.xyyk.edusystem.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;

public class AdminLoginNoException extends Exception {
    private static final long serialVersionUID = 1L;

    public AdminLoginNoException(String message) {
        super(message);
    }


}
