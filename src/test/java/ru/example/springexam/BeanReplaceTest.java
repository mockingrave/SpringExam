package ru.example.springexam;

import com.example.mylibrary.autoconfigure.LibAutoConfiguration;
import com.example.mylibrary.service.ReplaceableService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import ru.example.springexam.bean.config.BfppConfig;
import ru.example.springexam.bean.config.ImportConfig;
import ru.example.springexam.bean.config.ScanConfig;
import ru.example.springexam.bean.service.ReplaceableServiceImpl;

@Slf4j
@DisplayName("Замена bean'а внешней библиотеки")
public class BeanReplaceTest {

    private final String EXCLUSION_PROPERTY = "spring.autoconfigure.exclude:LibAutoConfiguration.class";

    @Test()
    @DisplayName("Наследование и @Primary")
    void testPrimary() {

        var contextRunner =
            new ApplicationContextRunner()
                .withConfiguration(UserConfigurations.of(LibAutoConfiguration.class))
                .withBean(ReplaceableServiceImpl.class);

        contextRunner.run((context) -> {
            var notPrimaryBean = context.getBean(ReplaceableService.class);
            //проверим, что теперь вместо библиотечного bean'a без @Primary мы получаем наш новый bean
            Assertions.assertTrue(notPrimaryBean instanceof ReplaceableServiceImpl);
        });
    }

    @Test
    @DisplayName("Исключение bean'a в BFPP")
    void testBeanReplace() {

        var contextRunner =
            new ApplicationContextRunner()
                .withConfiguration(UserConfigurations.of(LibAutoConfiguration.class, BfppConfig.class))
                .withPropertyValues("config.enable:bfpp");

        contextRunner.run(
            (context) -> context
                .assertThat()
                .getFailure()
                .getRootCause().isInstanceOf(NoSuchBeanDefinitionException.class));
    }

    @Test()
    @DisplayName("Исключение bean'a & Import")
    void testImport() {

        var contextRunner =
            new ApplicationContextRunner()
                .withConfiguration(UserConfigurations.of(ImportConfig.class))
                .withPropertyValues(EXCLUSION_PROPERTY, "config.enable:import");

        contextRunner.run(
            (context) -> context
                .assertThat()
                .getFailure()
                .getRootCause().isInstanceOf(NoSuchBeanDefinitionException.class));
    }

    @Test()
    @DisplayName("Исключение bean'a & ComponentScan")
    void testComponentScan() {

        var contextRunner =
            new ApplicationContextRunner()
                .withConfiguration(UserConfigurations.of(ScanConfig.class))
                .withPropertyValues(EXCLUSION_PROPERTY, "config.enable:scan");

        contextRunner.run(
            (context) -> context
                .assertThat()
                .getFailure()
                .getRootCause().isInstanceOf(NoSuchBeanDefinitionException.class));

    }

}
