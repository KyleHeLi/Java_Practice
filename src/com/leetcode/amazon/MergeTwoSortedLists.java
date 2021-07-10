package com.leetcode.amazon;

import com.leetcode.common.ListNode;
import com.leetcode.easy.MergeTwoSortedList;

// Top Amazon Questions
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = result;

        ListNode pl1 = l1;
        ListNode pl2 = l2;
        while (pl1 != null && pl2 != null) {
            if (pl1.val < pl2.val) {
                if (result == null) {
                    result = new ListNode(pl1.val);
                    current = result;
                } else {
                    current.next = new ListNode(pl1.val);
                }

                pl1 = pl1.next;
            } else {
                if (result == null) {
                    result = new ListNode(pl2.val);
                    current = result;
                } else {
                    current.next = new ListNode(pl2.val);
                }

                pl2 = pl2.next;
            }

            if (current.next != null)  current = current.next;
        }

        while (pl1 != null) {
            if (result == null) {
                result = new ListNode(pl1.val);
                current = result;
            } else {
                current.next = new ListNode(pl1.val);
                current = current.next;
            }
            pl1 = pl1.next;
        }

        while (pl2 != null) {
            if (result == null) {
                result = new ListNode(pl2.val);
                current = result;
            } else {
                current.next = new ListNode(pl2.val);
                current = current.next;
            }
            pl2 = pl2.next;
        }

        return result;
    }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode result = null;
//        ListNode current = result;
//
//        ListNode pl1 = l1;
//        ListNode pl2 = l2;
//        while (pl1 != null || pl2 != null) {
//            if (pl1 != null && pl2 != null) {
//                if (pl1.val < pl2.val) {
//                    if (result != null) {
//                        current.next = new ListNode(pl1.val);
//                        current = current.next;
//                    } else {
//                        result = new ListNode(pl1.val);
//                        current = result;
//                    }
//                } else {
//                    if (result != null) {
//                        current.next = new ListNode(pl2.val);
//                        current = current.next;
//                    } else {
//                        result = new ListNode(pl2.val);
//                        current = result;
//                    }
//                }
//            } else if (pl1 != null) {
//                if (result != null) {
//                    current.next = new ListNode(pl1.val);
//                    current = current.next;
//                } else {
//                    result = new ListNode(pl1.val);
//                    current = result;
//                }
//
//            } else {
//                if (result != null) {
//                    current.next = new ListNode(pl2.val);
//                    current = current.next;
//                } else {
//                    result = new ListNode(pl2.val);
//                    current = result;
//                }
//            }
//
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        MergeTwoSortedList test = new MergeTwoSortedList();
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        ListNode expected = new ListNode(new int[]{1, 1, 2, 3, 4, 4});
        ListNode result = test.mergeTwoLists(l1, l2);
        System.out.println(expected.equals(result));

        l1 = null;
        l2 = null;
        expected = null;
        result = test.mergeTwoLists(l1, l2);
        System.out.println(expected == result);

        l1 = null;
        l2 = new ListNode(new int[]{0});
        expected = new ListNode(new int[]{0});
        result = test.mergeTwoLists(l1, l2);
        System.out.println(expected.equals(result));
    }
}
