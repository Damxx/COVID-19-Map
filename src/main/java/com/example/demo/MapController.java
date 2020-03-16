package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MapController {

    private DataRepo dataRepo;

    @Autowired
    public MapController(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getMap(Model model){

        model.addAttribute("pointList",dataRepo);

        return "map";

    }
}
