package com.cmy.designmode.factory.method02;

import com.cmy.designmode.factory.Product;

/**
 * @Description: java类作用描述
 * @Author: chenmingying
 * @CreateDate: 2018-11-7 16:45
 */
public abstract class Factory02 {
    public abstract <T extends Product> T createProduct(Class<T> tClass);
}
