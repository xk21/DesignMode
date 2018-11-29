package com.cmy.designmode.observer;

/**
 * @Description: 观察者具体类
 * @Author: chenmingying
 * @CreateDate: 2018-11-16 17:50
 */
public class Girl implements Observer {
    private String name;

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public void update(String s) {
        System.out.println(name + ",收到了信息:" + s+"让男朋友去取快递~");
    }
}
