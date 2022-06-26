package com.inbetter.homework.leetcode;


public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        int maxScore = leftSum;
        for (int i = 0, rightSum = 0; i < k; i++) {
            rightSum += cardPoints[length - 1 - i];
            leftSum -= cardPoints[k - 1 - i];
            maxScore = Math.max(maxScore, leftSum + rightSum);
        }
        return maxScore;
    }

    /**
     * greedy algorithm , execute time beyond limited time.
     *
     * @param cardPoints card points
     * @param k          k
     * @return max score
     */
    public int maxScore2(int[] cardPoints, int k) {
        int length = cardPoints.length;
        if (length == k) {
            return sumScore(cardPoints, 0, length, length);
        }
        int maxScore = 0;
        for (int i = 0; i <= k; i++) {
            maxScore = Math.max(maxScore, sumScore(cardPoints, i, k - i, length));
        }
        return maxScore;
    }

    private int sumScore(int[] cardPoints, int left, int right, int length) {
        int sum = 0;
        while (left > 0) {
            sum += cardPoints[--left];
        }
        while (right > 0) {
            sum += cardPoints[length - right--];
        }
        return sum;
    }

}
