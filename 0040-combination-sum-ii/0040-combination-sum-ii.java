import java.util.*;

class Solution {

    static void solve(
        int[] candidates,
        int target,
        int idx,
        List<List<Integer>> ans,
        List<Integer> output
    ) {

        // Target reached
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // Out of bounds
        if (idx >= candidates.length || target < 0) {
            return;
        }

        // Include current element
        output.add(candidates[idx]);

        solve(
            candidates,
            target - candidates[idx],
            idx + 1,
            ans,
            output
        );

        // Backtrack
        output.remove(output.size() - 1);

        // Exclude current element
        // Skip duplicates when excluding
        int nextIdx = idx + 1;

        while (
            nextIdx < candidates.length &&
            candidates[nextIdx] == candidates[idx]
        ) {
            nextIdx++;
        }

        solve(
            candidates,
            target,
            nextIdx,
            ans,
            output
        );
    }

    public List<List<Integer>> combinationSum2(
        int[] candidates,
        int target
    ) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(candidates, target, 0, ans, output);

        return ans;
    }
}