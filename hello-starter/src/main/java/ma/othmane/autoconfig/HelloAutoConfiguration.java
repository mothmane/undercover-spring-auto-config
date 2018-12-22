package ma.othmane.autoconfig;


import ma.othmane.service.ConsoleHelloService;
import ma.othmane.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HelloService.class)
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoConfiguration {

    private final HelloProperties helloProperties;

    public HelloAutoConfiguration(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    /**
     * this is the default autoconfiguer helloService
     *
     * @return
     */
    @ConditionalOnMissingBean
    @Bean
    public HelloService helloService() {
        return new ConsoleHelloService(helloProperties.getPrefix(), helloProperties.getSuffix());
    }
}
