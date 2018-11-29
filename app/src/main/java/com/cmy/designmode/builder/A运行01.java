package com.cmy.designmode.builder;

import com.cmy.designmode.builder.method01.Builder;
import com.cmy.designmode.builder.method01.Director;
import com.cmy.designmode.builder.method01.MacBookBuilder;
import com.cmy.designmode.builder.method02.HaiWeiBookBuilder;

/**
 * @Description:
 *
 *     Product -- 产品的抽象类
 *     Builder -- 抽象Builder类,规范产品组建,一般是由子类实现具体的组建
 *     ConcreteBuilder -- 具体的Builder类
 *     Director  --  统一组装的类
 *     eg.............
 *     Computer(Product)计算机基类继承者分别为HaiWeiBook和MacBook
 *     优点:
 *
 * @Author: chenmingying
 * @CreateDate: 2018-11-7 15:55
 */
public class A运行01 {
    public static void main(String[] args){
//        1.第一种原始的构建模式 builder
        System.out.println("开始.........");
        Builder builder = new MacBookBuilder();
        Director director = new Director(builder);
        director.construct("因特尔4核","100g内存");
        System.out.println(builder.create().toString());
        System.out.println(".........");

//        2.优化后的使用 builder2
        System.out.println(new HaiWeiBookBuilder().buildBoard("激灵主机").buildDisplay("超级内存").buildOS().
                create().toString());
        System.out.println("结束.........");
    }
}
