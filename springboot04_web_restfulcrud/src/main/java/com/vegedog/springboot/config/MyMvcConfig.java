package com.vegedog.springboot.config;

import com.vegedog.springboot.componet.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc 不要接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/vegedog 请求来到success

        //http://localhost:8080/vegedog
        registry.addViewController("/vegedog").setViewName("/success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean  //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //springboot已经做好了静态资源映射，不用处理静态资源也可访问
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login");
            }

        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }


}
