package com.tinet.lize03;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author lize
 * @date 2022年06月04日 14:02
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,9,7,4,1,3,2,8};
        selction(arr);
        System.out.println(ArrayUtils.toString(arr));
    }

    private static void selction(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            //i 代表每轮选择最小元素要交换的目标索引
            int s=i;//代表最小元素的索引
            for (int j = s + 1; j < arr.length; j++) {
                if(arr[s]>arr[j]){
                    s=j;
                }
            }
            if(s!=i){
                int t = arr[s];
                arr[s] = arr[i];
                arr[i] = t;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
