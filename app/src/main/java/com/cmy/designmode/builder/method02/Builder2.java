package com.cmy.designmode.builder.method02;

import com.cmy.designmode.builder.Computer;

/**
 * @Description: 基类构建方法二
 * @Author: chenmingying
 * @CreateDate: 2018-11-6 15:57
 */
public abstract class Builder2 {
    //内核
    public abstract Builder2 buildBoard(String board);

    //内存
    public abstract Builder2 buildDisplay(String display);

    //系统
    public abstract Builder2 buildOS();

    //创建Computer
    public abstract Computer create();
}
