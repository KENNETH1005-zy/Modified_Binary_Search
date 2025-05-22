import java.util.*;

public class Solution3 extends BadVersion{
   public Solution3(int v) {
       super(v);
   }
   public int firstBadVersion(int n) {
       int first = 1;
       int last = n;
       while (first <= last) {
           int mid = first + (last - first) / 2;
           if (isBadVersion(mid)) {
               last = mid - 1;
           } else {
               first = mid + 1;
           }
       }
       return first;
   }
    public static void main(String[] args) {
        int[] versions = {6, 8, 9, 11, 8};
        int[] badVersions = {3, 5, 1, 11, 4};

        for (int i = 0; i < versions.length; i++) {
            Solution3 solution = new Solution3(badVersions[i]);
            System.out.println((i + 1) + ".\tNumber of versions: " + versions[i]);
            System.out.println("\n\tFirst bad version: " + solution.firstBadVersion(versions[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}