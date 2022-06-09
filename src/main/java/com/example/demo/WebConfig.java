//package com.example.demo;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Order;
//import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//
//@Configuration
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//  @Override
//  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//      PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
//      //ページ単位に表示する件数
//      resolver.setFallbackPageable(PageRequest.of(0, 5, Sort.by(Order.asc("id"))));
//      argumentResolvers.add(resolver);
//      super.addArgumentResolvers(argumentResolvers);
//  }
//
//}