import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        long startTime, endTime;
        startTime = System.currentTimeMillis();
        selectionSort(createList(100000));
        endTime = System.currentTimeMillis();
        long selection1 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        selectionSort(createList(200000));
        endTime = System.currentTimeMillis();
        long selection2 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        selectionSort(createList(400000));
        endTime = System.currentTimeMillis();
        long selection3 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        selectionSort(createList(800000));
        endTime = System.currentTimeMillis();
        long selection4 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        bubbleSort(createList(100000));
        endTime = System.currentTimeMillis();
        long bubble1 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        bubbleSort(createList(200000));
        endTime = System.currentTimeMillis();
        long bubble2 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        bubbleSort(createList(400000));
        endTime = System.currentTimeMillis();
        long bubble3 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        bubbleSort(createList(800000));
        endTime = System.currentTimeMillis();
        long bubble4 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        insertionSort(createList(100000));
        endTime = System.currentTimeMillis();
        long insertion1 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        insertionSort(createList(200000));
        endTime = System.currentTimeMillis();
        long insertion2 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        insertionSort(createList(400000));
        endTime = System.currentTimeMillis();
        long insertion3 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        insertionSort(createList(800000));
        endTime = System.currentTimeMillis();
        long insertion4 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        mergeSort(createList(100000));
        endTime = System.currentTimeMillis();
        long merge1 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        mergeSort(createList(200000));
        endTime = System.currentTimeMillis();
        long merge2 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        mergeSort(createList(400000));
        endTime = System.currentTimeMillis();
        long merge3 = (endTime - startTime);

        startTime = System.currentTimeMillis();
        mergeSort(createList(800000));
        endTime = System.currentTimeMillis();
        long merge4 = (endTime - startTime);

        System.out.println("------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |", "Elements","Selection","Bubble","Insertion","Merge");
        System.out.print("\n------------------------------------------------------------------");
        System.out.printf("%n| %-10d | %-10d | %-10d | %-10d | %-10d |", 100000, selection1, bubble1, insertion1, merge1);
        System.out.printf("%n| %-10d | %-10d | %-10d | %-10d | %-10d |", 200000, selection2, bubble2, insertion2, merge2);
        System.out.printf("%n| %-10d | %-10d | %-10d | %-10d | %-10d |", 400000, selection3, bubble3, insertion3, merge3);
        System.out.printf("%n| %-10d | %-10d | %-10d | %-10d | %-10d |", 800000, selection4, bubble4, insertion4, merge4);
        System.out.println("\n------------------------------------------------------------------");

        ArrayList<String> wordsMerge = new ArrayList<>();
        ArrayList<String> wordsWithoutDupesMerge = new ArrayList<>();
        reader(wordsMerge);
        startTime = System.currentTimeMillis();
        mergeSortString(wordsMerge);
        removeDuplicates(wordsMerge,wordsWithoutDupesMerge);
        endTime = System.currentTimeMillis();
        long mergeStringTime = endTime - startTime;
        System.out.println("It took merge sort to sort a list of "+wordsMerge.size()+" Strings and remove its duplicate"
                +" Strings in "+mergeStringTime+" ms leaving a list of "+wordsWithoutDupesMerge.size()+" Strings.");


        ArrayList<String> wordsInsertion  = new ArrayList<>();
        ArrayList<String> wordsWithoutDupesInsertion = new ArrayList<>();
        reader(wordsInsertion);
        startTime = System.currentTimeMillis();
        insertionSortString(wordsInsertion);
        removeDuplicates(wordsInsertion,wordsWithoutDupesInsertion);
        endTime = System.currentTimeMillis();
        long insertionStringTime = endTime - startTime;
        System.out.println("It took insertion sort to sort a list of "+wordsInsertion.size()+" Strings and remove its " +
                "duplicate Strings in "+insertionStringTime+" ms leaving a list of "+wordsWithoutDupesInsertion.size()+
                " Strings.");

    }
    /*
    createArray
    This function creates and returns a list with the length of the integer parameter passed to it.
     */
    public static List<Double> createList(int length) {
        List<Double> arr = new ArrayList<>();
        randomNumberGenerator(arr, length);
        return arr;
    }
    /*
    randomNumberGenerator
    This function is used to fill and return a list up with length(passed integer) amounts of random Double values.
     */
    public static void randomNumberGenerator(List<Double> ranNum, int length) {
        for(int i = 0; i < length; i++) {
            double num = Math.random()*1001;
            ranNum.add(num);
        }
    }
    /*
    selectionSort
    This function implements the selection sort algorithm. It goes through the entire ranNum List and locates the smallest value.
    It then swaps the first element with this value. It then locates the next smallest number and swaps it with the
    second element. It goes through this process until it reaches the end of the List.
     */
    public static void selectionSort(List<Double> ranNum) {
        for(int i = 0; i < ranNum.size()-1; i++) {
            int minNum = i;
            for(int j = i +1; j < ranNum.size(); j++) {
                if (ranNum.get(j) < ranNum.get(minNum)) {
                    minNum = j;
                }
            }
            Double temp = ranNum.get(minNum);
            ranNum.set(minNum, ranNum.get(i));
            ranNum.set(i, temp);
        }
    }
    /*
    bubbleSort
    This function implements the bubble sorting algorithm. It looks at the first element and the second element. If the
    first element is smaller than the second, it moves on to check the next set of elements. If the second element is
    smaller than the first, then it swaps them. It runs through this process until the largest number of the List is
    at the last element. It goes through this process until the List is sorted.
     */
    public static void bubbleSort(List<Double> ranNum) {
        for(int i = 0; i < ranNum.size()-1; i++) {
            int firstNum = i;
            for(int j = i +1; j < ranNum.size(); j++) {
                if(ranNum.get(firstNum) > ranNum.get(j)) {
                    Double temp = ranNum.get(firstNum);
                    ranNum.set(firstNum, ranNum.get(j));
                    ranNum.set(j, temp);
                }
            }
        }
    }
    /*
    insertionSort
    This function implements the insertion sorting algorithm. It looks at the first and second element of the List. If
    the first value is smaller than the second, then the first number is in the right place. If the second is larger,
    then it swaps the first and second values. Then it checks the second and third elements. If the third is smaller
    than the second and first, then it swaps the values until the third number is at the first element. It continues
    this process of moving the number backwards until it's in the right place until the List is fully sorted.
     */
    public static void insertionSort(List<Double> ranNum) {
        for(int i = 1; i < ranNum.size()-1; i++) {
            Double firstNum = ranNum.get(i);
            int j = i - 1;
            while (j >= 0 && ranNum.get(j) > firstNum) {
                ranNum.set(j+1,ranNum.get(j));
                j--;
            }
            ranNum.set(j+1, firstNum);
        }
    }
    /*
    mergeSort
    This function implements the merge sorting algorithm. It involves the idea of dividing a List into many smaller
    sub-lists and sorting those sub-lists, and then combining the sublist back into a fully sorted List. It recursively
    divides the passed List into two halves. It then passes these halves to the merge method.
     */
    public static void mergeSort(List<Double> ranNum) {
        if(ranNum.size() > 1) {
            int middle = ranNum.size()/2;
            List<Double> leftHalf = new ArrayList<>();
            for(int i = 0; i < middle; i++) {
                leftHalf.add(ranNum.get(i));
            }
            List<Double> rightHalf = new ArrayList<>();
            for(int i = middle; i < ranNum.size(); i++) {
                rightHalf.add(ranNum.get(i));
            }

            mergeSort(leftHalf);
            mergeSort(rightHalf);
            merge(ranNum,leftHalf,rightHalf);
        }
    }
    /*
    merge
    This function works in combination with the mergeSort method to fully implement the merge sort algorithm. This one
    sorts and merges the sub-lists passed from the mergeSort method.
     */
    public static void merge(List<Double> ranNum, List<Double> left, List<Double> right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(left.size() > i && right.size() > j) {
            if(left.get(i) <= right.get(j)) {
                ranNum.set(k++, left.get(i++));
            }
            else {
                ranNum.set(k++, right.get(j++));
            }
        }
        while(i < left.size()) {
            ranNum.set(k++, left.get(i++));
        }
        while(j < right.size()) {
            ranNum.set(k++, right.get(j++));
        }
    }
    /*
    mergeSortString
    This function implements the same algorithm as the previous mergeSort method, but instead of sorting Doubles, it sorts
    Strings. It divides the List of Strings into two smaller sub-lists and then recursively divides these smaller Lists
    into two more smaller sub-lists each. It also sends each sub-lists to the mergeString method.
     */
    public static void mergeSortString(List<String> words) {
        if (words.size() > 1) {
            int middle = words.size() / 2;
            List<String> leftWords = new ArrayList<>();
            for (int i = 0; i < middle; i++) {
                leftWords.add(words.get(i));
            }
            List<String> rightWords = new ArrayList<>();
            for (int i = middle; i < words.size(); i++) {
                rightWords.add(words.get(i));
            }
            mergeSortString(leftWords);
            mergeSortString(rightWords);
            mergeString(words, leftWords, rightWords);
        }
    }
    /*
    mergeString
    This function works in combination with the mergeSortString method to fully implement the merge sort algorithm. This
    one sorts the Strings using the compareTo method and merges the sorted sub-lists passed from the mergeSort method.
     */
    public static void mergeString(List<String> words, List<String> leftWords, List<String> rightWords) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(leftWords.size() > i && rightWords.size() > j) {
            if(leftWords.get(i).compareTo(rightWords.get(j)) < 0) {
                words.set(k++,leftWords.get(i++));
            }
            else {
                words.set(k++,rightWords.get(j++));
            }
        }
        while(i < leftWords.size()) {
            words.set(k++,leftWords.get(i++));
        }
        while(j < rightWords.size()) {
            words.set(k++,rightWords.get(j++));
        }
    }
    /*
    reader
    This function is used to read a text file and add each line of the file to an ArrayList. It uses a try and catch
    statement in case of a File Exception error.
     */
    public static void reader(ArrayList<String> words) {
        try {
            File file = new File("src/fstein.txt");
            Scanner fileScan = new Scanner(file);
            while(fileScan.hasNext()) {
                words.add(fileScan.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Reader Error");
        }
    }
    /*
    removeDuplicates
    This function goes through an ArrayList and adds all non-duplicate Strings to another ArrayList.
     */
    public static void removeDuplicates(ArrayList<String> words, ArrayList<String> newList) {
        for(String i : words) {
            if(!newList.contains(i)) {
                newList.add(i);
            }
        }
    }
    /*
    insertionSortString
    This method uses the insertion sort algorithm to sort Strings.
     */
    public static void insertionSortString(List<String> words) {
        for(int i = 1; i < words.size();i++) {
            String keyWord = words.get(i);
            int j = i-1;
            while(j >= 0 && (words.get(j).compareTo(keyWord)) > 0) {
                words.set(j+1,words.get(j));
                j--;
            }
            words.set(j+1,keyWord);

        }
    }
}