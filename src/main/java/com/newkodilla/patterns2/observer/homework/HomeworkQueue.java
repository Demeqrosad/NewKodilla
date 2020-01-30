package com.newkodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements ObservableQueue
{
    private final String student;
    private final List<QueueObserver> mentors = new ArrayList<>();
    private final ArrayDeque<String> homeworks = new ArrayDeque<>();

    public HomeworkQueue(final String student)
    {
        this.student = student;
    }

    @Override
    public void subscribeObserver(QueueObserver queueObserver)
    {
        mentors.add(queueObserver);
    }

    public void notifyObservers()
    {
        for (QueueObserver mentor : mentors)
        {
            mentor.beInformed(this);
        }
    }

    @Override
    public void unsubscribeObserver(QueueObserver queueObserver)
    {
        mentors.remove(queueObserver);
    }

    public void addHomework(String homework)
    {
        homeworks.offerLast(homework);
        notifyObservers();
    }

    public String getStudent()
    {
        return this.student;
    }

    public List<QueueObserver> getMentors()
    {
        return this.mentors;
    }

    public ArrayDeque<String> getHomeworks()
    {
        return this.homeworks;
    }
}
