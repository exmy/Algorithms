import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three3Sum {

    /**
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     * -4 -1 -1 0 1 2
     * <p>
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length < 3) return resultList;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            int sum = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    if (!resultList.contains(Arrays.asList(nums[i], nums[low], nums[high])))
                        resultList.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) low++;
                else high--;
            }
        }
        return resultList;
    }

    @Test
    public void test() {

        threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }

}
