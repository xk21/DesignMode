package com.cmy.designmode.builder.method01;

import com.cmy.designmode.builder.method01.Builder;

/**
 * @Description: 统一组装类
 * @Author: chenmingying
 * @CreateDate: 2018-11-6 17:18
 */
public class Director {
    Builder mBuilder = null;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public void construct(String board , String display){
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }
}
