package com.cmy.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 被观察者具体类
 * @Author: chenmingying
 * @CreateDate: 2018-11-16 17:52
 */
public class Postman implements Observable {
    private List<Observer> mObserverList = new ArrayList<>();
    @Override
    public void add(Observer observer) {
        mObserverList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        mObserverList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer :mObserverList){
            observer.update(message);
        }

    }
}
