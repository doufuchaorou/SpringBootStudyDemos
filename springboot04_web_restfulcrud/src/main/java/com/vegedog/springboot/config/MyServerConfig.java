package com.vegedog.springboot.config;

import com.vegedog.springboot.filter.MyFilter;
import com.vegedog.springboot.listener.MyListener;
import com.vegedog.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Arrays;


@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }

    //配置嵌入式的Servlet容器
    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>(

        ) {
            //定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8083);
            }
        };


    }
}
