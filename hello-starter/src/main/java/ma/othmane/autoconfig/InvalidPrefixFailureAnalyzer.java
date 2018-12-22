package ma.othmane.autoconfig;

import ma.othmane.service.exceptions.InvalidHelloPrefixException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class InvalidPrefixFailureAnalyzer extends AbstractFailureAnalyzer<InvalidHelloPrefixException> {


    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, InvalidHelloPrefixException cause) {

        String desc = "Failing with non valid prefix hello.service.prefix=" + cause.getPrefix();
        String action = "Change the first letter of the prefix to UPPER CASE";

        return new FailureAnalysis(desc, action, cause);
    }
}
