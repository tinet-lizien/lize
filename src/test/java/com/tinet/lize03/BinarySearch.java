package com.tinet.lize03;

import org.apache.commons.lang3.ArrayUtils;

import java.util.stream.Stream;

/**
 *  二分查找算法
 *
 * @author lize
 * @date 2022年06月03日 19:25
 */
public class BinarySearch {
    public static void main(String[] args) {
        Integer[] array = {1,5,8,11,19,22,31,35,40,45,48,49,50};
        //先排序
        Integer[] sortedArray = Stream.of(array).sorted((a1, a2) -> a1.compareTo(a2)).toArray(Integer[]::new);
        System.out.println(ArrayUtils.toString(sortedArray));
        int target = 48;
        int idx = binarSearch(sortedArray,target);
        System.out.println(idx);
    }
    public static int binarSearch(Integer[] array,Integer target){
        int l = 0,r = array.length -1,m;
        while (l <= r){
            //这种写法会出现整数溢出问题
            m=(l+r)/2;
            //方法1解决整数溢出
            m=l+(-l+r)/2;
            //方法2解决整数溢出
            m=(l+r)>>>1;
            if(array[m]==target){
                return m;
            }else if(array[m]>target){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return -1;
    }
}
