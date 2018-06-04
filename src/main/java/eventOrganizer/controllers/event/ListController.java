package eventOrganizer.controllers.event;

import eventOrganizer.entities.event.EventEntity;
import eventOrganizer.exception.BadFileNameException;
import eventOrganizer.services.eventService.EventServiceDAO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "")
@Log4j
public class ListController {
    @Autowired
    private EventServiceDAO eventService;
    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();
    private Set<ConstraintViolation<Object>> constraintViolations;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ModelAndView getList() throws IOException, BadFileNameException {
        List<EventEntity> events = eventService.getEvents();

        if (!isValid(events)) {
            return new ModelAndView("/error/errorpage", "exceptionMsg", constraintViolations);
        }

//        log.info("events: ", events);
        throw new IOException("Not found");
//        throw   new BadFileNameException("BadFileNameException!");
//        return new ModelAndView("/index", "events", events);
    }

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public ModelAndView getEvent(@RequestParam("id") Integer id) {
        EventEntity event = eventService.getEvent(id);
//        log.info("event: ", event);
        List<EventEntity> events = Arrays.asList(event);
        return new ModelAndView("/index", "events", events);
    }

    private boolean isValid(List<?> entities) {
        for (Object entity : entities) {
            constraintViolations = validator.validate(entity);
            if (!constraintViolations.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "IOException exception! Check arguments")
    @ExceptionHandler(IOException.class)
    public void handleIOException(IOException e) {
        log.error("IOException" + e);
//        logger.error("!!!");
    }

//    @ResponseStatus(value = HttpStatus.BAD_GATEWAY,reason = "Bad fileName")
//    @ExceptionHandler(BadFileNameException.class)
//    public ModelAndView handleBadFileException(Exception e){
//        logger.error("BadFileException");
//        ModelAndView modelAndView = new ModelAndView("error/errorpage");
//        modelAndView.addObject("exceptionMsg", e.getMessage());
//        return modelAndView;
//    }

}
