import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

/**
 * This class takes in a file of mixed-case alphabetical-only strings and runs radix sort to produce another file with said strings sorted in alphabetical order
 *
 * @author Avvaerugo
 * @version 1.0
 * @throws IOException
 */
public class RadixSort {
    public static void theActualMain(String filename) throws IOException {
        //old code from like lab 11 or something to read out a file
        File file = new File(filename + ".txt");
        Scanner sc = new Scanner(file);
        int linecount = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            linecount++;
        }
        String[] rawfile = new String[linecount + 1];
        sc = new Scanner(file);
        int j = 0;
        while (sc.hasNextLine()) {
            rawfile[j] = sc.nextLine();
            j++;
        }

        // generates normal array list + evil lowercase version
        ArrayList<String> baseList = new ArrayList<String>();
        ArrayList<String> lowerList = new ArrayList<String>();
        for (String i : rawfile) {
            if (i != null && i.replaceAll("\\s", "") != "") {
                baseList.add(i.replaceAll("\\s", ""));
                lowerList.add(i.replaceAll("\\s", "").toLowerCase());
            }
        }

        // ok we actually try sorting now
        int maxlen = 0;
        for (String i : baseList) {
            if (i.length() > maxlen) {
                maxlen = i.length();
            }
        }

        for (int i = 0; i < lowerList.size(); i++) {
            while (lowerList.get(i).length() < maxlen) {
                lowerList.set(i, lowerList.get(i) + "`");
            }
        }


        // for every letter position, starting at the latest possible one
        for (int i = maxlen - 1; i >= 0; i--) {
            //initialize hash arrays
            ArrayList<ArrayList<String>> AlphabetHash = new ArrayList<ArrayList<String>>();
            ArrayList<ArrayList<String>> LowerAlphabetHash = new ArrayList<ArrayList<String>>();
            for (int k = 0; k < 27; k++) {
                AlphabetHash.add(new ArrayList<String>());
                LowerAlphabetHash.add(new ArrayList<String>());
            }
            // put them all in correct buckets
            for (int k = 0; k < lowerList.size(); k++) {
                String temp = lowerList.get(k);
                int temp2 = (int) temp.charAt(i) - 96;
                ArrayList<String> temp3 = LowerAlphabetHash.get(temp2);
                temp3.add(temp);
                LowerAlphabetHash.set(temp2, temp3);
                temp3 = AlphabetHash.get(temp2);
                temp3.add(baseList.get(k));
                AlphabetHash.set(temp2, temp3);
            }
            // empty the buckets in order back into the lists
            baseList = new ArrayList<String>();
            lowerList = new ArrayList<String>();
            for (int k = 0; k < LowerAlphabetHash.size(); k++) {
                for (int l = 0; l < LowerAlphabetHash.get(k).size(); l++) {
                    lowerList.add(LowerAlphabetHash.get(k).get(l));
                    baseList.add(AlphabetHash.get(k).get(l));
                }
            }
        }
        // print sorted list hopefully please?????
        System.out.println(baseList);
        // YESSSSSSSSSSSS ok now we need to write it to a file
        FileWriter writer = new FileWriter(filename + "_key.txt");
        for (int i = 0; i < baseList.size(); i++) {
            writer.write(baseList.get(i));
            if (i < baseList.size() - 1) {
                writer.write("\n");
            }
        }
        writer.close();
        System.out.println("Written to file.");
    }
    public static void main(String[] args) throws IOException {
        theActualMain("emptytest");
    }
}