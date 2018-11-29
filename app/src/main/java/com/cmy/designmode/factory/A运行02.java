package com.cmy.designmode.factory;

import com.cmy.designmode.builder.method01.Builder;
import com.cmy.designmode.builder.method01.Director;
import com.cmy.designmode.builder.method01.MacBookBuilder;
import com.cmy.designmode.builder.method02.HaiWeiBookBuilder;
import com.cmy.designmode.factory.method01.FactoryA;
import com.cmy.designmode.factory.method02.ProductFactory;

/**
 * @Description:
 *
 *     Product（抽象产品类）：要创建的复杂对象，定义对象的公共接口。
 *     ConcreteProduct（具体产品类）：实现Product接口。
 *     Factory（抽象工厂类）：该方法返回一个Product类型的对象。
 *     ConcreteFactory（具体工厂类）：返回ConcreteProduct实例
 *
 * @Author: chenmingying
 * @CreateDate: 2018-11-7 15:55
 */
public class A运行02 {
    public static void main(String[] args){
//        1.工厂模式
        System.out.println("工厂模式.........");
        new FactoryA().createProduct().method();
        System.out.println("简单工厂.........");

//        2.优化后的使用 简单工厂
        new ProductFactory().createProduct(ProductB.class).method();

        System.out.println("结束.........");
    }
}
