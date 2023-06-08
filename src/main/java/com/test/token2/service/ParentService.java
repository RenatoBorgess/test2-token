package com.test.token2.service;

import com.test.token2.dao.Parent;
import com.test.token2.dao.ParentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    @Autowired
    ParentDAO parentDAO;

    public List<Parent> getFathersNames() {
        return parentDAO.getFathersNames();
    }
    public Integer countChildrenByMother(String name){
        return parentDAO.countChildrenByMother(name);
    }

    public Integer countChildrenByFather(String name) {
        return parentDAO.countChildrenbyFather(name);
    }
    public List<String> getFathersWithMultipleChildren(){
        return parentDAO.getFathersWithMultipleChildren();
    }
}
