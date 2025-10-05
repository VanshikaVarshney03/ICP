class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;  
        int N = m + n - 2;  
        int k = Math.min(m - 1, n - 1);

        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }

        return (int) res;
    }
}
