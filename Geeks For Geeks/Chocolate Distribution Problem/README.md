# Chocolate Distribution Problem

- Platform: GeeksforGeeks
- Language: Java
- Difficulty: Easy
- Topics: Flipkart, Sorting
- Runtime: 0.29 s
- Memory: N/A
- Problem URL: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
- Synced: 2026-09-07T08:25:37.006Z

## Problem Description

<p><span style="font-size: 14pt;">Given an array <strong>arr[] </strong>of positive integers, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are <strong>m</strong> students, the task is to distribute chocolate packets among m students such that:</span></p> <ol> <li><span style="font-size: 14pt;">Each student gets exactly one packet.</span></li> <li><span style="font-size: 14pt;">The difference between maximum number of chocolates given to a student and minimum number is minimum and return that minimum possible difference.</span></li> </ol> <p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p> <pre><span style="font-size: 14pt;"><strong>Input: </strong>arr = [3, 4, 1, 9, 56, 7, 9, 12], m = 5<strong> Output: </strong>6 <strong>Explanation: </strong>The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing m packets as [3, 4, 9, 7, 9]. </span></pre> <pre><span style="font-size: 14pt;"><strong>Input: </strong>arr = [7, 3, 2, 4, 9, 12, 56], m = 3 <strong>Output: </strong>2 <strong>Explanation: </strong>The minimum difference between maximum chocolates and minimum chocolates is 4 - 2 = 2 by choosing m packets as [3, 2, 4].</span></pre> <pre><span style="font-size: 14pt;"><strong>Input: </strong>arr = [3, 4, 1, 9, 56], m = 5<strong> Output: </strong>55<br /><strong>Explanation</strong>: With 5 packets for 5 students, each student will receive one packet, so the difference is 56 - 1 = 55.</span></pre> <p><span style="font-size: 14pt;"><strong>Constraints:</strong><br />1 &le; m &le; arr.size &le; 10<sup>5</sup><br />1 &le; arr[i] &le; 10<sup>9</sup><br /></span></p>

## Explanation

This solution was accepted on GeeksforGeeks using Java. The detected topics are Flipkart, Sorting. Review the synced source file for the implementation details.
