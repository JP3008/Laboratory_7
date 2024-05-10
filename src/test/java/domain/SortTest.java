package domain;

import controller.SelectionSort;
import org.junit.jupiter.api.Test;

import javax.naming.BinaryRefAddr;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
class SortTest {

    int[] a = new int[50000];
    int[] b = new int[50000];
    int[] c = new int[50000];
    int[] d = new int[50000];
    int[] e = new int[50000];
    int[] f = new int[50000];

    int[] tempC = new int[50000];
    int[] tempF = new int[50000];

    int[] g = new int[20000];
    int[] h = new int[20000];
    int[] i = new int[20000];
    int[] j = new int[20000];
    int[] k = new int[20000];
    int[] l = new int[20000];

    @Test
    public void TestElementary() {

        Elementary el = new Elementary();

        List<int[]> arrays = new ArrayList<>();
        arrays.add(g);
        arrays.add(h);
        arrays.add(i);
        arrays.add(j);
        arrays.add(k);
        arrays.add(l);


        long initialTime;
        long finalTime;

        for (int i = 0; i <arrays.size() ; i++) {
            fillArray(arrays.get(i));
            System.out.println(printArrayElementary(arrays.get(i)));
        }

        if (isSorted(g)){
            initialTime = System.currentTimeMillis();
            el.improvedBubbleSort(g);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array G with ImprovedBubbleSort:");
            System.out.println(printArrayElementary(g));
            System.out.println("Execution time: "+(finalTime-initialTime)+"ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/20 000!)");
        }

        if (isSorted(h)){
            initialTime = System.currentTimeMillis();
            el.bubbleSort(h);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array H with BubbleSort:");
            System.out.println(printArrayElementary(h));
            System.out.println("Execution time: "+(finalTime-initialTime)+"ms");
        }else{
        System.out.println("Already sorted somehow!\n chance of this happening (1/20 000!)");
    }

        if (isSorted(i)){
            initialTime = System.currentTimeMillis();
            el.selectionSort(i);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array I with SelectionSort:");
            System.out.println(printArrayElementary(i));
            System.out.println("Execution time: "+(finalTime-initialTime)+"ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/20 000!)");
        }

        if (isSorted(j)){
            initialTime = System.currentTimeMillis();
            el.improvedBubbleSort(j);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array J with ImprovedBubbleSort:");
            System.out.println(printArrayElementary(j));
            System.out.println("Execution time: "+(finalTime-initialTime)+"ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/20 000!)");
        }


        if (isSorted(k)) {
            initialTime = System.currentTimeMillis();
            el.countingSort(k);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array K with CountingSort:");

            System.out.println(printArrayElementary(k));
            System.out.println("Execution time: "+(finalTime-initialTime)+"ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/20 000!)");
        }


        if (isSorted(l)) {
            initialTime = System.currentTimeMillis();
            el.bubbleSort(l);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array F with BubbleSort:");
            System.out.println(printArrayElementary(l));
            System.out.println("Execution time: "+(finalTime-initialTime)+"ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/20 000!)");
        }


    }

    @Test
    public void TestComplex() {

        Complex cx = new Complex();

        List<int[]> arrays = new ArrayList<>();
        arrays.add(a);
        arrays.add(b);
        arrays.add(c);
        arrays.add(d);
        arrays.add(e);
        arrays.add(f);


        long initialTime;
        long finalTime;

        for (int i = 0; i < arrays.size(); i++) {
            fillArray(arrays.get(i));
            System.out.println(printArrayComplex(arrays.get(i)));
        }

        if (isSorted(a)) {
            initialTime = System.currentTimeMillis();
            cx.quickSort(a, 0, a.length - 1);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array A with Quicksort:");
            System.out.println(printArrayComplex(a));
            System.out.println("Execution time: " + (finalTime - initialTime) + "ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/50 000!)");
        }

        if (isSorted(b)) {
            initialTime = System.currentTimeMillis();
            cx.shellSort(b);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array B with shellSort:");
            System.out.println(printArrayComplex(b));
            System.out.println("Execution time: " + (finalTime - initialTime) + "ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/50 000!)");
        }

        if (isSorted(c)) {
            initialTime = System.currentTimeMillis();
            cx.mergeSort(c, tempC, 0, c.length - 1);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array C with mergeSort:");
            System.out.println(printArrayComplex(c));
            System.out.println("Execution time: " + (finalTime - initialTime) + "ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/50 000!)");
        }

        if (isSorted(d)) {
            initialTime = System.currentTimeMillis();
            cx.shellSort(d);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array D with shellSort:");
            System.out.println(printArrayComplex(d));
            System.out.println("Execution time: " + (finalTime - initialTime) + "ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/50 000!)");
        }


        if (isSorted(e)) {
            initialTime = System.currentTimeMillis();
            cx.radixSort(e, e.length);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array E with radixSort:");
            System.out.println(printArrayComplex(e));
            System.out.println("Execution time: " + (finalTime - initialTime) + "ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/50 000!)");
        }


        if (isSorted(f)) {
            initialTime = System.currentTimeMillis();
            cx.mergeSort(f, tempF, 0, f.length - 1);
            finalTime = System.currentTimeMillis();
            System.out.println("\nSorted array F with mergeSort:");
            System.out.println(printArrayComplex(f));
            System.out.println("Execution time: " + (finalTime - initialTime) + "ms");
        }else{
            System.out.println("Already sorted somehow!\n chance of this happening (1/50 000!)");
        }

    }

  /*  @Test
    public void findValue(){

        Search sh = new Search();
        int ramVal;
        Elementary el = new Elementary();

        ramVal = new Random().nextInt(1,200);
        System.out.println("For array A using iterative search at val[ "+ramVal+"]");
        System.out.println((sh.binarySearch(a,ramVal)==-1)?"The value ["+ramVal+"] was not found":"The element"+
                "["+ramVal+"+] exists at position: "+sh.linearSearch(a,ramVal));



        ramVal = new Random().nextInt(1,200);
        System.out.println("For array A using recursive search at val[ "+ramVal+"]");
        System.out.println((sh.binarySearch(a,1,0,a.length-1)!=-1)?"The value ["+1+"] was not found":"The element"+
                "["+1+"+] exists at position: "+sh.binarySearch(a,1));


        int[] ints = {1,2,3,4,5,6,7,8,9};
        el.bubbleSort(a);
        System.out.println(printArrayComplex(a));
        System.out.println(sh.linearSearch(a,1));





    }

   */

    private String printArrayElementary(int[] a){
        String print="";

        for (int i = 0; i <=500; i++) {
            if (i%50==0){
                print+="\n["+a[i]+"]";
            }

            print+="["+a[i]+"]";

        }

        return print;
    }

    private boolean isSorted(int[] a){

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length ; j++) {
                if (a[i]>a[j]){
                    return true;
                }
            }
        }

        return false;
    }

    private String printArrayComplex(int[] a){
        String print="";

        for (int i = 0; i <=200; i++) {
            if (i%50==0){
                print+="\n["+a[i]+"]";
            }

            print+="["+a[i]+"]";

        }

        return print;
    }

    private int[] fillArray(int[] a){

        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(1,200);
        }

        return a;
    }



}
