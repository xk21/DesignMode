package com.cmy.designmode.builder.method01;

import com.cmy.designmode.builder.Computer;

/**
 * @Description: 基类构建方法一
 * @Author: chenmingying
 * @CreateDate: 2018-11-6 15:57
 */
public abstract class Builder {
    //内核
    public abstract void buildBoard(String board);

    //内存
    public abstract void buildDisplay(String display);

    //系统
    public abstract void buildOS();

    //创建Computer
    public abstract Computer create();
}
