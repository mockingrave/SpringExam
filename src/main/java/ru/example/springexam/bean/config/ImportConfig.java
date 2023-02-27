package ru.example.springexam.bean.config;

import com.example.mylibrary.service.FirstService;
import com.example.mylibrary.service.ReplaceableService;
import com.example.mylibrary.service.SecondService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    FirstService.class,
    ReplaceableService.class,
    SecondService.class
})
@ConditionalOnProperty(
    value="config.enable",
    havingValue = "import"
)
public class ImportConfig {

}
