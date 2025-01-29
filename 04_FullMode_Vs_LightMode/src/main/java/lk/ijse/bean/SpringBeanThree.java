package lk.ijse.bean;

import org.springframework.beans.factory.BeanNameAware;

public class SpringBeanThree implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBeanThree Bean Name Set");
    }
}
