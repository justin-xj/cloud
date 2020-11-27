package com.justin.esstudy.controller;

import com.justin.esstudy.service.BaseElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ElasticsearchController {


    @Autowired
    private BaseElasticsearchService baseElasticsearchServiceImpl;

    @RequestMapping("/existIndex")
    public String existIndex(String idxName){
        try {
            boolean b = baseElasticsearchServiceImpl.indexExist(idxName);
            return  b+"";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }
}
