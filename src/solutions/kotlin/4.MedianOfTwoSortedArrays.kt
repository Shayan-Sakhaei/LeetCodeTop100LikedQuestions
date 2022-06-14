package solutions.kotlin

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val m = nums1.size
    val n = nums2.size
    val merged = IntArray(m + n)
    var nums1Pointer = 0
    var nums2Pointer = 0
    var mergedPointer = 0

    while (nums1Pointer < m && nums2Pointer < n) {
        if (nums1[nums1Pointer] < nums2[nums2Pointer]) {
            merged[mergedPointer++] = nums1[nums1Pointer++]
        } else {
            merged[mergedPointer++] = nums2[nums2Pointer++]
        }
    }

    while (nums1Pointer < m) {
        merged[mergedPointer++] = nums1[nums1Pointer++]
    }

    while (nums2Pointer < n) {
        merged[mergedPointer++] = nums2[nums2Pointer++]
    }

    return if (merged.size % 2 == 0) {
        ((merged[merged.size / 2] + merged[(merged.size / 2) - 1])) / 2.0
    } else {
        merged[merged.size / 2] / 1.0
    }
}

fun main() {
    val nums1 = intArrayOf(1, 3)
    val nums2 = intArrayOf(2)

    println(findMedianSortedArrays(nums1, nums2))
}