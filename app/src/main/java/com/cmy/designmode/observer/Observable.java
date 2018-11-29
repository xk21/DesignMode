package com.cmy.designmode.observer;

/**
 * @Description: 被观察者抽象类
 * @Author: chenmingying
 * @CreateDate: 2018-11-16 17:42
 */
public interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void notify(String message);
}
