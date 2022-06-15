package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().
                csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return  new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://192.168.1.105:3000")
                        .allowedOrigins("http://192.168.1.105:3001")
                        .allowedOrigins("http://localhost:3001")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("*");
            }
        };
}
}




// Данный компонент должен находится в нутри класса конфигурации по запросу на секьюрити
//это пример рабочего кода для отоброжения информации на запроссы с любого адреса как пример
// Работает реакт приложение как в данном случае и работает из локального порта 3000 и оброщается на спринг приложение которое работает по порту 8080

//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return  new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("HEAD", "GET", "PUT", "DELETE", "PATCH");
//            }
//        };



//Ниже пример кода для разрешения запросов с определенного домена и порта для всех видов запросов

//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return  new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://192.168.1.105:3000")
//                        .allowedOrigins("http://192.168.1.105:3001")
//                        .allowedOrigins("http://localhost:3001")
//                        .allowedOrigins("http://localhost:3000")
//                        .allowedMethods("*");
//            }
//        };
