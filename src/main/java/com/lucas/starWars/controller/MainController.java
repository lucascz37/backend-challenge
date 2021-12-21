package com.lucas.starWars.controller;

import java.util.HashMap;

import com.lucas.starWars.Service.Impl.CharacterService;
import com.lucas.starWars.models.Page;
import com.lucas.starWars.models.SWCharacter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    private final CharacterService characterService;
    
    public MainController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping(value="/")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value="/characters")
    public ModelAndView characters(@RequestParam(defaultValue = "1") Integer page){

        HashMap<String, Object> params = new HashMap<>();

        Page<SWCharacter> characters = characterService.getPage(page);
        params.put("characters", characters.getResults());
        
        if(characters.getPrevious() != null){
            params.put("previous", String.format("/characters/?page=%d", page-1));
        }else{
            params.put("previous", null);
        } 

        if(characters.getNext() != null){
            params.put("next", String.format("/characters/?page=%d", page+1));
        }else{
            params.put("next", null);
        }


        return new ModelAndView("characters", params);
    }

    
}
