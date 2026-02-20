import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class RadixSortTest {
    @Test
    public void testBasicList1() throws IOException {
        RadixSort.theActualMain("test_file");
        File file = new File("test_file_key.txt");
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

        assertEquals("ComMANDEERs", rawfile[0], "Output is not fully sorted");
        assertEquals("DiSeMbOdyING", rawfile[1], "Output is not fully sorted");
        assertEquals("enthusiasm", rawfile[2], "Output is not fully sorted");
        assertEquals("EXPLORATIONS", rawfile[3], "Output is not fully sorted");
        assertEquals("LIBELEES", rawfile[4], "Output is not fully sorted");
        assertEquals("milder", rawfile[5], "Output is not fully sorted");
        assertEquals("pAnDErING", rawfile[6], "Output is not fully sorted");
        assertEquals("ReFurbISHMENT", rawfile[7], "Output is not fully sorted");
        assertEquals("spectroscopy", rawfile[8], "Output is not fully sorted");
        assertEquals("STENCILED", rawfile[9], "Output is not fully sorted");
    }
    public void testBasicList2() throws IOException {
        RadixSort.theActualMain("testfile2");
        File file = new File("testfile2_key.txt");
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

        assertEquals(new String[]{"ApPlE","bANANA","Dartboards","end","eXORCISM", "floccinaucinihilipilificatioN", "nogapshere", "RADAR", "reallybiggap", "shUTDOWN", "ZYZYX", "zyzyx", "ZYZYx"}, rawfile, "Output is not fully sorted");
    }
    public void testEmptyList() throws IOException {
        RadixSort.theActualMain("emptytest");
        File file = new File("emptytest_key.txt");
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

        assertEquals(new String[]{}, rawfile, "Cannot handle empty files");
    }
}