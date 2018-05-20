package eventOrganizer.controllers.JMS;

import eventOrganizer.dao.JMSService.JMSServiceDAO;
import eventOrganizer.entities.mail.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;

@Controller
@RequestMapping(value = "")
public class JMSController {

    @Autowired
    JMSServiceDAO jmsServiceDAO;

    @RequestMapping(value = "/jms/send", method = RequestMethod.POST)
    public ModelAndView sendJMSMessage(@ModelAttribute("emailModel") EmailModel emailModel) {
        jmsServiceDAO.sendMessage(emailModel);
        return new ModelAndView("redirect:/event", "resultSending",true);
    }

}
