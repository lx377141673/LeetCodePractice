package xyz.liangxin.leetcode.practice.difficulty;

/**
 * 题目:
 * 2. 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

        String numStr1 = "77786456785613275613654567456";
        String numStr2 = "299999999999999999999999999999999999999999999999999999999";
        ListNode listNode1 = initListNode(numStr1);
        ListNode listNode2 = initListNode(numStr2);
        System.out.println(getNumStr(initListNode(numStr1)));
        long begin=System.currentTimeMillis();
        ListNode result = addTwoNumbers(listNode1, listNode2);
        System.out.println("-----------"+(System.currentTimeMillis()-begin));
        System.out.println(getNumStr(result));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addListNode(l1, l2, 0);
    }


    public static ListNode addListNode(ListNode l1, ListNode l2, int addNum) {

        int num1 = l1 != null ? l1.val : 0;
        int num2 = l2 != null ? l2.val : 0;
        int result = num1 + num2 + addNum;
        addNum = 0;
        if (result >= 10) {
            result = result % 10;
            addNum = 1;
        }

        if (l1 != null || l2 != null || result > 0) {
            ListNode listNode = new ListNode(result);
            listNode.next = addListNode(l1 != null ? l1.next : null, l2 != null ? l2.next : null, addNum);
            return listNode;
        }


        return null;
    }

    public static String getNumStr(ListNode listNode) {
        if (listNode == null) {
            return "";
        }
        String reuslt = listNode.val + "";
        if (listNode.next != null) {
            return getNumStr(listNode.next) + reuslt;
        }
        return reuslt;
    }

    public static ListNode initListNode(String numStr) {
        if (numStr != null && numStr.length() > 0) {
            int val = Integer.valueOf(numStr.substring(numStr.length() - 1, numStr.length()));
            ListNode listNode = new ListNode(val);
            listNode.next = initListNode(numStr.substring(0, numStr.length() - 1));
            return listNode;
        }
        return null;
    }

    public static String strAdd(String str1, String str2) {
        ListNode listNode1 = initListNode(str1);
        ListNode listNode2 = initListNode(str2);
        return getNumStr(addTwoNumbers(initListNode(str1), initListNode(str2)));
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

