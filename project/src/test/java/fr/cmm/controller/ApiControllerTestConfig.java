package fr.cmm.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import fr.cmm.service.RecipeService;
import org.jongo.MongoCollection;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class ApiControllerTestConfig {
    @Bean
    ApiController apiController() {
        return new ApiController();
    }

    @Bean
    RecipeService recipeService() {
        return Mockito.mock(RecipeService.class);
    }

    @Bean
    MongoCollection recipeCollection() {
        return Mockito.mock(MongoCollection.class);
    }

    @Bean
    InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/jsp");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}


