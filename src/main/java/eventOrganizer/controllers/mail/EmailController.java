package eventOrganizer.controllers.mail;

import eventOrganizer.services.emailService.EmailServiceDAO;
import eventOrganizer.entities.mail.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @Autowired
    EmailServiceDAO emailService;

    @RequestMapping(value = "/email/send", method = RequestMethod.POST)
    public ModelAndView email(@ModelAttribute("emailModel") EmailModel emailModel) {
        System.out.println("emailModel " + emailModel);

        boolean result = emailService.sendEmail("registered.vm", emailModel);
        //use redirect or you will send email after every refresh page.
        return new ModelAndView("redirect:/event", "resultSending", result);
    }
}
