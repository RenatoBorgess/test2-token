package com.test.token2.service;

import com.test.token2.dao.ChildDAO;
import com.test.token2.dao.ChildParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChildService {
    @Autowired
    ChildDAO childDAO;

    public List<ChildParent> getParentsByChildren(){
        return childDAO.getParentsByChildren();
    }
}
