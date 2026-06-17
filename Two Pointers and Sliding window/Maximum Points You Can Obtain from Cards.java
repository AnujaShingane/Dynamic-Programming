class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        int maxSum = 0;

        for(int i = 0 ; i < k ; i++){
            sum+=cardPoints[i];
        }
        maxSum = sum;

        for(int i = k-1 ; i>= 0 ; i--){
            sum -= cardPoints[i];
            sum += cardPoints[n-k+i];
            maxSum = Math.max(sum,maxSum);
        }

        return maxSum;
    }
}
