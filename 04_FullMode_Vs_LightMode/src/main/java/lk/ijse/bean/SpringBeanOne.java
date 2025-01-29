package lk.ijse.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanOne {
    @Bean
    public SpringBeanTwo getSpringBeanTwo(){
        SpringBeanThree springBeanThree1 = new SpringBeanThree();
        SpringBeanThree springBeanThree2 = new SpringBeanThree();
        System.out.println(springBeanThree1);
        System.out.println(springBeanThree2);
        return new SpringBeanTwo();
    }

    @Bean
    public SpringBeanThree getSpringBeanThree(){
        return new SpringBeanThree();
    }

   /* @Override
    public void setBeanName(String name) {
        System.out.println("name");
    }*/
}
