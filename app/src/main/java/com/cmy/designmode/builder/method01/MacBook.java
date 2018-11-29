package com.cmy.designmode.builder.method01;

import com.cmy.designmode.builder.Computer;

/**
 * @Description: 具体计算机MacBook
 * @Author: chenmingying
 * @CreateDate: 2018-11-6 15:53
 */
public class MacBook extends Computer {
    public MacBook() {
    }

    @Override
    public void setOS() {
        mOS = "Mac OS X 10.11";
    }
}
