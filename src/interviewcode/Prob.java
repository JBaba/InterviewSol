/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Naimish Question : Find largest subsequent index of string
 *
 */
public class Prob {

    public void solve() {
        int[] a = {10, 11, 7, 2, 3, 4, 5, 6, 20, 25};
        Map<Integer, Integer> myAns = new LinkedHashMap<Integer, Integer>();
        Map<Integer, Integer> myIndex = new LinkedHashMap<Integer, Integer>();

        int start = a[0];
        int temp = a[0];
        int startIndex = 0, count = 0;

        // Prints Array
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println("");

        // Code logic
        for (int i = 0; i < a.length; i++) {

            if (a[i] == (temp + 1)) { // check index and temo is subsequent
                myAns.put(start, ++temp); // increment value
                myIndex.put(startIndex, ++count); // increment indes

            } else {
                myIndex.put(i, 1);  // maintains indes
                startIndex = i; // set start index
                count = 1; // reset count

                myAns.put(a[i], a[i]);
                start = a[i];
                temp = a[i];
            }
        }

        System.out.println("----- Prints Start and last digit of Seq ------");
        int maxKey = 0, maxValue = 0;

        for (Map.Entry<Integer, Integer> entrySet : myAns.entrySet()) {
            Integer key = entrySet.getKey();
            Integer value = entrySet.getValue();

            System.out.println("" + key + ":" + value);

            if ((value - key) > (maxValue - maxKey)) {
                maxKey = key;
                maxValue = value;
            }
        }

        System.out.println("Ans:");
        for (int i = maxKey; i <= maxValue; i++) {
            System.out.print(i + ",");
        }
        System.out.println("");

        System.out.println("----- Prints index and count of Seq ------");

        for (Map.Entry<Integer, Integer> entrySet : myIndex.entrySet()) {
            Integer key = entrySet.getKey();
            Integer value = entrySet.getValue();

            System.out.println("" + key + ":" + value);

        }
    }

    public static void main(String[] args) {
        Prob p = new Prob();
        p.solve();
    }
}
