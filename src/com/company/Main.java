package com.company;

import ibcsutils.ReadViaURL;

public class Main
{

    public static void main(String[] args)
    {
        //using a small array
        String[] words2 = {"apple", "bat", "cat", "dog", "elephant"};
        String key2 = "apple";
        long t1 = System.nanoTime();
        System.out.println(SequentialElementFinder(words2, key2));
        long t2 = System.nanoTime();
        System.out.println("It took " + (t2-t1) + " nanoseconds to run the program");
        long t3 = System.nanoTime();
        System.out.println(BinaryElementFinder(words2,key2));
        long t4 = System.nanoTime();
        System.out.println("It took " + (t4-t3) + " nanoseconds to run the program");

        //using a large array
        String address = "https://www-personal.umich.edu/~jlawler/wordlist";
        String[] words = ReadViaURL.readWords(address, true, true, true);
        String key = "zoo";
        long t5 = System.nanoTime();
        System.out.println(SequentialElementFinder(words, key));
        long t6 = System.nanoTime();
        System.out.println("It took " + (t6-t5) + " nanoseconds to run the program");
        long t7 = System.nanoTime();
        System.out.println(BinaryElementFinder(words,key));
        long t8 = System.nanoTime();
        System.out.println("It took " + (t8-t7) + " nanoseconds to run the program");
    }

    static String SequentialElementFinder(String[] words, String key)
    {
        String result = "";
        for (int i = 0; i < words.length; i++)
        {
            if (words[i].equals(key))
            {
                result = result + "Found at index " + i;
                return result;
            }
        }
        result = "Word not found";
        return result;
    }

    static String BinaryElementFinder(String[] words, String key)
    {
        String result = "";
        int lo = 0, hi = words.length - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            String val = words[mid];
            int where = val.compareTo(key);
            if (where == 0)
            {
                result = result + "Found at index " + mid;
                return result;
            }
            else if (where < 0)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return ("Word not found");
    }
}
