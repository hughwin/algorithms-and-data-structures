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
                    int indexTemp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[j];
                    unsortedArray[j] = indexTemp;
                }
            }
        }
        return unsortedArray;
    }

}
