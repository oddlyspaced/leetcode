package old.medium

// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/solutions/6553332/simple-greedy-python-c-java-js-c-go-swift-rust-kotlin-php
class Problem3191 {
    fun minOperations(nums: IntArray): Int {
        var count = 0
        for (i in 0 until nums.size - 2) {
            if (nums[i] == 0) {
                nums[i] = nums[i] xor 1
                nums[i + 1] = nums[i + 1] xor 1
                nums[i + 2] = nums[i + 2] xor 1
                count++
            }
        }
        return if (nums[nums.size - 2] == 1 && nums[nums.size - 1] == 1) count else -1
    }
}