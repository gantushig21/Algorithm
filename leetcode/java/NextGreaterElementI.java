import java.util.*;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.add(num);
        }

        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterElementI problem = new NextGreaterElementI();

        int[] nums1 = new int[] { 4, 1, 2 };
        int[] nums2 = new int[] { 1, 3, 4, 2 };

        System.out.println(Arrays.toString(problem.nextGreaterElement(nums1, nums2)));
    }
}