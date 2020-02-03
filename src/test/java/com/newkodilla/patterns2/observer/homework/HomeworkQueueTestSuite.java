package com.newkodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class HomeworkQueueTestSuite
{
    @Test
    public void testAddHomework()
    {
        //Given
        HomeworkQueue student1Homeworks = new HomeworkQueue("Student1");
        HomeworkQueue student2Homeworks = new HomeworkQueue("Student2");
        HomeworkQueue student3Homeworks = new HomeworkQueue("Student3");
        HomeworkQueue student4Homeworks = new HomeworkQueue("Student4");
        Mentor mentor13 = new Mentor("Mentor13");
        Mentor mentor234 = new Mentor("Mentor234");
        student1Homeworks.subscribeObserver(mentor13);
        student2Homeworks.subscribeObserver(mentor234);
        student3Homeworks.subscribeObserver(mentor13);
        student3Homeworks.subscribeObserver(mentor234);
        student4Homeworks.subscribeObserver(mentor234);
        //When
        student1Homeworks.addHomework("Homework1.1");
        student2Homeworks.addHomework("Homework2.1");
        student3Homeworks.addHomework("Homework3.1");
        student3Homeworks.unsubscribeObserver(mentor234);
        student3Homeworks.addHomework("Homework3.2");
        student4Homeworks.addHomework("Homework4.1");
        //Then
        Assert.assertEquals(3, mentor13.getBeInformedCount());
        Assert.assertEquals(3, mentor234.getBeInformedCount());
        Assert.assertEquals(2, student3Homeworks.getHomeworks().size());
        Assert.assertEquals(1, student3Homeworks.getMentors().size());
    }
}
