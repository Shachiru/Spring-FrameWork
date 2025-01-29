package lk.ijse.config;

import lk.ijse.bean.SpringBeanOne;
import lk.ijse.bean.SpringBeanThree;
import lk.ijse.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {
    // Inter Bean Dependency
/*
    @Bean
    public SpringBeanOne getSpringBeanOne(){
        SpringBeanTwo springBeanTwo1 = new SpringBeanTwo();
        SpringBeanTwo springBeanTwo2 = new SpringBeanTwo();
        return new SpringBeanOne();
    }

    @Bean
    public SpringBeanTwo getSpringBeanTwo(){
        return new SpringBeanTwo();
    }
*/
    @Bean
    public SpringBeanTwo getSpringBeanTwo(){
        SpringBeanThree springBeanThree1 = new SpringBeanThree();
        SpringBeanThree springBeanThree2 = new SpringBeanThree();
        return new SpringBeanTwo();
    }

    @Bean
    public SpringBeanThree getSpringBeanThree(){
        return new SpringBeanThree();
    }
}
