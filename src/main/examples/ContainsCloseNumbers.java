package main.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsCloseNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {0, 1, 2, 3, 5, 2};
		int k1 = 3;
		System.out.println(containsCloseNums(nums1, k1));

		int[] nums2 = {0, 1, 2, 3, 5, 2};
		int k2 = 2;
		System.out.println(containsCloseNums(nums2, k2));
		
		int[] nums3 = {0, 1, 2, 3, 5, 2};
		int k3 = 3;
		System.out.println(containsCloseNums(nums3, k3));
	}

	static boolean containsCloseNums(int[] nums, int k) {
		if (nums.length <= 1)
			return false;
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		boolean has2 = false;
		for (int i=0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(nums[i], list);
			} else {
				has2 = true;
				List<Integer> list = map.get(nums[i]);
				Integer previous = list.get(list.size()-1);
				if (i - previous <= k) {
					return true;
				} else {
					list.add(i);
				}
				map.put(nums[i],list);
			}
		}

		
		return false;
	}

}
