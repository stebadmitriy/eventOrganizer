package eventOrganizer.controllers.files;

import eventOrganizer.entities2.EventEntity;
import eventOrganizer.services.eventService.EventServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "")
public class ListController {
    @Autowired
    EventServiceDAO eventService;


    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public ModelAndView getList() {
        List<EventEntity> events = eventService.getEvents();
        System.out.println(events);
        return new ModelAndView("/index", "events", events);


    }
}
