package RealTest;

import edu.neu.coe.info6205.sort.Helper;

import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a;
        long start=0, end=0;
        int count = 0;

        while(count<=5){
            //random
            Scanner sc = new Scanner(System.in);
            Random element = new Random();
            System.out.print("Please input the size of array:");
            a = new int[sc.nextInt()];
            for (int i = 0; i < a.length; i++) {
                a[i] = element.nextInt(101);
                /*System.out.print(a[i]);*/
            }

            //count time
            InsertionSort num = new InsertionSort();
            start = System.nanoTime();
            num.sort(a);
            end = System.nanoTime();

            //display
            /*num.display(a);*/
            System.out.print("the time of function is:"+num.toMilliseconds(end-start)+" milliseconds");
            System.out.println();

            count++;
        }

    }

    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++)
            swap(i, a);
    }

    private void swap(int i, int[] a){
        for (int j = i-1; j >= 0; j--) {
            if(((Comparable)a[j]).compareTo(a[j+1])>0)
                swap(a,j,j+1);
            else break;
        }
    }

    private void swap(int[] a, int j, int i){
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public double toMilliseconds(long ticks){
        return ticks/1000000;
    }

    public void display(int[] array){
        System.out.println();
        System.out.print("insertionsorted array is: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
