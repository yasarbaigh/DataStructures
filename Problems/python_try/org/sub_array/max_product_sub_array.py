from typing import List


# https://leetcode.com/problems/maximum-product-subarray/
# https://www.youtube.com/watch?v=hnswaLJvr6g
class Solution:
    def maxProduct(self, nums: List) -> int:
        maxi = float('-inf')
        n = len(nums) - 1
        ip = nums
        prefix = 1
        suffix = 1
        for i in range(len(nums)):
            prefix *= ip[i]
            suffix *= ip[n - i]
            maxi = max(maxi, max(prefix, suffix))

            if ip[i] == 0:
                prefix = 1
            if ip[n - i] == 0:
                suffix = 1
        return maxi


c = Solution()
print(c.maxProduct([-2, 0, -1]))
print(c.maxProduct([3, 2, -1, 4, -6, 3, -2, 6]))
print(c.maxProduct(
    [0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 90]))
