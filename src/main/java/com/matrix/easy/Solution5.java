package com.matrix.easy;
/**
 * @创建人 netboy
 * @创建时间 2020/7/21
 * @描述 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {
    public static String longestPalindrome(String s) {
        if(null == s || s.length() <= 1){
            return s;
        }
        String maxSub = null;

        // string's size  must >= 3
        for(int i = 0; i < s.length()-1 ; i++ ){
            int left = i-1;
            int cleft = i;
            int right = i+1;
            int cright = right;
            String temp = s.charAt(i)+"";
            String ctemp = temp;
            boolean flag=false,cflag=false;
            while((left >=0 || cleft >=0) && (right <=s.length()-1 || cright <=s.length()-1)){
                if(left >=0 && right <=s.length()-1 && s.charAt(left) == s.charAt(right)){
                    temp = s.substring(left,right+1);
                    left = left -1;
                    right = right +1;
                }else {
                    temp = s.substring(left+1,right);
                    flag = true;
                }
                if(cleft >=0 && cright <=s.length()-1 && s.charAt(cleft) == s.charAt(cright)){
                    ctemp = s.substring(cleft,cright+1);
                    cleft = cleft -1;
                    cright = cright +1;
                } else {
                    ctemp = s.substring(cleft+1, cright);
                    cflag = true;
                }
                if(flag && cflag){
                    break;
                }
            }
            if(maxSub == null || maxSub.length() < temp.length()){
                maxSub = temp;
            }
            if( maxSub.length() < ctemp.length()){
                maxSub = ctemp;
            }
        }
        return maxSub;
    }
    public static String longestPalindrome2(String s) {

        if(null == s || s.length() < 2){
            return s;
        }
        String maxSub = s.substring(0,1);
        for(int i= 0;i < s.length();i++){
            String jiSub = subL(s,i,i);
            String ouSub = subL(s,i,i+1);
            maxSub = maxSub.length() > jiSub.length() ? maxSub : jiSub;
            maxSub = maxSub.length() > ouSub.length() ? maxSub : ouSub;
        }
        return maxSub;
    }

    private static String subL(String s,int l,int r){

        if(s == null || l > r){
            return s;
        }
        while(l >=0 && r < s.length()){
            if(s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }else {
                break;
            }
        }
        return s.substring(l+1,r);
    }

    public static void main(String[] args) {
        String s = "babad";
        String reuslt = Solution5.longestPalindrome2(s);
        System.out.print(reuslt);
    }

}
