package lk.ijse.di;

import org.springframework.stereotype.Component;

@Component
public class Test1 implements DI{
    public Test1() {
        System.out.println("Test 1 Constructor");
    }
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
