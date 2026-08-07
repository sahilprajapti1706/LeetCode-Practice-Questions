class Solution {

    static void solve(int[] nums, int idx, List<List<Integer>> ans, List<Integer> output) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // Include
        output.add(nums[idx]);
        solve(nums, idx + 1, ans, output);

        // Backtrack
        output.remove(output.size() - 1);

        // Exclude
        solve(nums, idx + 1, ans, output);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(nums, 0, ans, output);

        return ans;
    }
}