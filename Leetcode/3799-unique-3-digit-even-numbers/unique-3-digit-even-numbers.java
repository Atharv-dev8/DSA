class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count each digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        // Check every 3-digit even number
        for (int num = 100; num <= 998; num += 2) {

            int ones = num % 10;
            int tens = (num / 10) % 10;
            int hundreds = num / 100;

            int[] used = new int[10];

            used[ones]++;
            used[tens]++;
            used[hundreds]++;

            boolean possible = true;

            for (int digit = 0; digit <= 9; digit++) {
                if (used[digit] > freq[digit]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}