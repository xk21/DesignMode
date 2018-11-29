package com.cmy.designmode.builder.method02;


import com.cmy.designmode.builder.Computer;

/**
 * @Description: 子类构建者HaiWeiBookBuilder
 * @Author: chenmingying
 * @CreateDate: 2018-11-6 16:05
 */
public class HaiWeiBookBuilder extends Builder2 {
    private Computer mComputer = new HaiWeiBook();
    @Override
    public HaiWeiBookBuilder buildBoard(String board) {
        mComputer.setBoard(board);
        return this;
    }

    @Override
    public HaiWeiBookBuilder buildDisplay(String display) {
        mComputer.setDisplay(display);
        return this;
    }

    @Override
    public HaiWeiBookBuilder buildOS() {
        mComputer.setOS();
        return this;
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
