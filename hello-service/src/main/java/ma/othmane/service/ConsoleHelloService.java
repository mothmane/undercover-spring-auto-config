package ma.othmane.service;

import ma.othmane.service.exceptions.InvalidHelloPrefixException;

public class ConsoleHelloService implements HelloService {


    private String prefix = "Hello";
    private String suffix = "!";

    public ConsoleHelloService(String prefix, String suffix) {
        this.checkValidPrefix(prefix);

        this.prefix = prefix;
        this.suffix = suffix;
    }

    //TODO extract condition from Here and give a specialised bean to do so, linked to special annotation
    private void checkValidPrefix(String prefix) {
        if (!Character.isUpperCase(prefix.charAt(0))) {
            throw new InvalidHelloPrefixException(prefix);
        }
    }

    public ConsoleHelloService() {
    }

    public String sayHello() {
        return prefix + " world " + suffix;
    }
}
