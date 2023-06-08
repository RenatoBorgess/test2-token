package com.test.token2.controller;

import com.test.token2.dao.ChildParent;
import com.test.token2.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChildController {
    @Autowired
    ChildService childService;

    @GetMapping("/parents")
    public List<ChildParent> getParentsForChildren(){
        return childService.getParentsByChildren();
    }
}
