/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewcode;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Naimish
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public char[] s;

    public JavaApplication1() {
    }

    public JavaApplication1(String s) {
        this.s = s.toCharArray();
        getComb(s.length() - 1);
    }

    public void getComb(int n) {

        if (n == 0) {
            print(s);
            System.out.print(" " + n);
            System.out.println();
        }

        for (int i = n; i >= 0; i--) {
            swap(i, n);
            getComb(n - 1);
            swap(i, n);
        }
    }

    public void print(char[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print("" + s[i]);
        }
    }

    public void swap(int n, int b) {
        char temp;
        temp = s[n];
        s[n] = s[b];
        s[b] = temp;
    }

    public void perm(String s) {
        doperm("", s);
    }

    public void doperm(String pre, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println("" + pre);
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println("" + pre + str.charAt(i) + " - " + str.substring(0, i) + str.substring(i + 1, n));
                doperm(pre + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
//        String s = "abc";
//
//        for (int i = 0; i < s.length(); i++) {
//            JavaApplication1 j = new JavaApplication1(s.substring(i));
//        }
//
//        //j.perm("abc");
//        int array[] = {0, 1, 2, 3, 4, 5, 6};
//        int j = array.length - 1;
//
//        JavaApplication1 j1 = new JavaApplication1();
//        j1.findSum(array, 0, 0);
        
        String x1="sum",find="ums",two="sumsum";
        System.out.println(""+two.contains(find)+" "+two.indexOf(find));
        
        ArrayList<String> ary=new ArrayList<>();
        ary.add("1");
        ary.add("2");
        ary.add("3");
        ary.add("4");
        System.out.println(""+ary);
        ListIterator<String> lst=ary.listIterator(ary.size());
        
        while (lst.hasPrevious()) {
            String pp=lst.previous();
            System.out.println(""+pp);
        }
        
        
    }

    public void findSum(int[] a, int len, int sum) {

        for (int i = len; i < a.length; i++) {
            sum = a[i];
            if (sum > 5) {
                return;
            }

            doSum(a, i + 1, i + 2, sum);
        }
    }

    public void doSum(int[] a, int start, int end, int suma) {
        int sum = suma;

        if (a[start] > 5 || (sum + a[start] > 5) || a[end-1] > 5) {
            return;
        }

        System.out.print(" " + sum);
        for (int i = start; i < end; i++) {
            sum += a[i];

//            if(sum > 5){
//                return;
//            }
            System.out.print(" " + a[i]);
        }

        System.out.println(" =" + sum);
        if (end + 1 < a.length) {
            doSum(a, start, end + 1, suma);
        }
        if (start + 1 < end + 1 && start + 1 < a.length && end + 1 < a.length) {
            doSum(a, start + 1, end + 2, suma);
        }
    }
}
