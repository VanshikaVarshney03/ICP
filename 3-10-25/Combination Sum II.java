import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); 
        b(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void b(int[] candidates, int target, int index, 
                           List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr)); 
            return;
        }
        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {
           
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            curr.add(candidates[i]);
            b(candidates, target - candidates[i], i + 1, curr, res);
            curr.remove(curr.size() - 1); }
    }
}
