package ma.othmane.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("hello.service")
public class HelloProperties {
    /**
     * prefix property that will be added before "World" word
     */
    private String prefix = "Hello";

    /**
     * suffix property will be added after "World" word
     */
    private String suffix = "!";


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
