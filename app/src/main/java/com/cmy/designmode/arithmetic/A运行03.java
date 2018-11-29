package com.cmy.designmode.arithmetic;

import com.cmy.designmode.observer.Boy;
import com.cmy.designmode.observer.Girl;
import com.cmy.designmode.observer.Observable;
import com.cmy.designmode.observer.Observer;
import com.cmy.designmode.observer.Postman;

import java.util.Arrays;

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
        int[] a = {5,5,9,3,8,1,8};
        int[] b = {1,2,3,6,5,4,3,6,12,8};
//        1.选择排序b
        System.out.println("选择排序........."+Arrays.toString(排序.insertSort(a)));


        System.out.println("冒泡排序........."+Arrays.toString(排序.bubbleSort1(b)));


        System.out.println(".........");
    }
}
