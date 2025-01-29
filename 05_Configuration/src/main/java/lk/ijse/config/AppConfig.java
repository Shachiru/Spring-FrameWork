package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import lk.ijse.bean.SpringBean1;
import org.springframework.context.annotation.*;

@Configuration
@Import({AppConfig1.class, AppConfig2.class})
// root
@ImportResource("classpath:hibernate.xml")
// if not
//@ImportResource("file:absolute-path-of-hibernate.xml")   // only one import resource
public class AppConfig {

}
