package com.matrix.easy;

/**
 * @创建人 netboy
 * @创建时间 2020/8/2
 * @描述
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution7 {
    public static int reverse(int x) {
        if( -10 < x && x < 10){
            return x;
        }
        boolean flag = x>0? false:true;
        String str = x+"";
        if(flag){
            str = str.substring(1);
        }
        char[] array = str.toCharArray();

        StringBuilder builder = new StringBuilder();
        for(int i = str.length()-1;i >=0; i--){
            builder.append(array[i]);
        }
        long temp = Long.parseLong(builder.toString());
        int result = 0;
        if(flag){
            temp = -temp;
            result = temp < Integer.MIN_VALUE ? 0: (int) temp;
        }else {
            result = temp > Integer.MAX_VALUE ? 0: (int)temp;
        }

        return result;
    }

    public static int reverse2(int x) {
        if( -10 < x && x < 10){
            return x;
        }
        int result = 0;
        while(x != 0){
            int temp = x %10;
            if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10) && temp < -8){
                return 0;
            }
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10) && temp > 7){
                return 0;
            }
            result = result*10+temp;
            x /=10;
        }
        return result;
    }


    public static void main(String[] args) {
        int x = -2147483648;
        //int x = -21474;
        int  reuslt = Solution7.reverse(x);
        System.out.print(reuslt);
    }
}
