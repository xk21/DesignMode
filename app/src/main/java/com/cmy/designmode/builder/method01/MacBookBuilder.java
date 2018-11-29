package com.cmy.designmode.builder.method01;


import com.cmy.designmode.builder.Computer;
import com.cmy.designmode.builder.method01.Builder;
import com.cmy.designmode.builder.method01.MacBook;

/**
 * @Description: 子类构建者MacBookBuilder
 * @Author: chenmingying
 * @CreateDate: 2018-11-6 16:05
 */
public class MacBookBuilder extends Builder {
    private Computer mComputer = new MacBook();
    @Override
    public void buildBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    public void buildOS() {
        mComputer.setOS();
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
