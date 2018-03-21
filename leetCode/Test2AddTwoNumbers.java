package leetCode;

//import java.text.DecimalFormat;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

/**
 * Created by IntelliJ IDEA.
 * Author: Gu Jindong
 * Date: 2018/3/19
 * Time: 10:44
 **/

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Test2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        double val1 = 0, val2 = 0;
        double val3;
        int i = 0, j = 0;

        //fetch val1
        while (l1 != null){
            val1 += l1.val * Math.pow(10,i);
            i++;
            l1 = l1.next;
        }

        //fetch val2
        while (l2 != null){
            val2 += l2.val * Math.pow(10,j);
            j++;
            l2 = l2.next;
        }

        //val3 to sum val1 and val2
        val3 = val1 + val2;

        //first string split to chars, second char convert to int , at last int value store in listNode.
        java.text.DecimalFormat df = new java.text.DecimalFormat("0");
        String val3Str = df.format(val3);//double转string，也避免超过10位使用科学计数法，正常计数并全部转成字符串
        System.out.println(val3Str);
        ListNode first = null, last = null;
        int len = val3Str.length() - 1;
        while (len >= 0){
            int va = val3Str.charAt(len) - '0';//ascii to int
            ListNode node = new ListNode(va);
            node.next = null;
            if (first == null){
                first = node;
                last = node;
            }else {
                last.next = node;
                last = node;
            }
            len--;
        }

        return first;

    }
//上面addTwoNumbers先把整体的数给合并后再相加，那么后面就算int换成double也会有越界的存在
// 所以用addTwoNumbersV2的方式，每个位置上单独去加，进位也进行下一次运算。

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2){
        ListNode head = null, last = null;
        int carry = 0;//进位

        while (l1 != null || l2 != null){
            int sum = 0;
            int x = 0, y = 0;
            x = (l1 != null)? l1.val : 0;
            y = (l2 != null)? l2.val : 0;

            sum = x + y + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (head == null){
                head = node;
                last = node;
            }else {
                last.next = node;
                last = node;

            }

            l1 = (l1 != null)? l1.next : null;
            l2 = (l2 != null)? l2.next : null;
        }

        if (carry > 0){
            ListNode nod = new ListNode(carry);
            last.next = nod;
        }

        return head;
    }


    public static void main(String[] args){

        Test2AddTwoNumbers t2 = new Test2AddTwoNumbers();

        ListNode l1 = null;
        ListNode l2 = null;
        ListNode l3 = null;
        ListNode l4 = null;
        ListNode l5 = null;
        int i = 3, j = 3;

//        l1 = new ListNode(3);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(1);
        l1 = new ListNode(9);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(1);


//        l2 = new ListNode(1);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);

//        ListNode first = null, last = null;
//        while (j > 0){
//            ListNode l = new ListNode(j);
//            l.next = null;
//            if (first == null){
//                first = l;
//                last = l;
//            }else {
//                last.next = l;
//                last = l;
//            }
//            j--;
//        }

        ListNode first = null, last = null;
        j = 9;
        first = new ListNode(1);
        last = first;
        while (j > 0){
            ListNode l = new ListNode(9);
            l.next = null;
            if (first == null){
                first = l;
                last = l;//////////////////////拼接链表的方式
            }else {
                last.next = l;//////////
                last = l;////////////
            }
            j--;
        }

        l4 = first;

        System.out.println("Input:");
        t2.printListNode(l1);
        t2.printListNode(l4);

        l3 = t2.addTwoNumbers(l1,l4);

        System.out.println("Output:");
        t2.printListNode(l3);

        l5 = t2.addTwoNumbersV2(l1,l4);
        System.out.println("Output:");
        t2.printListNode(l5);


    }

    public void printListNode(ListNode l){
        StringBuilder printSting = new StringBuilder("[");
        while (l != null){
            printSting.append(l.val).append(",");
            l = l.next;
        }
        printSting.append("]");
        System.out.println(printSting);
    }
}
