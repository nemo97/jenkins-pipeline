package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by popy on 7/23/17.
 */
@RestController
public class RestController1 {


    @RequestMapping("/")
    public Map<String,String> index(){
        Map<String,String> map = new HashMap<>();

        map.put("page","index page");
        map.put("date",new Date().toString());

        return map;


    }

}
