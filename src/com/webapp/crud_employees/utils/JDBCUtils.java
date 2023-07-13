package com.webapp.crud_employees.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBCUtils 
{
	private static String jdbcUrl = "jdbc:mysql://localhost:3306/db_employees_custom_app_crud";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "MySQL_Pass";
    
    public static Connection getConnection()
    {
    	Connection connection = null;
    	
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	
    	return connection;
    }
    
    public static Date getSQLDate(LocalDate date)
    {
    	return java.sql.Date.valueOf(date);
    }
    
    public static Date getSQLDate(String date)
    {
    	return java.sql.Date.valueOf(date);
    }
    
    public static LocalDate getUtilDate(Date sqlDate)
    {
    	return sqlDate.toLocalDate();
    }
}
