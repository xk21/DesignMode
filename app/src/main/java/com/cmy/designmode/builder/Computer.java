package com.cmy.designmode.builder;

/**
 * @Description: 产品基类
 * @Author: chenmingying
 * @CreateDate: 2018-11-6 15:42
 */
public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOS;

    //内存
    public void setDisplay(String display) {
        mDisplay = display;
    }

    //操作系统
    public abstract void setOS();

    //核心数
    public void setBoard(String board) {
        mBoard = board;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOS='" + mOS + '\'' +
                '}';
    }
}
