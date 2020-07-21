package com.matrix.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 netboy
 * @创建时间 2020/7/20
 * @描述 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {

    public static int lengthOfLongestSubstring(String s) {
        if(null == s || s.length() == 0){
            return 0;
        }

        int preIndex = 0;
        int max = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i< s.length();i++){
            String key = s.charAt(i)+"";
            Integer temp = map.get(key);
            if(temp != null && temp >= preIndex){
                int tempMax  = i - preIndex;
                max = max > tempMax ? max : tempMax;
                preIndex = temp + 1;
            }else if(i == s.length()-1){
                int tempMax  = i - preIndex+1;
                max = max > tempMax ? max : tempMax;
                continue;
            }
            map.put(key,i);

        }
        return max;
    }

    public static void main(String[] args) {
        //String str = "pwwkew";
        String str ="pwwkew";

        int result = Solution3.lengthOfLongestSubstring(str);

            System.out.print(result);

    }
}
