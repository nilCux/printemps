package org.nilcux.ioc.factory;

import org.nilcux.exceptions.BeanException;
import org.nilcux.ioc.BeanDefinition;

import java.util.List;

public interface BeanFactory {
    Object getBean(String beanName) throws BeanException;

    void registerBean(BeanDefinition beanDefinition);
}
