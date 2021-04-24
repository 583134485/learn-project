package com.example;

import java.util.*;
import java.util.stream.Collectors;


public class Solution {


    public int[] twoSum(int[] numbers, int target) {

        int[] index = new int[2];
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            } else {
                map.put((target - num), i);
            }

        }
        return index;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> alist = new ArrayList<>();
        if (k > input.length) return alist;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            alist.add(input[i]);
        }
        return alist;
    }

    public int[] MySort(int[] arr) {
//         int[] arr =Arrays.copyOf(arr2);
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }

            }

        }
//         Arrays.sort(arr2);
        return arr;
    }

    public int[] MySort2(int[] arr) {

        quickSort(arr, 0, arr.length - 1);

        return arr;
    }

    public void quickSort(int[] a, int start, int end) {
        if (end <= start) return;
        int mid = start;
        int low = start;
        int high = end;
        int t = a[start];

        while (low < high) {

            while (low < high) {
                if (a[high] < t) {
                    a[low] = a[high];
                    low++;
                    break;
                }
                high--;
            }

            while (low < high) {
                if (a[low] > t) {
                    a[high] = a[low];
                    high--;
                    break;
                }
                low++;
            }


        }
        assert (high == low);
        mid = low;
        a[mid] = t;

        quickSort(a, mid + 1, end);
        quickSort(a, start, mid - 1);
    }


    public void merge(int A[], int m, int B[], int n) {
        int i = 0;
        int j = 0;
        int l = m;
        while (i < n) {

            int x = B[i];
            int y = A[j];

            if (x < y) {
                int t = y;
                A[j] = x;
                B[i] = t;
                j++;

            } else {
                j++;
            }

            if (j >= l) {
                A[j] = B[i];
                l++;
                i++;
            }

        }

    }


    public int findKth(int[] a, int n, int K) {
        // write code here
        return quickSorkKindK(a, 0, n - 1, n - K);
    }

    public int quickSorkKindK(int[] a, int start, int end, int index) {
        if (start > end) return -1;
        int low = start;
        int high = end;

        int flagNum = a[start];
        while (low < high) {
            while (low < high && a[high] >= flagNum) {
                high--;
            }
            a[low] = a[high];

            while (low < high && a[low] <= flagNum) {
                low++;
            }
            a[high] = a[low];
        }

        assert (low == high);
        a[low] = flagNum;
        if (low == index) {
            return flagNum;
        } else if (index > low) {
            return quickSorkKindK(a, low + 1, end, index);
        } else {
            return quickSorkKindK(a, start, low - 1, index);
        }
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int firt = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return firt;
    }

    public int JumpFloor(int target) {
        if (target < 1) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;

        return JumpFloor(target - 2) + JumpFloor(target - 1);
    }


    public int maxLength(int[] arr) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int i = 0;
        int j = 1;
        int max = 1;
        while (j < arr.length) {
            if (!map.containsKey(arr[j])) {
                System.out.println("not con " + arr[j]);
                map.put(arr[j], j);

            } else {
                System.out.println(" con " + arr[j]);
                int index = map.get(arr[j]);
                i = index + 1;
                j = i;
                map.clear();
                map.put(arr[j], j);
            }
            System.out.println(" i=" + i + "j=" + j);

            if ((j - i) > max) max = j - i;
            System.out.println(" max =" + max);

            j++;
        }
        return max + 1;
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.empty()) {
                stack.push(cur);
            } else {
                if (match(stack.peek(), cur)) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }

        }

        return stack.isEmpty();
    }

    public boolean match(Character before, Character after) {
        return ((before == '(') && after == ')') || ((before == '{') && after == '}') || ((before == '[') && after == ']');

    }

    public String solve(String str) {
        // write code here
        StringBuffer s = new StringBuffer(str);
        return s.reverse().toString();
    }

//    public ArrayList<Integer> spiralOrder(int[][] matrix) {
//        ArrayList<Integer> list=new ArrayList<>();
//        int m=matrix.length;
//        int n=matrix[0].length;
//
//        int initx=0;
//        int inity=0;
//
//        int x=0;
//        int y=0;
//
//
//    }


    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> listlist = new ArrayList<>();

        int len = num.length;
        int lasta = 0;
        int lastb = 0;
        int lastc = 0;
        for (int a = 0; a < len - 2; a++) {
            if (num[a] > 0) break;
            for (int b = a + 1; b < len - 1; b++) {
                if (num[a] + num[b] > 0) break;

                for (int c = b + 1; c < len; c++) {
                    int sum = num[a] + num[b] + num[c];
                    System.out.println("sum=" + sum + "a=" + num[a] + "b=" + num[b] + "c=" + num[c]);

                    if (sum == 0) {
                        System.out.println("sum=" + sum + "a=" + num[a] + "b=" + num[b] + "c=" + num[c]);

                        ArrayList<Integer> list = new ArrayList<>();
                        if (num[a] != lasta && num[b] != lastb && num[c] != lastc) {
                            list.add(num[a]);
                            list.add(num[b]);
                            list.add(num[c]);
                            listlist.add(list);
                            lasta = num[a];
                            lastb = num[b];
                            lastc = num[c];

                        }

                    } else if (sum > 0) {
                        break;
                    }
                }

            }

        }


        return listlist;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) return null;
        int midvalue = pre[0];
        TreeNode root = new TreeNode(midvalue);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        boolean isLeft = true;

        if (in.length != 0) {

            for (int v : in) {
                if (midvalue == v) {
                    isLeft = false;
                    continue;
                }
                if (isLeft) {
                    left.add(v);
                } else {
                    right.add(v);
                }
            }
        }

        if (!left.isEmpty()) {
            int[] leftIn = left.stream().mapToInt(Integer::valueOf).toArray();
            int[] leftPre = Arrays.copyOfRange(pre, 1, 1 + leftIn.length);
            root.left = reConstructBinaryTree(leftPre, leftIn);
        }


        if (!right.isEmpty()) {
            int[] rightIn = right.stream().mapToInt(Integer::valueOf).toArray();
            int[] rightPre = Arrays.copyOfRange(pre, 1 + left.size(), 1 + left.size() + rightIn.length);

            root.right = reConstructBinaryTree(rightPre, rightIn);
        }

        return root;

    }


    public int sqrt(int x) {
        int pre = 0;
        int last = x;

        while (pre < last) {
            int mid = (pre + last) / 2;
            int ji = (mid * mid);
            if (ji == x) {
                return mid;
            } else if (ji < x) {
                pre = mid+1;
            } else {
                last = mid-1;
            }

        }
        if (last * last <= x){

            return last;
        } else {
            return last-1;
        }
    }

}

