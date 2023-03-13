package org.nilcux.ioc.factory;

import org.nilcux.exceptions.BeanException;
import org.nilcux.ioc.BeanDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleBeanFactory implements BeanFactory{
    List<BeanDefinition> beanDefinitions = new ArrayList<>();
    List<String> beanNames = new ArrayList<>();

    Map<String, Object> singletonBeans = new HashMap<>();

    public Object getBean(String beanName) throws BeanException {
        Object instance = singletonBeans.get(beanName);

        if (instance == null) {
            int index = beanNames.indexOf(beanName);
            if (index == -1) {
                throw new BeanException("Bean " + beanName + " not found");
            }

            BeanDefinition beanDefinition = beanDefinitions.get(index);

            try {
                instance = Class.forName(beanDefinition.getClassName()).getConstructor().newInstance();
            } catch (Exception e) {
                throw new BeanException("Error creating bean " + beanName);
            }

            singletonBeans.put(beanName, instance);
        }

        return instance;
    }

    public void registerBean(BeanDefinition beanDefinition) {
        beanDefinitions.add(beanDefinition);
        beanNames.add(beanDefinition.getId());
    }
}
