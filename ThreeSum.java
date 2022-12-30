package ds1;

import edu.princeton.cs.algs4.In;

/******************************************************************************
 *  Compilation:  javac ThreeSum.java
 *  Execution:    java ThreeSum input.txt
 *  Dependencies: In.java StdOut.java Stopwatch.java
 *  Data files:   https://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program with cubic running time. Reads n integers
 *  and counts the number of triples that sum to exactly 0
 *  (ignoring integer overflow).
 *
 *  % java ThreeSum 1Kints.txt 
 *  70
 *
 *  % java ThreeSum 2Kints.txt 
 *  528
 *
 *  % java ThreeSum 4Kints.txt 
 *  4039
 *
 ******************************************************************************/

/**
 *  The {@code ThreeSum} class provides static methods for counting
 *  and printing the number of triples in an array of integers that sum to 0
 *  (ignoring integer overflow).
 *  <p>
 *  This implementation uses a triply nested loop and takes proportional to n^3,
 *  where n is the number of integers.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/14analysis">Section 1.4</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class ThreeSum {

    // Do not instantiate.
    private ThreeSum() { }

    /**
     * Prints to standard output the (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param a the array of integers
     */
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 

    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    } 

    /**
     * Reads in a sequence of integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  { 
        In in = new In("1Kints.txt");
        int[] a = in.readAllInts();
        In in2 = new In("128Kints.txt");
        int[] b = in2.readAllInts();
        In in3 = new In("16Kints.txt");
        int[] c = in3.readAllInts();
        In in4 = new In("256Kints.txt");
        int[] d = in4.readAllInts();
        In in5 = new In("25Kints.txt");
        int[] e = in5.readAllInts(); 
        In in6 = new In("2Kints.txt");
        int[] f = in6.readAllInts();
        In in7 = new In("32Kints.txt");
        int[] g = in7.readAllInts();
        In in8 = new In("400Kints.txt");
        int[] h = in8.readAllInts();
        In in9 = new In("4Kints.txt");
        int[] i = in9.readAllInts();
        In in10 = new In("512Kints.txt");
        int[] j = in10.readAllInts();
        In in11 = new In("64Kints.txt");
        int[] k = in11.readAllInts();
        In in12 = new In("6Kints.txt");
        int[] l = in12.readAllInts();
        In in13 = new In("8Kints.txt");
        int[] m = in13.readAllInts();

        long startTime = System.currentTimeMillis();
        int count = count(m);
        long finishTime = System.currentTimeMillis();
        System.out.println("elapsed time = " + (finishTime - startTime));
        System.out.println(count);
    } 
} 
