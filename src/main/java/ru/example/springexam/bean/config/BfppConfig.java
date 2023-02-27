package ru.example.springexam.bean.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.example.springexam.bean.processor.BeanOverrider;

@Configuration
@ConditionalOnProperty(
    value="config.enable",
    havingValue = "bfpp"
)
public class BfppConfig {

    @Bean
    public static BeanOverrider beanOverrider() {
        return new BeanOverrider();
    }

}
