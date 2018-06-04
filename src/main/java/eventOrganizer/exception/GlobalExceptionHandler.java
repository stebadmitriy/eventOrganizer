package eventOrganizer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Bad file")
    @ExceptionHandler(BadFileNameException.class)
    public ModelAndView handleBadFileException(Exception e){
//        logger.error("BadFileException");
        ModelAndView modelAndView = new ModelAndView("error/errorpage");
        modelAndView.addObject("exceptionMsg", e.getMessage());
        return modelAndView;
    }
}
