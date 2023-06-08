package com.test.token2.controller;

import com.test.token2.service.ParentService;
import com.test.token2.dao.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParentController {

    @Autowired
    ParentService parentService;

    @GetMapping("/fathers")
    public List<Parent> getAllFathersNames() {
        return parentService.getFathersNames();
    }
    @GetMapping("/mothers/{name}/countChildren/")
    public Integer countChildrenByMother(@PathVariable String name) {
        return parentService.countChildrenByMother(name);
    }
    @GetMapping("/fathers/{name}/countChildren/")
    public Integer countChildrenByFather(@PathVariable String name) {
        return parentService.countChildrenByFather(name);
    }
    @GetMapping("/fathers/multipleChildren")
    public List<String> fathersWithMultipleChildren(){
        return parentService.getFathersWithMultipleChildren();
    }
}
