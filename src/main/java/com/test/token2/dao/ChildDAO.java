package com.test.token2.dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ChildDAO {
    public List<ChildParent> getParentsByChildren() {
        List<ChildParent> childParents = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT ch.Name AS ChildName, fa.Name AS FatherName, mo.Name AS MotherName " +
                    "FROM CHILD ch " +
                    "LEFT JOIN PARENT fa ON ch.FATHER_ID = fa.Id " +
                    "LEFT JOIN PARENT mo ON ch.MOTHER_ID = mo.Id";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String childName = resultSet.getString("ChildName");
                String fatherName = resultSet.getString("FatherName");
                String motherName = resultSet.getString("MotherName");

                ChildParent childParent = new ChildParent(childName, fatherName, motherName);
                childParents.add(childParent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return childParents;
    }

}
