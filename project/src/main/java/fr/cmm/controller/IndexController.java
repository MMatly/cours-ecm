package fr.cmm.controller;

import javax.inject.Inject;

import fr.cmm.controller.form.SearchForm;
import fr.cmm.domain.Recipe;
import fr.cmm.helper.PageQuery;
import fr.cmm.helper.Pagination;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.cmm.helper.Columns;
import fr.cmm.service.RecipeService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class IndexController {
    @Inject
    private RecipeService recipeService;
    public HttpStatus status = HttpStatus.NOT_FOUND;

    @RequestMapping({"/index", "/"})
    public String index(ModelMap model) {
        model.put("columns", randomColumns());

        return "index";
    }

    @RequestMapping("/tags.json")
    @ResponseBody
    public List<String> tags() {
        return recipeService.findAllTags();
    }

    @RequestMapping("/recettes")
    public String recettes(SearchForm searchForm, ModelMap model) {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setIndex(searchForm.getPageIndex() - 1);
        pageQuery.setTag(searchForm.getTag());

        Pagination pagination = new Pagination();
        pagination.setPageIndex(searchForm.getPageIndex());
        pagination.setPageSize(pageQuery.getSize());
        pagination.setCount(recipeService.countByQuery(pageQuery));

        model.put("recipes", recipeService.findByQuery(pageQuery));
        model.put("pagination", pagination);

        return "recettes";
    }

    @RequestMapping("/recette-du-moment")
    public String recettesDuMoment(ModelMap model) {
        model.put("recipe", recipeService.findRandom(1).next());

        return "recette-du-moment";
    }

    private Columns randomColumns() {
        Columns columns = new Columns();

        columns.add(recipeService.findRandom(10));
        columns.add(recipeService.findRandom(10));
        columns.add(recipeService.findRandom(10));

        return columns;
    }

    @RequestMapping("/recette/{id}")
    public String recette(@PathVariable("id") String id, ModelMap model) {
        Recipe recipe = recipeService.findById(id);
        if (recipe == null ){
            throw new RecipeNotFoundException();
        }
        model.put("recipe", recipe);
        return "recette";
    }


    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/mentions-legales")
    public String mentionsLegales() {
        return "mentions-legales";
    }

    @RequestMapping("/404")
    public String erreur404() {
        return "erreur";
    }

    @RequestMapping("/500")
    public String erreur500() {
        return "erreur";}
}

