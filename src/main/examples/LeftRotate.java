package main.examples;

import java.util.Scanner;

public class LeftRotate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(leftRotate(n,k,a));
    }
    
    static String leftRotate(int n, int k, int[] a) {

        String result = "";
        for (int i=0; i<n; i++) {
            result += a[(i+k)%n] + " ";
        }

        return result;
    }
}
