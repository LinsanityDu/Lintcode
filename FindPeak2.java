/*There is an integer matrix which has the following features:

The numbers in adjacent positions are different.
The matrix has n rows and m columns.
For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
We define a position P is a peek if:

A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
Find a peak element in this matrix. Return the index of the peak.

Have you met this question in a real interview? Yes
Example
Given a matrix:

[
  [1 ,2 ,3 ,6 ,5],
  [16,41,23,22,6],
  [15,17,24,21,7],
  [14,18,19,20,10],
  [13,14,11,10,9]
]
return index of 41 (which is [1,1]) or index of 24 (which is [2,2])

Note
The matrix may contains multiple peeks, find any of them.

Challenge
Solve it in O(n+m) time.

If you come up with an algorithm that you thought it is O(n log m) or O(m log n), can you prove it is actually O(n+m) or propose a similar but O(n+m) algorithm?
*/

class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
    	List<Integer> res = new ArrayList<Integer>();
    	if (A == null || A.length == 0 || A[0].length == 0) {
    		return res;
    	}
    	int start = 0;
    	int end = A.length - 1;
    	int mid = start + (end - start) / 2;
    	while (start + 1 < end) {
    		mid = start + (end - start) / 2;
    		int midPeak = findPeak(A[mid]);
    		if (A[mid][midPeak] > A[mid - 1][midPeak] && A[mid][midPeak] > A[mid + 1][midPeak]) {
    			res.add(mid);
    			res.add(midPeak);
    			return res;
    		} else if (A[mid][midPeak] > A[mid - 1][midPeak] && A[mid][midPeak] < A[mid + 1][midPeak]) {
    			start = mid;
    		} else if (A[mid][midPeak] < A[mid - 1][midPeak] && A[mid][midPeak] > A[mid + 1][midPeak]) {
    			end = mid;
    		} else {
    			start = mid;
    		}
    	}

    	return res;

    }


    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return 0;
        }
        
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                start = mid;
            } else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        return mid;
    }
}

