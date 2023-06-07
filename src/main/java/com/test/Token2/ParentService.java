package com.test.Token2;

import com.test.Token2.DAO.Parent;
import com.test.Token2.DAO.ParentDAO;
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
        return parentDAO.countChildrenForMother(name);
    }
}
