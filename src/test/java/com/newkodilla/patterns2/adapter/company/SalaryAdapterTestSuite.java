package com.newkodilla.patterns2.adapter.company;

import com.newkodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.Assert;
import org.junit.Test;

public class SalaryAdapterTestSuite
{
    @Test
    public void testTotalSalary()
    {
        //Given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //When
        double totalSalary = salaryAdapter.TotalSalary(workers.getWorkers(), workers.getSalaries());
        //Then
        System.out.println(totalSalary);
        Assert.assertEquals(27750, totalSalary, 0);
    }
}
