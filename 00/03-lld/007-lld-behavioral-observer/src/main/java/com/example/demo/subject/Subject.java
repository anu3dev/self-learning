package com.example.demo.subject;

import com.example.demo.observer.Observer;

public interface Subject {
	void subscribe(Observer observer);
	void unsubscribe(Observer observer);
	void notifyObservers();
}
