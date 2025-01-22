package lk.ijse;

import lk.ijse.bean.MyConnection;
import lk.ijse.bean.SpringBean;
import lk.ijse.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        /*SpringBean bean1 = (SpringBean) context.getBean("springBean");
        SpringBean bean2 = (SpringBean) context.getBean("springBean");
        System.out.println(bean1);
        System.out.println(bean2);

        MyConnection myConnection1 = context.getBean(MyConnection.class);
        MyConnection myConnection2 = context.getBean(MyConnection.class);

        System.out.println(myConnection1);
        System.out.println(myConnection2);*/

        MyConnection myConnection1 = context.getBean(MyConnection.class);
        System.out.println("-------------------------------");
        MyConnection myConnection2 = context.getBean(MyConnection.class);
        context.registerShutdownHook();
    }
}
