import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class algorithms {

    public static void main(String[] args) {

        int[] testArray = new int[]{1, 2, 3, 4, 5, 6};
        int[] unsortedArray = new int[]{3,2,7,8,1};

        System.out.println(linearSearch(testArray, 5));
        System.out.println(linearSearch(testArray, 6));

        System.out.println(binarySearch(testArray, 6, 0, testArray.length));

        int[] sortedArray = selectionSort(unsortedArray);
        System.out.println("");
        for(int i : sortedArray){
            System.out.println(i);
        }


    }

    public static boolean linearSearch(int[] array, int searchTerm) {
        // Big O complexity : n
        for (int i : array) {
            if (i == searchTerm) {
                return true;
            }
        }
        return false;
    }

    public static int binarySearch(int[] array, int searchTerm,
                                   int leftIndex, int rightIndex) {

        if (rightIndex >= 1) {
            int mid = leftIndex + (rightIndex - 1)  / 2;

            System.out.println(mid);
            System.out.println("Number at index: " + array[mid]);

            if (array[mid] == searchTerm) {
                return mid;
            }

            if (array[mid] > searchTerm) {
                return binarySearch(array, searchTerm, leftIndex, mid - 1);
            } else {
                return binarySearch(array, searchTerm, mid + 1, rightIndex);
            }
        }
        return -1;
    }

    public static int[] selectionSort(int[] unsortedArray) {

        for (int i = 0; i < unsortedArray.length; i++) {

            int index = unsortedArray[i];

            for (int j = i; j < unsortedArray.length; j++) {
                if (unsortedArray[j] < index) {
                    int temp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[j];
                    unsortedArray[j] = temp;
                }
            }
        }
        return unsortedArray;
    }

    public static void mergeSort(int[] array){

        if (array.length < 2){
            return;
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        for (int i = 0 ; i < array.length; i++){
            if (i < mid){
                leftArray[i] = array[i];
            }
            else{rightArray[i - mid] = array[i];}
        }


        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray, mid, array.length - mid);
    }

    public static void merge(
            int[] array, int[] leftArray, int[] rightArray, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            }
            else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            array[k++] = leftArray[i++];
        }
        while (j < right) {
            array[k++] = rightArray[j++];
        }
    }

    @Test
    public void positiveTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        System.out.println(actual);
        mergeSort(actual);
        assertArrayEquals(expected, actual);
    }

}
