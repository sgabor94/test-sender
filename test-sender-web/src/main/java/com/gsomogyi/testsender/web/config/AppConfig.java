package com.gsomogyi.testsender.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:default.properties")
public class AppConfig {

    @Value("${environment}")
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    /**
     * Returns the application version string when you run the jar
     * When you run from IntelliJ it returns 'Local'
     *
     * @return the Implementation-Version defined in the MANIFEST.MF
     */
    public String getAppVersion() {
        String version = getClass().getPackage().getImplementationVersion();
        return version != null ? version : "Local";
    }
}
