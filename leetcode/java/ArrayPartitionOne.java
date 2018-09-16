import java.util.*;

public class ArrayPartitionOne {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i += 2)
            sum += nums[i];

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2};

        ArrayPartitionOne problem = new ArrayPartitionOne();

        System.out.println(problem.arrayPairSum(nums));
    }
}