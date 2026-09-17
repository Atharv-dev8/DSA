import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int sum = 0;
        int l = 0;
        int bestmin = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        int[] minlengthtillIndex = new int[arr.length];
        Arrays.fill(minlengthtillIndex, Integer.MAX_VALUE);/*“We have not found any valid subarray yet.”

       So we use:

       Integer.MAX_VALUE

     which is a very large integer.

    After Arrays.fill():

    [∞, ∞, ∞, ∞, ∞]

    Conceptually, where ∞ represents Integer.MAX_VALUE.*/

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[l];
                l++;
            }

            if (sum == target) {

                int currlength = right - l + 1;

                if (l > 0 && minlengthtillIndex[l - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result,
                            minlengthtillIndex[l - 1] + currlength);
                }

                bestmin = Math.min(bestmin, currlength);
            }

            minlengthtillIndex[right] = bestmin;
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }
}

/*result = Math.min(result,
                 minlengthtillIndex[l - 1] + currlength);

There are two parts here.

minlengthtillIndex[l - 1] + currlength

means:

previous valid subarray length
+
current valid subarray length
=
total length of two subarrays

For example:

previous length = 2
current length  = 3

total = 2 + 3 = 5

Then:

Math.min(result, 5)

checks whether 5 is smaller than the result we already have.

Example:

result = 7
new total = 5

Math.min(7, 5) = 5

So:

result = 5;

Meaning of result: the minimum total length of two non-overlapping valid subarrays found so far.*/

/*bestmin = Math.min(bestmin, currlength);

currlength is the length of the current valid subarray.

bestmin stores the smallest valid subarray length found so far.

Example:

bestmin    = 4
currlength = 2

Then:

Math.min(4, 2)

gives:

2

So:

bestmin = 2;*/

/*minlengthtillIndex[right] = bestmin;

This stores the current bestmin at index right.

For example:

bestmin = 2
right = 4

then:

minlengthtillIndex[4] = 2;

So the array might become:

[∞, ∞, 2, 2, 2]

The meaning is:

Up to this index, the smallest valid subarray length we have found is 2.

This is why later we can use:

minlengthtillIndex[l - 1]

to get the best valid subarray before the current subarray.

4. This line*/

/*if (result == Integer.MAX_VALUE)

At the beginning:

result = Integer.MAX_VALUE;

This means:

We haven't found two valid subarrays yet.

So at the end we check whether result is still Integer.MAX_VALUE.

If yes → no answer was found.*/

/*return -1;

If we couldn't find two valid non-overlapping subarrays:

result = Integer.MAX_VALUE

then the problem says to return:

-1

So:

if (result == Integer.MAX_VALUE) {
    return -1;
}

means:

"If no pair of valid subarrays was found, return -1."*/

/*return
currlength
    ↓
compare with bestmin
    ↓
store smallest valid subarray
    ↓
put it in minlengthtillIndex[right]

This second part is what allows us to find the best previous non-overlapping subarray.*/