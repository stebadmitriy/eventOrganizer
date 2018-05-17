package eventOrganizer.controllers.mail;

import eventOrganizer.dao.EmailServiceDAO;
import eventOrganizer.entities.mail.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmailController {
    @Autowired
    EmailServiceDAO emailService;

    @RequestMapping(value = "/email/send", method = RequestMethod.POST)
    public ModelAndView email(@ModelAttribute("emailModel") EmailModel emailModel) {
        System.out.println("emailModel " + emailModel);
        Map<String, Object> model = new HashMap<>();
        model.put("from", "javastudy@mvc.app");
        model.put("subject", "Hello from " + emailModel.getName() + "!");
        model.put("to", emailModel.getEmail());
        model.put("ccList", new ArrayList<>());
        model.put("bccList", new ArrayList<>());
        model.put("userName", emailModel.getName());
        model.put("phoneNumber", emailModel.getPhoneNumber());
        model.put("urlBestVideographer", "steba-video.com");
        model.put("message", emailModel.getMessage());
        boolean result = emailService.sendEmail("registered.vm", model);
        //use redirect or you will send email after every refresh page.
        return new ModelAndView("redirect:/event", "resultSending", result);
    }
}
