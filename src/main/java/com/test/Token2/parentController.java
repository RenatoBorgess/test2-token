package com.test.Token2;

import com.test.Token2.DAO.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class parentController {

    @Autowired
    ParentService parentService;

    @GetMapping("/fathers")
    public List<Parent> getAllFathersNames() {
        return parentService.getFathersNames();
    }
    @GetMapping("/countChildren/{name}")
    public Integer countChildrenByMother(@PathVariable String name) {
        return parentService.countChildrenByMother(name);
    }
    @GetMapping("/countChildren/{name}")
    public Integer countChildrenByFather(@PathVariable String name) {
        return parentService.countChildrenByFather(name);
    }
}
