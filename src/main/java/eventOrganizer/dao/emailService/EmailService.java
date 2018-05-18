package eventOrganizer.dao.emailService;

import eventOrganizer.entities.mail.EmailModel;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.*;

@Service
public class EmailService implements EmailServiceDAO {
    /*Email From*/
    public static final String FROM = "from";
    /*Email To*/
    public static final String TO = "to";
    /*Email Subject*/
    public static final String SUBJECT = "subject";
    /*Email BCC*/
    public static final String BCC_LIST = "bccList";
    /*Email CCC*/
    public static final String CCC_LIST = "ccList";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Override
    public boolean sendEmail(final String templateName, final EmailModel emailModel) {
        System.out.println("34");
        Map<String, Object> modelMap = convertEmailModelToMap(emailModel);

        boolean res = false;
        try {
            MimeMessagePreparator preparator = new MimeMessagePreparator() {

                @Override
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    String from = (String) modelMap.get(FROM);
                    String to = (String) modelMap.get(TO);
                    String subject = (String) modelMap.get(SUBJECT);

                    List<String> bccList = (List<String>) modelMap.get(BCC_LIST);
                    //ВАЖНО! ПОСТАВЬТЕ КОДИРОВКУ UTF-8 ИЛИ СООБЩЕНИЯ БУДУТ ?????? ??
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8"); //ENCODING IMPORTANT!
                    message.setFrom(from);
                    message.setTo(to);
                    message.setSubject(subject);
                    message.setSentDate(new Date());
                    if (bccList != null) {
                        for (String bcc : bccList) {
                            message.addBcc(bcc);
                        }
                    }

                    modelMap.put("noArgs", new Object());
                    String text = VelocityEngineUtils.mergeTemplateIntoString(
                            velocityEngine, templateName, "UTF-8", modelMap);

                    message.setText(text, true);
                }
            };

            mailSender.send(preparator);
            res = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("4");
        return res;
    }

    private Map<String, Object> convertEmailModelToMap(EmailModel emailModel){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("from", "javastudy@mvc.app");
        modelMap.put("subject", "Hello from " + emailModel.getName() + "!");
        modelMap.put("to", emailModel.getEmail());
        modelMap.put("ccList", new ArrayList<>());
        modelMap.put("bccList", new ArrayList<>());
        modelMap.put("userName", emailModel.getName());
        modelMap.put("phoneNumber", emailModel.getPhoneNumber());
        modelMap.put("urlBestVideographer", "steba-video.com");
        modelMap.put("message", emailModel.getMessage());
        return modelMap;
    }
}

