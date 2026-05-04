package com.csit228.capstone.dao;

import com.csit228.capstone.database.DBConnector;
import com.csit228.capstone.model.Department;
import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    private static List<Department> departments;

    private static DepartmentDAO departmentDAO;

    private DepartmentDAO(){
        departments = new ArrayList<>();
    }

    public static DepartmentDAO getDepartmentDAO(){
        if(departmentDAO == null){
            departmentDAO = new DepartmentDAO();
        }
        return departmentDAO;
    }

    public void fetchDepartments(){
        try(Connection c = DBConnector.getConnection();
            Statement s = c.createStatement()){

        }
    }
}
