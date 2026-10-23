class Solution {
    public int findNthDigit(int n) {
        long digits = 1;
        long count = 9;
        long start = 1;

        while (n > count * digits) {
            n -= count * digits;
            digits++;
            count *= 10;
            start *= 10;
        }

        long num = start + (n - 1) / digits;
        int index = (int) ((n - 1) % digits);

        String str = String.valueOf(num);
        return str.charAt(index) - '0';
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna