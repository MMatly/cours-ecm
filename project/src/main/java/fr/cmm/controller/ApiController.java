package fr.cmm.controller;

import javax.inject.Inject;

import fr.cmm.controller.form.SearchForm;
import fr.cmm.domain.Recipe;
import fr.cmm.helper.PageQuery;
import fr.cmm.helper.Pagination;
import fr.cmm.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import fr.cmm.helper.Columns;
import fr.cmm.service.RecipeService;

import java.util.List;


@Controller
public class ApiController {
    @Inject
    private RecipeService recipeService;

    @RequestMapping(value = "/api/recipes",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Iterable<Recipe> recipesList() {
        PageQuery pageQuery = new PageQuery();
        return recipeService.findByQuery(pageQuery);
    }

    @RequestMapping(value = "/api/recipes/{id}", method = RequestMethod.GET, produces = "application/json")
    public Recipe findRecipe(@PathVariable("id") String id) {
            Recipe recipe = recipeService.findById(id);
        if (recipe == null ){
        throw new RecipeNotFoundException();
    }
        return recipeService.findById(id);
    }


}
