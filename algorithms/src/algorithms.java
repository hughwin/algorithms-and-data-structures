public class algorithms {

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(linearSearch(new int[]{1, 2, 3, 4, 5}, 6));
    }

    public static boolean linearSearch(int[] array, int searchTerm) {

        for (int i : array) {
            if (i == searchTerm) {
                return true;
            }
        }
        return false;
    }

}
