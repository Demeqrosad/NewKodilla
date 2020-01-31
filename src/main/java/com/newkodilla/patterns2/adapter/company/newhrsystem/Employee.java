package com.newkodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;

public class Employee
{
    final private String peselID;
    final private String firstname;
    final private String lastname;
    final private BigDecimal baseSalary;

    public Employee(String peselID, String firstname, String lastname, BigDecimal baseSalary)
    {
        this.peselID = peselID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.baseSalary = baseSalary;
    }

    public String getPeselID()
    {
        return this.peselID;
    }

    public String getFirstname()
    {
        return this.firstname;
    }

    public String getLastname()
    {
        return this.lastname;
    }

    public BigDecimal getBaseSalary()
    {
        return this.baseSalary;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || this.getClass() != o.getClass())
        {
            return false;
        }

        Employee employee = (Employee) o;

        return this.getPeselID() != null ? this.getPeselID().equals(employee.getPeselID()) : employee.getPeselID() == null;
    }

    @Override
    public int hashCode()
    {
        return this.getPeselID() != null ? this.getPeselID().hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "peselID='" + this.getPeselID() + '\'' +
                ", firstname='" + this.getFirstname() + '\'' +
                ", lastname='" + this.getLastname() + '\'' +
                ", baseSalary=" + this.getBaseSalary() +
                '}';
    }
}
