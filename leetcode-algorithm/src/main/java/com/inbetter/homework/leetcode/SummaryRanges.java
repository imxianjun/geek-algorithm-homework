package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 1) {
            ans.add(nums[0] + "");
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (i + 1 < nums.length && (nums[i + 1] - nums[i] == 1)) {
                i++;
            }
            if (num != nums[i]) {
                ans.add(num + "->" + nums[i]);
            } else {
                ans.add(nums[i] + "");
            }
        }
        return ans;
    }

}
