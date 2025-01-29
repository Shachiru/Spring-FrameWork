package lk.ijse.config;

import lk.ijse.bean.SpringBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class AppConfig2 {
    @Bean
    public SpringBean1 springBean1() {
        return new SpringBean1();
    }
}
