/*
 *  Program:    Exercise 23.12
 *  Date:       4/10/18
 *  Developer:  Garrett Wolfe
 *  Purpose:    Write a program that randomly generates 1,000,000 intergers
 *              and sorts them using radix sort.
 */
package exercise23_12;
import java.util.Random;

public class Exercise23_12 {
    public static void main(String[] args){
        final int Size = 1000000;
        Random x = new Random();
        int[] test = new int[Size];
        for (int y = 0; y < Size; y++){
            test[y] = x.nextInt(Integer.MAX_VALUE);
        }
        test = sort(test);
        for (Integer y : test){
            System.out.println(y);
        }
    }
    public static int[] sort(int[] input){
        for(int place=1; place <= 1000000000; place *= 10){
            input = countingSort(input, place);
        }
        return input;
    }
    private static int[] countingSort(int[] input, int place){
        int[] out = new int[input.length];
        int[] count = new int[10];
        for(int y=0; y < input.length; y++){
            int digit = getDigit(input[y], place);
            count[digit] += 1;
        }
        for(int y=1; y < count.length; y++){
            count[y] += count[y-1];
        }
        for(int y = input.length-1; y >= 0; y--){
            int digit = getDigit(input[y], place);
            out[count[digit]-1] = input[y];
            count[digit]--;
        }
        return out;
    }
    private static int getDigit(int value, int digitPlace){
        return ((value/digitPlace ) % 10);
    }
}