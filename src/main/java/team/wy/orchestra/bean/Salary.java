package team.wy.orchestra.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @className: Salary
 * @description:
 * @author: YORE
 * @date: 2022/7/17
 **/
public class Salary implements Serializable {

    private String SSN;
    private Date date;
    private double salary;

    @Override
    public String toString() {
        return "Salary{" +
                "SSN='" + SSN + '\'' +
                ", date=" + date +
                ", salary=" + salary +
                '}';
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
