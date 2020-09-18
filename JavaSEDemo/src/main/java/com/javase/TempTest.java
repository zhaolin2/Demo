package com.javase;


/**
 * 简单测试类
 */


import java.text.ParseException;
import java.util.*;

/***
 * 所有实现均基于JDK，不可使用第三方中间件
 * 1.实现下方的抽奖方法(luckdraw)，提供5000次抽奖机会，奖品有一等奖3个，二等奖 100个，三等奖50个，各个奖品需在5000次抽奖中尽量平均分布，但不可有规律被抽中
 *
 * 2.实现下方的数字查找方法，查找最大数和最小数，并得出它们的乘积（不可使用集合工具类）
 * 3.实现下方的查找方法（findAndReturn）供他人调用，传入参数为不可预知的List，分别查找List中2的倍数，5的倍数出现的次数，调用checkEqual方法判断如果返回true就不计入次数，最后返回结果集，此方法有性能要求。
 */
public class TempTest {

    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<>();
        objects.add("123");
        objects.add("456");
        objects.add("789");
        List<Object> objects1 = objects.subList(0, 1);
        System.out.println(objects1.getClass());

//        System.out.println(99 << 1);
//        System.out.println(99 >> 1);
//        System.out.println(99 >>> 1);
//
//        System.out.println(-99 >> 1);
//        System.out.println(-99 >>> 1);

    }

    /***
     * 检查是否等于100
     *@param num 比较值
     *@return 相等返回true 否则false
     */
    public static boolean checkEqual(Integer num) {
        return num == 100;
    }

    //抽奖 5000次
    // 1等奖 3个 2等奖 100个 三等奖50个
    //那么概率下来就是 3/5000  100/5000=1/50 50/5000=

    /**
     * 我的思路是首先找到一个来确定是否中奖  然后再从奖品里边来进行选择是几等奖
     * 153 5000
     * 平均32个人产生一个奖品
     * 1 -30
     * 所以 也就是5000次抽奖 不一定能够把奖抽完
     */
    public void luckDraw() {
        // do something
        int firstLength=3;
        int secondLength=100;
        int thirdLength=50;
        //先生成中奖区间 每个生成的区间应该是基本长度32
        int firstBegin= getRandom(1,32*3-3);
        int secondBegin= getRandom(32*3+1,32*3-3+1+32*100-100);
        int thirdBegin= getRandom(32*3+1+32*100+1,4950);

        boolean[] arr=new boolean[]{true};
        for (int i = 5000; i > 0; i--) {
            //[0.0,1.0)
            int random = (int) (Math.random() * (5000 - 1) + 1);
            if (random>=firstBegin && random <=firstBegin+firstLength && arr[random]){
                System.out.println("中了一等奖");
                arr[random]=false;
            }

            if (random>=secondBegin && random <=secondBegin+secondLength && arr[random]){
                System.out.println("中了二等奖");
                arr[random]=false;
            }

            if (random>=thirdBegin && random <=thirdBegin+thirdLength && arr[random]){
                System.out.println("中了三等奖");
                arr[random]=false;
            }

        }
    }

    private int getRandom(int min,int max){
        return (int) (Math.random() * (max - min)) +(min);
    }

    //数字查找 找出最大值和最小值 以及乘积
    public void findNumber() {
        String[] array = {"1", "5", "33", "7", "8", "27", "5", "90", "2", "6", "25"};
        // do something
        /**
         * 1.朴素做法 遍历一遍来进行查找 O(n)
         * 2.可以使用快速排序的变种  快速选择 来找到最大值和最小值 不过快速选择也是O(n)的 就没必要写了
         */
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String s : array) {
            //也可以赋值为int类型的最大值
            int num = Integer.MIN_VALUE;
            try {
                num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("解析出错");
            }

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }

        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);

    }

    //查找方法 2 5 的倍数 最后返回结果集

    /**
     * 1.朴素做法  遍历一遍O(n)
     * 2.因为没有特殊的性质  所以快排和二分均无法使用 无法变为logn
     *
     * @param list
     * @return
     */
    public Map<Integer, Integer> findAndReturn(List<Integer> list) {
        int twoRes = 0;
        int fiveRes = 0;
        for (Integer item : list) {
            if (checkEqual(item)) {
                break;
            } else if (item % 2 == 0) {
                twoRes++;
            } else if (item % 5 == 0) {
                fiveRes++;
            }
        }
        ;
        Map<Integer, Integer> resMap = new HashMap<>();
        resMap.put(2, twoRes);
        resMap.put(5, fiveRes);

        return resMap;
    }


}

