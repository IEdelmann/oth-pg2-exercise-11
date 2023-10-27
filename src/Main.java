// Aufgabe 11.1** - Sortieren mit Bubble- und MergeSort;
import java.util.Arrays;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        int arrayLength = 10000;

        int[] randomArray_1 = randomArray(0, 400000, arrayLength);

        MergeSort mergeSort = new MergeSort();

        long MergeSortStart = System.currentTimeMillis();
        mergeSort.sort(randomArray_1, 0, randomArray_1.length - 1);
        System.out.println("Time MergeSort for array length of " + arrayLength + ": " + (System.currentTimeMillis() - MergeSortStart) + " ms");

        long BubbleSortStart = System.currentTimeMillis();
        int[] sortedArrayBubble = bubbleSort(randomArray_1);
        System.out.println("Time BubbleSort for array length of " + arrayLength + ": " + (System.currentTimeMillis() - BubbleSortStart) + " ms");
    }

    public static int[] randomArray(int min, int max, int arrayLength) {
        // Set up the random generator;
        int[] randomArray = new int[arrayLength + 1];

        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = (int) (Math.random() * (max - min + 1) + min);
        }

        return randomArray;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}