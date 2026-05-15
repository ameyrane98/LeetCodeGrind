class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        n = len(nums)
        window_sum = 0
        max_sum = float('-inf')
        for i in range(n):
            window_sum+=nums[i]
            if i >= k:
                window_sum -= nums[i - k]      # drop left when window too big
            if i >= k - 1:
                max_sum = max(max_sum, window_sum) 

        
        return max_sum/k

