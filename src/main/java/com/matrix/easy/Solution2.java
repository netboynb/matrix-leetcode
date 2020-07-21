package com.matrix.easy;

/**
 * @创建人 netboy
 * @创建时间 2020/7/20
 * @描述 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          if(null == l1 || null == l2 ){
            return null;
          }
          ListNode result = new ListNode(0);
          ListNode pre = result;
          ListNode cur = result;
          ListNode tempL1 = l1;
          ListNode tempL2 = l2;
          int flag = 0;
          while(tempL1 != null || tempL2 != null){
            int x = tempL1 == null ? 0 : tempL1.val;
            int y = tempL2 == null ? 0 : tempL2.val;
            int sum = x + y + flag;
            flag = sum /10;
            sum = sum %10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if(tempL1 != null){
                tempL1 = tempL1.next;
            }
              if(tempL2 != null){
                  tempL2 = tempL2.next;
              }

          }
          if(flag == 1){
              cur.next = new ListNode(flag);
          }
          return pre.next;
    }

    public static void main(String[] args) {
        int[] intArray = new int[] {2,12,13,7,11,15};

        int[] reuslt = Solution1.twoSum2(intArray,9);
        for(int i=0;i<reuslt.length;i++){
            System.out.print(reuslt[i]+" ");
        }
    }
}
