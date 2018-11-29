package com.cmy.designmode.arithmetic;

import android.util.Log;

/**
 * @Description: java类作用描述
 * @Author: chenmingying
 * @CreateDate: 2018-11-28 13:53
 */
public class 排序 {

    //插入排序 升序
    public static int[] insertSort(int [] a){
        int len=a.length;//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for(int i=1;i<len;i++){//因为第一次不用，所以从1开始
            insertNum=a[i];
            int j=i-1;//序列元素个数
            while(j>=0&&a[j]>insertNum){//从后往前循环，将大于insertNum的数向后移动
                a[j+1]=a[j];//元素向后移动
                j--;
            }
           System.out.println( "i="+j+1);
            a[j+1]=insertNum;//找到位置，插入当前元素
        }
        return a;
    }

    //希尔排序
    public void sheelSort(int [] a){
        int len=a.length;//单独把数组长度拿出来，提高效率
        while(len!=0){
            len=len/2;
            for(int i=0;i<len;i++){//分组
                for(int j=i+len;j<a.length;j+=len){//元素从第二个开始
                    int k=j-len;//k为有序序列最后一位的位数
                    int temp=a[j];//要插入的元素
                    /*for(;k>=0&&temp<a[k];k-=len){
                        a[k+len]=a[k];
                    }*/
                    while(k>=0&&temp<a[k]){//从后往前遍历
                        a[k+len]=a[k];
                        k-=len;//向后移动len位
                    }
                    a[k+len]=temp;
                }
            }
        }
    }

    //选择排序
    public void selectSort(int[]a){
        int len=a.length;
        for(int i=0;i<len;i++){//循环次数
            int value=a[i];
            int position=i;
            for(int j=i+1;j<len;j++){//找到最小的值和位置
                if(a[j]<value){
                    value=a[j];
                    position=j;
                }
            }
            a[position]=a[i];//进行交换
            a[i]=value;
        }
    }

    //冒泡排序
    public static int[] bubbleSort(int []a){
        int len=a.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){//注意第二重循环的条件
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return a;
    }
    //冒泡排序
    public static int[] bubbleSort1(int []a){
        int len=a.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){//注意第二重循环的条件
                if(a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }

}
