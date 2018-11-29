package com.cmy.designmode.observer;

import com.cmy.designmode.factory.ProductB;
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
public class A运行03 {
    public static void main(String[] args){
//        1.工厂模式
        System.out.println(".........");
        Observable postman=new Postman();

        Observer boy1=new Boy("路飞");
        Observer boy2=new Boy("乔巴");
        Observer girl1=new Girl("娜美");

        postman.add(boy1);
        postman.add(boy2);
        postman.add(girl1);

        postman.notify("快递到了,请下楼领取.");

        System.out.println(".........");


        System.out.println(".........");
    }
}
