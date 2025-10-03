class Solution {
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> res = new ArrayList<>();
        b(n, k, 1, new ArrayList<>(), res);
        return res;
    }
    
    private void b(int n, int k, int start, List<Integer> curr, List<List<Integer>> result) {
       
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

      
        for (int i = start; i <= n; i++) {
            curr.add(i);  
            b(n, k, i + 1, curr, result); 
            curr.remove(curr.size() - 1); 
        }}
};

