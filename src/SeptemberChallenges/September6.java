package SeptemberChallenges;

/*
September 6

Question: Image Overlap
Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
(Note also that a translation does not include any kind of rotation.)
What is the largest possible overlap?

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3450/
*/

class September6 {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] B_padded = new int[3 * N - 2][3 * N - 2];
        for (int row = 0; row < N; ++row)
            for (int col = 0; col < N; ++col)
                B_padded[row + N - 1][col + N - 1] = B[row][col];

        int maxOverlaps = 0;
        for (int xShift = 0; xShift < 2 * N - 1; ++xShift)
            for (int yShift = 0; yShift < 2 * N - 1; ++yShift) {
                maxOverlaps = Math.max(maxOverlaps,
                        convolute(A, B_padded, xShift, yShift));
            }

        return maxOverlaps;
    }

    private int convolute(int[][] A, int[][] kernel, int xShift, int yShift) {
        int result = 0;
        for (int row = 0; row < A.length; ++row)
            for (int col = 0; col < A.length; ++col)
                result += A[row][col] * kernel[row + yShift][col + xShift];
        return result;
    }
}
