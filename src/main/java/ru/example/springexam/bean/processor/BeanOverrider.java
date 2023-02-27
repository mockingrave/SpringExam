package ru.example.springexam.bean.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanOverrider implements BeanFactoryPostProcessor {

    private final String TARGET_BEAN_NAME = "replaceableServiceFinal";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory beanFactoryImpl = (DefaultListableBeanFactory) beanFactory;

        if (beanFactoryImpl.containsBeanDefinition(TARGET_BEAN_NAME)) {
            beanFactoryImpl.removeBeanDefinition(TARGET_BEAN_NAME);
        }

    }

}
