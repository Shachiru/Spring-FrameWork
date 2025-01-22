package lk.ijse;

import lk.ijse.bean.MyConnection;
import lk.ijse.bean.TestBean1;
import lk.ijse.bean.TestBean2;
import lk.ijse.bean.TestBean3;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

         /* Object bean = context.getBean("springBean");
        System.out.println(bean);

        SpringBean bean1 = (SpringBean) context.getBean("springBean");
        System.out.println(bean1);

        TestBean2 testBean2 = (TestBean2) context.getBean("bean2", TestBean2.class);
        System.out.println(testBean2);

        TestBean1 testBean1 = context.getBean(TestBean1.class);
        System.out.println(testBean1);

        Object myConnection = context.getBean(MyConnection.class);
        System.out.println(myConnection);

        MyConnection myConnection1 = context.getBean("connection",MyConnection.class);
        System.out.println(myConnection1);
        */

        TestBean1 ref1 = context.getBean("testBean1", TestBean1.class);
        TestBean1 ref2 = context.getBean("testBean1", TestBean1.class);
        System.out.println(ref1);
        System.out.println(ref2);

        TestBean2 ref3 = context.getBean("testBean2", TestBean2.class);
        TestBean2 ref4 = context.getBean("testBean2", TestBean2.class);
        System.out.println(ref3);
        System.out.println(ref4);

        TestBean3 ref7 = context.getBean("testBean3", TestBean3.class);
        TestBean3 ref8 = context.getBean("testBean3", TestBean3.class);
        System.out.println(ref7);
        System.out.println(ref8);

        MyConnection ref5 = context.getBean("connection", MyConnection.class);
        MyConnection ref6 = context.getBean("connection", MyConnection.class);
        System.out.println(ref5);
        System.out.println(ref6);

        context.registerShutdownHook();
    }
}
