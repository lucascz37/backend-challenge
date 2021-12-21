package com.lucas.starWars.controller;

import java.util.HashMap;

import com.lucas.starWars.Service.Impl.CharacterService;
import com.lucas.starWars.Service.Impl.FilmService;
import com.lucas.starWars.models.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    private final CharacterService characterService;
    private final FilmService filmService;
    
    public MainController(CharacterService characterService, FilmService filmService){
        this.characterService = characterService;
        this.filmService = filmService;
    }

    @GetMapping(value="/")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value="/characters")
    public ModelAndView characters(@RequestParam(defaultValue = "1") Integer page){

        HashMap<String, Object> params = new HashMap<>();

        var data = characterService.getPage(page);

        return generatePage("characters", params, data, page);
    }

    @GetMapping(value="/films")
    public ModelAndView films(@RequestParam(defaultValue = "1") Integer page){
        HashMap<String, Object> params = new HashMap<>();

        var data = filmService.getPage(page);

        return generatePage("films", params, data, page);
    }

    private ModelAndView generatePage(String templateName, HashMap<String, Object> params, Page<?> data, Integer page){
        params.put(templateName, data.getResults());

        if(data.getPrevious() != null){
            params.put("previous", String.format("/characters/?page=%d", page-1));
        }else{
            params.put("previous", null);
        } 

        if(data.getNext() != null){
            params.put("next", String.format("/characters/?page=%d", page+1));
        }else{
            params.put("next", null);
        }

        return new ModelAndView(templateName, params);

    }

    
}
