package org.fernando.salas.part09.observer;

public interface Subject {
    void registerObserver(Observer observer);

    void notifyObservers(String tweet);
}
