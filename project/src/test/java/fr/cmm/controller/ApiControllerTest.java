package fr.cmm.controller;

import fr.cmm.domain.Recipe;
import fr.cmm.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IndexControllerTestConfig.class)
@WebAppConfiguration
public class ApiControllerTest {
    @Inject
    RecipeService recipeService;

    @Inject
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(wac).build();

        Mockito.reset(recipeService);
    }

    @Test
    public void recipesList() throws Exception {
        mockMvc.perform(get("/mentions-legales"))
                .andExpect(view().name("mentions-legales"));
    }

    @Test
    public void findRecipeId() throws Exception {
        String id = "56375619d4c603aa4eb412af";

        Mockito.when(recipeService.findById(id)).thenReturn(new Recipe());

        mockMvc.perform(get("api/recipes/" + id))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"));

        mockMvc.perform(get("api/recipes/etnon" + id))
                .andExpect(status().is(404));
    }

}