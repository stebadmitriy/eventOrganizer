package eventOrganizer.controllers.JMS;

import eventOrganizer.dao.JMSService.JMSServiceDAO;
import eventOrganizer.entities.mail.EmailModel;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;

@Controller
@RequestMapping(value = "")
public class JMSController {

    @Autowired
    JMSServiceDAO jmsServiceDAO;

    public void startBrokerService() throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
        broker.start();
    }

    @RequestMapping(value = "/jms/send", method = RequestMethod.POST)
    public ModelAndView sendJMSMessage(@ModelAttribute("emailModel") EmailModel emailModel) {
//        startBrokerService();
//        jmsServiceDAO.sendTextMessage(emailModel.getMessage());
        jmsServiceDAO.sendMessage(emailModel);
//        String message = jmsServiceDAO.receiveMessage();
//        System.out.println("message!!! = " + message);
        return new ModelAndView("redirect:/event", "resultSending","isOk");
    }

    public ModelAndView receiveJMSMessage() {

        String message = jmsServiceDAO.receiveMessage();
        return new ModelAndView("redirect:/eventService", "resultSending", message);
    }
}
