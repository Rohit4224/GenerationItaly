/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empmgmt.pojo;

/**
 *
 * @author rohit
 */
public class Employee
{
    public Employee()
    {
                
    }

    public Employee(int empNo, String empName, double empSal) {
        this.empNo = empNo;
        this.empName = empName;
        this.empSal = empSal;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }
    private int empNo;
    private String empName;
    private double empSal;
}
