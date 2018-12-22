package ma.othmane.autoconfig;

import ma.othmane.service.ConsoleHelloService;
import ma.othmane.service.HelloService;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloAutoConfigurationTest {

    @Rule
    public OutputCapture output = new OutputCapture();


    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(HelloAutoConfiguration.class));



    @Test
    public void testDefaultBeanIsUsed() {
       this.contextRunner.run(context -> {
           assertThat(context).hasSingleBean(HelloService.class);
            HelloService helloBean = context.getBean(HelloService.class);
           assertThat(helloBean.sayHello()).contains("Hello");
        });

    }

    @Test
    public void testUserBeanIsUsed() {
        this.contextRunner.withUserConfiguration(UserConfiguration.class).run(context -> {
            assertThat(context).hasSingleBean(HelloService.class);
            HelloService helloBean = context.getBean(HelloService.class);
            assertThat(helloBean.sayHello()).contains("Hey");
        });
    }

    @Test
    public void testDefaultBeanWithSpecialProperty() {
        this.contextRunner.withPropertyValues("hello.service.prefix=Foo").run(context -> {
            assertThat(context).hasSingleBean(HelloService.class);
            HelloService helloBean = context.getBean(HelloService.class);
            assertThat(helloBean.sayHello()).contains("Foo");
        });
    }

    @Configuration
    @ImportAutoConfiguration(HelloAutoConfiguration.class)
    public static class EmptyConfiguration {

    }

    @Configuration
    @Import(EmptyConfiguration.class)
    @EnableConfigurationProperties
    static class UserConfiguration {

        @Bean
        public HelloService myHelloService() {
            return new ConsoleHelloService("Hey", ":)");
        }
    }

    @Configuration
    @Import(EmptyConfiguration.class)
    public static class UserPropetyConfiguration {

    }

}