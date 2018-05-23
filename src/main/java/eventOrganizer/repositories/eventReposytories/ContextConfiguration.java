//package eventOrganizer.repositories.eventReposytories;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@ComponentScan("eventOrganizer")
//@EnableJpaRepositories
//@EnableTransactionManagement
//public class ContextConfiguration {
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
//
