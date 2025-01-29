package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
//    public SpringBean() {}
    /*@Autowired(required = false)
    public SpringBean(@Value("shachiru") String name,
                      @Value("1") int id,
                      @Value("true") boolean b) {
        System.out.println("SpringBean Object created");
        System.out.println(name);
        System.out.println(id);
        System.out.println(b);
    }
    @Autowired(required = false)
    public SpringBean(@Value("shachiru") String name,
                      @Value("1") int id) {
        System.out.println("SpringBean Object created");
        System.out.println(name);
        System.out.println(id);
//        System.out.println(b);
    }*/

    @Value("shachiru")
    private String name;

    public SpringBean () {
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }
}
