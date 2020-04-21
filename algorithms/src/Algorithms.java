import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Algorithms {

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

        quickSort(unsortedArray, 0, 4);

        BinarySearchTrees bst = new BinarySearchTrees();
        bst.insert(5);
        bst.insert(2);
        bst.insert(7);

        bst.printTreeRoot();


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
        // Big O complexity : log n
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

        if (array.length < 2){ // if length is less than 2
            return;  // return array
        }

        int mid = array.length / 2; // divide array in 2 by midpoint
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        for (int i = 0 ; i < array.length; i++){
            if (i < mid){ // if number is less than midpoint, put into left array
                leftArray[i] = array[i];
            }
            else{rightArray[i - mid] = array[i];} // else put the number in the right array
        }


        mergeSort(leftArray); // recursively call mergesort
        mergeSort(rightArray);

        merge(array, leftArray, rightArray, mid, array.length - mid);
    }

    public static void merge(

            // Big O complexity : n log n

            int[] array, int[] leftArray, int[] rightArray, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++]; // sort the array
            }
            else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < left) { // put the numbers in the right place
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

    public static void quickSort(int arr[], int begin, int end){

        // Big O complexity : n log n

        if (begin < end){ // if starting index is greater than end index
            int partitionIndex = partition(arr, begin, end); // partition index is the index on the end

            quickSort(arr, begin, partitionIndex-1); // calls every other index until the two indexes meet
            quickSort(arr, partitionIndex+1, end);
        }
    }

    static int partition(int arr[], int begin, int end){
        int pivot = arr[end]; // pivot is chosen as the value at the end
        int i = (begin-1); // make i one less than beginning


        for (int j = begin ; j < end ; j++){
            if (arr[j] <= pivot){
                i++; // increment i

                int swapTemp = arr[i]; // store the temp int as swapTemp
                arr[i] = arr[j]; // swap the values of i and j
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i+1]; // swap the pivot with the current pointer of i
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    @Test
    public  void quickSortTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        quickSort(actual, 0, actual.length-1);
        assertArrayEquals(expected, actual);
    }

}
