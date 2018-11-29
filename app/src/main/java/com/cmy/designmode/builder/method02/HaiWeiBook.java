package com.cmy.designmode.builder.method02;

import com.cmy.designmode.builder.Computer;

/**
 * @Description: 具体计算机HaiWeiBook
 * @Author: chenmingying
 * @CreateDate: 2018-11-6 15:53
 */
public class HaiWeiBook extends Computer {
    public HaiWeiBook() {
    }

    @Override
    public void setOS() {
        mOS = "麒麟 OS X 10.11";
    }
}
