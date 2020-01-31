package com.newkodilla.patterns2.observer.homework;

public interface ObservableQueue
{
    public void subscribeObserver(QueueObserver queueObserver);
    public void notifyObservers();
    public void unsubscribeObserver(QueueObserver queueObserver);
}
