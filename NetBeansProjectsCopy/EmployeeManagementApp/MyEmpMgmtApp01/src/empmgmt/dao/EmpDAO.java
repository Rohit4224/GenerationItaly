/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empmgmt.dao;

import empmgmt.dbutil.DBconnection;
import empmgmt.pojo.Employee;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import java.awt.List;


/**
 *
 * @author rohit
 */
public class EmpDAO
{
    public static boolean addEmployee(Employee e) throws SQLException
    {
        Connection conn = DBconnection.getConnection();
        
        PreparedStatement ps = conn.prepareStatement("insert into Employees values (?, ?, ?)");
        ps.setInt(1, e.getEmpNo());
        ps.setString(2, e.getEmpName());
        ps.setDouble(3, e.getEmpSal());
        
        int result = ps.executeUpdate();
        
        return (result == 1);
    }
    
    public static boolean updateEmployee(Employee e) throws SQLException {
    Connection conn = DBconnection.getConnection();

    // Use the UPDATE statement instead of INSERT
    PreparedStatement ps = conn.prepareStatement("UPDATE Employees SET Ename = ?, salary = ? WHERE Empno = ?");
    ps.setString(1, e.getEmpName());
    ps.setDouble(2, e.getEmpSal());
    ps.setInt(3, e.getEmpNo());

    int result = ps.executeUpdate();

    return (result == 1);
    }

    
    public static Employee findEmployeeById(int empno) throws SQLException
    {
        Connection conn = DBconnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from Employees where empno = ?");
        ps.setInt(1, empno);
        ResultSet rs = ps.executeQuery();
        if (rs.next())
        {
            Employee e = new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
            return e;
        }
        else
            return null;
    }
    
    public static ArrayList<Employee> getAllEmployee() throws SQLException
    {
        Connection conn = DBconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from Employees");
        
        ArrayList<Employee> empList = new ArrayList<>();
        while(rs.next())
        {
            Employee e = new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
            
            empList.add(e);
        }
        return empList;
    }
    
    public static boolean deleteEmployeeById(int empId) throws SQLException {
    Connection conn = DBconnection.getConnection();

    // Use the DELETE statement to delete an employee by ID
    PreparedStatement ps = conn.prepareStatement("DELETE FROM Employees WHERE Empno = ?");
    ps.setInt(1, empId);

    int result = ps.executeUpdate();

    return (result == 1);
    }
    
}
