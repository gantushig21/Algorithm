
public class SingleNumber {
    // public int singleNumber(int[] nums) {
    // Set<Integer> set = new HashSet<>();

    // for (int i = 0; i < nums.length; i++) {
    // if (set.contains(nums[i]))
    // set.remove(nums[i]);
    // else
    // set.add(nums[i]);
    // }

    // return set.iterator().next();
    // }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++)
            single ^= nums[i];

        return single;
    }

    public static void main(String[] args) {
        SingleNumber problem = new SingleNumber();

        // int[] nums = new int[] { 2, 2, 1 };
        int[] nums = new int[] { 4, 1, 2, 1, 2 };
        System.out.println(problem.singleNumber(nums));
    }
}