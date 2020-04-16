public class algorithms {

    public static void main(String[] args) {

        int[] testArray = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println(linearSearch(testArray, 5));
        System.out.println(linearSearch(testArray, 6));

        System.out.println(binarySearch(testArray, 6, 0, testArray.length));

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
            }
            else {
                return binarySearch(array, searchTerm, mid + 1, rightIndex);
            }
        }
        return -1;
    }
}
