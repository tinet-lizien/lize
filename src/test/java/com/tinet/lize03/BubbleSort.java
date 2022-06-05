package com.tinet.lize03;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author lize
 * @date 2022年06月04日 13:15
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,9,7,4,1,3,2,8};
        bubble_v2(arr);
        System.out.println(ArrayUtils.toString(arr));
    }
    //基础版
    private static void bubble(int[] arr){
        for (int j = 0; j < arr.length -1; j++) {
            boolean flag = false;
            for (int i = 0; i < arr.length - 1 -j ; i++) {
                //交換
                if(arr[i] > arr[i+1]){
                    flag = true;
                    int t = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = t;
                }
            }
            if(!flag){
                break;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    //优化版
    private static void bubble_v2(int[] arr){
        int n = arr.length -1;
        while (true) {
            int last = 0; //最后一次交换索引位置
            for (int i = 0; i < n ; i++) {
                System.out.println("比较次数"+i);
                //交換
                if(arr[i] > arr[i+1]){
                    last = i;
                    int t = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = t;
                }
            }
            n = last;
            System.out.println("第轮冒泡"+Arrays.toString(arr));
            if(n == 0){
                break;
            }
            System.out.println(ArrayUtils.toString(arr));
        }
    }
}
