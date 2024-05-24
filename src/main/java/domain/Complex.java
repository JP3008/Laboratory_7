/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Random;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class Complex {
    private int counterRadix[];
    private String listPivot = "";
    private String listLow = "";
    private String listHigh = "";
    private int recursiveCalling = 0;
    public String getListPivot(){
        return this.listPivot;
    }
    public String getListlow(){
        return this.listLow;
    }
    public String getListHigh(){
        return this.listHigh;
    }
    public int getRecursiveCalling(){
        return this.recursiveCalling;
    }
    public void setRecursiveCalling(){
        this.recursiveCalling = 0;
    }
    private String acumulaGap="";
    private String acumulaGapSub1="";
    private String acumulaGapSub2="";
    private String acumulaGapSub3="";

    public String getAcumulaGap() {
        return acumulaGap;
    }

    public String getAcumulaGapSub1() {
        return acumulaGapSub1;
    }

    public String getAcumulaGapSub2() {
        return acumulaGapSub2;
    }

    public String getAcumulaGapSub3() {
        return acumulaGapSub3;
    }
    private String listLowMerge = "";
    private String listHighMerge = "";
    private int recursiveCallingMerge = 0;

    public String getListHighMerge(){
        return this.listLowMerge;
    }
    public String getListLowMerge(){
        return this.listHighMerge;
    }
    public int getRecursiveCallingMerge(){
        return this.recursiveCallingMerge;
    }
    public void quickSort(int arr[], int low, int high){
        int i=low;
        this.listLow = i + " ";
        int j=high;
        this.listHigh = j + " ";
        int pivot=arr[(low+high)/2];
        this.listPivot = pivot + " ";
        do{
            while(arr[i]<pivot) i++;
            while(arr[j]>pivot) j--;
                if(i<=j){
                    int aux=arr[i];
                    arr[i]=arr[j];
                    arr[j]=aux;
                    i++;j--;
                }//if
        }while(i<=j);//do

        if(low<j) {
            this.recursiveCalling++;
            quickSort(arr, low, j);
        }
        if(i<high) {
            this.recursiveCalling++;
            quickSort(arr, i, high);
        }
    }

    public void radixSort(int a[], int n){ 
        // Find the maximum number to know number of digits 
        int m = util.Utility.maxArray(a); //va de 0 hasta el elemento maximo
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(a, n, exp); 
    }


    public int[] getCounterRadix() {
        return counterRadix;
    }

    // A function to do counting sort of a[] according to
    // the digit represented by exp. 
    private void countSort(int a[], int n, int exp){ 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10];

        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            count[(a[i] / exp) % 10]++;
        }
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) {
            output[count[ (a[i]/exp)%10 ] - 1] = a[i]; 
            count[ (a[i]/exp)%10 ]--;
        }
  
        // Copy the output array to a[], so that a[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            a[i] = output[i];

        counterRadix=count;
    }

    public void mergeSort(int a[], int tmp[], int low, int high){

        if(low<high){
            recursiveCallingMerge++;
            int center = (low+high)/2;
            mergeSort(a,tmp,low,center );
            mergeSort(a,tmp,center+1,high);
            merge(a,tmp,low,center+1,high);
        }//if



    }

    private void merge(int a[], int tmp[], int lowIndex, int highIndex, int endIndex){
        int leftEnd = highIndex - 1;
        int tmpPos = lowIndex;
        int numElements = endIndex - lowIndex + 1;
        while( lowIndex <= leftEnd && highIndex <= endIndex )
            if(a[lowIndex]<=a[highIndex]) {
                listLowMerge=listLowMerge + tmpPos + " ";
                tmp[tmpPos++] = a[lowIndex++];


            }
            else{

                tmp[tmpPos++] = a[highIndex++];

            }
        while(lowIndex<= leftEnd) {
            tmp[tmpPos++] = a[lowIndex++];

        }
        while( highIndex <= endIndex ) {
            tmp[tmpPos++] = a[highIndex++];
            listHighMerge=listHighMerge + leftEnd + " ";
        }
        for( int i=0;i<numElements;i++,endIndex--)
            a[endIndex] = tmp[endIndex];

    }

    public  void shellSort(int a[]) {
        // Inicializamos las variables de acumulación de intervalos
        acumulaGap = "";
        acumulaGapSub1 = "";
        acumulaGapSub2 = "";
        acumulaGapSub3 = "";

        int n = a.length;
        // Comenzamos con un intervalo grande y luego lo reducimos
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Acumulamos el valor de gap en la cadena
            acumulaGap += gap + " ";

            // Ordenación usando insertion sort con el intervalo actual
            for (int i = gap; i < n; i += 1) {
                int temp = a[i];
                int j;

                // Movemos los elementos a[j - gap] a su posición correcta para a[i]
                for (j = i; j >= gap && a[j - gap] > temp; j -= gap) {
                    a[j] = a[j - gap];
                }

                // Insertamos temp (el valor original de a[i]) en su posición correcta
                a[j] = temp;
            }

            // Acumulamos los tres primeros subarreglos generados en las variables correspondientes
            for (int k = 0; k < n; k++) {
                if (k == 0) {
                    acumulaGapSub1 += a[gap] + " ";
                } else if (k == 1) {
                    acumulaGapSub2 += a[gap] + " ";
                } else if (k == 2) {
                    acumulaGapSub3 += a[gap] + " ";
                }
            }
        }
    }
}
