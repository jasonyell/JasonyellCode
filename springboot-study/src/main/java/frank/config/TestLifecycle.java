package frank.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class TestLifecycle implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean
{

    /**
     * BeanFactoryAware接口方法
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    /**
     * BeanNameAware接口方法
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName: "+name);
    }

    /**
     * DisposableBean接口方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    /**
     * ApplicationContextAware接口方法
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
