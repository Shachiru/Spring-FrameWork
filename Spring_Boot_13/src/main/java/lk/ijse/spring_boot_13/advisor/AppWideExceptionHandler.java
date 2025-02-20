package lk.ijse.spring_boot_13.advisor;

import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseUtil exceptionHandler(Exception ex) {
        return new ResponseUtil(
                500,
                ex.getMessage(),
                null
        );
    }
}
