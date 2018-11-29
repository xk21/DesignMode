package com.cmy.designmode.factory.method02;

import com.cmy.designmode.factory.Product;

/**
 * @Description: java类作用描述
 * @Author: chenmingying
 * @CreateDate: 2018-11-7 16:49
 */
public class ProductFactory extends Factory02 {
    @Override
    public <T extends Product> T createProduct(Class<T> tClass) {
        Product product = null;
        try {
            product = (Product) Class.forName(tClass.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T) product;
    }
}
