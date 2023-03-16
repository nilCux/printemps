package org.nilcux.ioc.beanFactory;

import org.nilcux.exceptions.BeanException;
import org.nilcux.ioc.BeanDefinition;

import java.util.List;

public interface BeanFactory {
    Object getBean(String beanName) throws BeanException;

    Boolean containsBean(String beanName);

    void registerBean(String beanName, Object bean);


}
