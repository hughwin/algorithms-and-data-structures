// Hugh Winchester
// 2494047

//add any import statements you need here

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


public class AssEx1 {


    /**
     * read strings from file
     * and add them to an array. Assume that in the file there is one string
     * per line.
     *
     * @param filename return array
     */
    public static String[] readFromFile(String fileName) {

        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader fr = new FileReader(new File(fileName));
            BufferedReader br = new BufferedReader(fr);
            String line;


            // Loops until an empty line is encountered.
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] stringArray = lines.toArray(new String[]{});
        return stringArray;
    }


    /**
     * Add all of the elements of an array of Strings
     * to a set of strings - note repeats will disappear
     * your set should be instantiated as a TreeSet (see lecture 1)
     */
    public static Set<String> arrayToSet(String[] myArray) {

        TreeSet<String> treeSet = new TreeSet<>();

        for (String s : myArray) {
            treeSet.add(s);
        }

        return treeSet;
    }


    /**
     * randomly re-order an array
     *
     * @param origArray
     * @return
     */
    public static void jumbleArray(String[] origArray) {

        Random rand = new Random();

        for (int i = origArray.length-1 ; i > 0; i--){

            int j = rand.nextInt(i + 1);

            String tempString = origArray[i];
            origArray[i] = origArray[j];
            origArray[j] = tempString;
        }

    }

    /**
     * create a string consisting all of the elements in an array,
     * one element per row.
     * Use a for--each loop to return them in the order in which they
     * are stored
     */
    public static String arrayToString(String[] stringArray) {
        String toBeOutPutted = "";
        for (String s : stringArray) {
            toBeOutPutted += s + "\n";
        }
        return toBeOutPutted;
    }

    /**
     * create a string consisting of all of the elements in a set,
     * one element per row.
     * Use a for--each loop to return them in the order in which they
     * are stored
     */
    public static String setToString(Set<String> stringSet) {
        String toBeOutPutted = "";
        for (String s : stringSet) {
            toBeOutPutted += s + "\n";
        }
        return toBeOutPutted;
    }


    /**
     * main method - do not edit this
     *
     * @param args
     */
    public static void main(String[] args) {
        String fileName = args[0];
        String[] originalArray = readFromFile(fileName);
        System.out.println("the array has length " + originalArray.length + "\n");
        String[] newArray1 = originalArray.clone();
        String[] newArray2 = originalArray.clone();

        jumbleArray(newArray1);
        jumbleArray(newArray2);

        System.out.print("The original array is:\n");
        System.out.print(arrayToString(originalArray) + "\n");

        System.out.print("The frst jumbled array is:\n");
        System.out.print(arrayToString(newArray1) + "\n");
        System.out.print("The corresponding set is:\n");
        System.out.print(setToString(arrayToSet(newArray1)) + "\n");

        System.out.print("The second jumbled array is:\n");
        System.out.print(arrayToString(newArray2) + "\n");
        System.out.print("The corresponding set is:\n");
        System.out.print(setToString(arrayToSet(newArray2)) + "\n");

    }

}
