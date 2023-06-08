package com.test.Token2.DAO;

import org.springframework.stereotype.Repository;

import java.sql.*;
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
    public Integer countChildrenByMother(String name) {

        int childCount = 0;
        String query = "SELECT COUNT(*) AS ChildCount " +
                "FROM CHILD " +
                "WHERE MOTHER_ID = (SELECT Id FROM PARENT WHERE Name = ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    childCount = resultSet.getInt("ChildCount");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return childCount;
    }
    public Integer countChildrenbyFather(String name) {

        int childCount = 0;
        String query = "SELECT COUNT(*) AS ChildCount " +
                "FROM CHILD " +
                "WHERE FATHER_ID = (SELECT Id FROM PARENT WHERE Name = ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    childCount = resultSet.getInt("ChildCount");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return childCount;
    }


}




