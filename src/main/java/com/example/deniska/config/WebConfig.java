package com.example.deniska.config;

import com.example.deniska.web.IngredientByIdConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * Регистрирует представление на шаблон
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("home");
    }
}
