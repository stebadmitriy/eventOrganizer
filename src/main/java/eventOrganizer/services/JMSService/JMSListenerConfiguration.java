//package eventOrganizer.services.JMSService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.jms.ConnectionFactory;
//
//@Configuration
//@EnableJms
//@ComponentScan("eventOrganizer")
//@EnableJpaRepositories
//@EnableTransactionManagement
//public class JMSListenerConfiguration {
//    @Autowired
//    ConnectionFactory connectionFactory;
//
//    @Bean
//    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setConcurrency("1-1");
//        return factory;
//    }
//
//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean result =
//                new LocalEntityManagerFactoryBean();
//        result.setPersistenceUnitName("eventOrganizer");
//        return result;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager result = new JpaTransactionManager();
//        result.setEntityManagerFactory(entityManagerFactory().getObject());
//        return result;
//    }
//}
