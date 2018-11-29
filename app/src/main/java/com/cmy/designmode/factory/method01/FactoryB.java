package com.cmy.designmode.factory.method01;


import com.cmy.designmode.factory.Factory;
import com.cmy.designmode.factory.Product;
import com.cmy.designmode.factory.ProductB;

/**
 * @Description: java类作用描述
 * @Author: chenmingying
 * @CreateDate: 2018-11-7 16:31
 */
public class FactoryB extends Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
