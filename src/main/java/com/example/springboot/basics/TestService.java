package com.example.springboot.basics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources(
        {
                @PropertySource("classpath:custom.properties"),
                @PropertySource("classpath:custom-2.properties")
        }
)
public class TestService {

    private final Test test;
    private Environment environment;

    @Value("${my.prop}")
    private String customProperty;

    @Value("${my.prop.2}")
    private String customProperty2;

    public TestService(
           @Qualifier("test2") Test test
    ) {
        this.test = test;
    }

    public String tellAStory() {
       return "The dependency is saying " + test.hello();
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getOsName() {
        return environment.getProperty("os.name");
    }

    public String getProperty () {
        return environment.getProperty("spring.application.name");
    }

    @Autowired
    private void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    public String getCustomProperty() {
        return customProperty;
    }

    public String getCustomProperty2() {
        return customProperty2;
    }


}
