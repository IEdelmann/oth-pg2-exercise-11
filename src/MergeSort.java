public class MergeSort {

    private int[] arrayInput;
    private int[] sortedArray;

    // Merges two subarrays of arr[];
    // First subarray is arr[l...m];
    // Second subarray is arr[m+1...r];
    private void merge(int[] arr, int l, int m, int r) {

        // Find sizes of two subarrays to be merged;
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays;
        int[] leftTempArray = new int[n1];
        int[] rightTempArray = new int[n2];

        // Copy data to temp arrays;
        for (int i = 0; i < n1; i++) {
            leftTempArray[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            rightTempArray[j] = arr[m + 1 + j];
        }

        // Merge the temp arrays;
        // Initial indexes of first and second subarrays;
        int i = 0, j = 0;

        // Initial index of merged subarray array;
        int k = l;

        while (i < n1 && j < n2) {
            if (leftTempArray[i] <= rightTempArray[j]) {
                arr[k] = leftTempArray[i];
                i++;

            } else {
                arr[k] = rightTempArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of the 'leftTempArray[]' if any;
        while (i < n1) {
            arr[k] = leftTempArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of the 'rightTempArray[]' if any;
        while (j < n2) {
            arr[k] = rightTempArray[j];
            j++;
            k++;
        }

        this.sortedArray = arr;
    }

    // Main function that sorts arr[l...r] using merge();
    public void sort(int[] arr, int l, int r) {
        this.arrayInput = arr;

        if (l < r) {
            // Find the middle point;
            int m = l + (r - l) / 2;

            // Sort first and second halves;
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves;
            merge(arr, l, m, r);
        }
    }

    // A utility function to print array of size n;
    public static void printArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] getArrayInput() {
        return arrayInput;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }
}
