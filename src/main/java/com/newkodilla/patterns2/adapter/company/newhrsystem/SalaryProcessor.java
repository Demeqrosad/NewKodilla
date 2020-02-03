package com.newkodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.List;

public interface SalaryProcessor
{
    public BigDecimal calculateSalaries(List<Employee> employees);
}
