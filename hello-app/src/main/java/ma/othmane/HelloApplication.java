package ma.othmane;


import ma.othmane.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(HelloApplication.class);
        System.out.println(ctx.getBean(HelloService.class).sayHello());

    }
}
