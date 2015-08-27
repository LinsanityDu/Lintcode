/*Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.*/


public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int l : L) {
            if (l > max) {
                max = l;
            }
        }
        
        int start = 1;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(L, mid) < k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (count(L, start) >= k) return start;
        
        return 0;
    }
    
    private int count(int[] L, int len) {
        int res = 0;
        for (int l : L) {
            while (l / len > 0) {
                res++;
                l = l - len;
            }
        }
        return res;
    }
}
