package com.newkodilla.patterns2.observer.homework;

public class Mentor implements QueueObserver
{
    private final String name;
    private int beInformedCount;

    public Mentor(String name)
    {
        this.name = name;
    }

    @Override
    public void beInformed(HomeworkQueue homeworkQueue)
    {
        System.out.println(this.name + ", you have received new homework from " +
                homeworkQueue.getStudent() + "\n" + "There are " +
                homeworkQueue.getHomeworks().size() + " homeworks to be checked.");
        beInformedCount++;
    }

    public String getName()
    {
        return this.name;
    }

    public int getBeInformedCount()
    {
        return this.beInformedCount;
    }
}
