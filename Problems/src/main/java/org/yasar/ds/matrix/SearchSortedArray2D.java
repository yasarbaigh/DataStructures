package oy.ds.matrix;


//XXXXXXXXXXXXX
/**
 * 
 * http://stackoverflow.com/questions/2457792/given-a-2d-array-sorted-in-increasing-order-from-left-to-right-and-top-to-bottom
 * @author kingpin
 *
 */
public class SearchSortedArray2D {

    static boolean findZigZag(int[][] a, int t) {
        int i = 0;
        int j = a.length - 1;
        while (i <= a.length - 1 && j >= 0) {
            if (a[i][j] == t) return true;
            else if (a[i][j] < t) i++;
            else j--;
        }
        return false;
    }

    static boolean findBinarySearch(int[][] a, int t) {
        return findBinarySearch(a, t, 0, 0, a.length - 1, a.length - 1);
    }

    static boolean findBinarySearch(int[][] a, int t,
            int r1, int c1, int r2, int c2) {
        if (r1 > r2 || c1 > c2) return false; 
        if (r1 == r2 && c1 == c2 && a[r1][c1] != t) return false;
        if (a[r1][c1] > t) return false;
        if (a[r2][c2] < t) return false;

        int rm = (r1 + r2) / 2;
        int cm = (c1 + c2) / 2;
        if (a[rm][cm] == t) return true;
        else if (a[rm][cm] > t) {
            boolean b1 = findBinarySearch(a, t, r1, c1, r2, cm - 1);
            boolean b2 = findBinarySearch(a, t, r1, cm, rm - 1, c2);
            return (b1 || b2);
        } else {
            boolean b1 = findBinarySearch(a, t, r1, cm + 1, rm, c2);
            boolean b2 = findBinarySearch(a, t, rm + 1, c1, r2, c2);
            return (b1 || b2);
        }
    }

    static void randomizeArray(int[][] a, int N) {
        int ri = (int) (Math.random() * N);
        int rj = (int) (Math.random() * N);
        a[ri][rj] = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == ri && j == rj) continue;
                else if (i > ri || j > rj) a[i][j] = 3;
                else a[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) {

        int N = 8000;
        int[][] a = new int[N][N];
        int randoms = 100;
        int repeats = 1000;

        long start, end, duration;
        long zigMin = Integer.MAX_VALUE, zigMax = Integer.MIN_VALUE;
        long binMin = Integer.MAX_VALUE, binMax = Integer.MIN_VALUE;
        long zigSum = 0, zigAvg;
        long binSum = 0, binAvg;

        for (int k = 0; k < randoms; k++) {
            randomizeArray(a, N);

            start = System.currentTimeMillis();
            for (int i = 0; i < repeats; i++) findZigZag(a, 2);
            end = System.currentTimeMillis();
            duration = end - start;
            zigSum += duration;
            zigMin = Math.min(zigMin, duration);
            zigMax = Math.max(zigMax, duration);

            start = System.currentTimeMillis();
            for (int i = 0; i < repeats; i++) findBinarySearch(a, 2);
            end = System.currentTimeMillis();
            duration = end - start;
            binSum += duration;
            binMin = Math.min(binMin, duration);
            binMax = Math.max(binMax, duration);
        }
        zigAvg = zigSum / randoms;
        binAvg = binSum / randoms;

        System.out.println(findZigZag(a, 2) ?
                "Found via zigzag method. " : "ERROR. ");
        //System.out.println("min search time: " + zigMin + "ms");
        System.out.println("max search time: " + zigMax + "ms");
        System.out.println("avg search time: " + zigAvg + "ms");

        System.out.println();

        System.out.println(findBinarySearch(a, 2) ?
                "Found via binary search method. " : "ERROR. ");
        //System.out.println("min search time: " + binMin + "ms");
        System.out.println("max search time: " + binMax + "ms");
        System.out.println("avg search time: " + binAvg + "ms");
    }
}



