package com.test.Token2.DAO;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ParentDAO {

    public List<Parent> getFathersNames() {
        List<Parent> parents = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT DISTINCT p.Id, p.Name FROM PARENT p JOIN CHILD c ON p.Id = c.FATHER_ID WHERE c.FATHER_ID IS NOT NULL;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                Parent parent = new Parent(id, name);
                parents.add(parent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parents;
    }

}




