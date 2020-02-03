package com.newkodilla.patterns2.observer.forum;

public interface Observable
{
    public void registerObserver(Observer observer);
    public void notifyObservers();
    public void removeObserver(Observer observer);
}
