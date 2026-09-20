package easy;

import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {
    public static void main(String args[]) {
        int[] arr = { 4, 5, 8, 2 };
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3); // return 4
        kthLargest.add(5); // return 5
        kthLargest.add(10); // return 5
        kthLargest.add(9); // return 8
        kthLargest.add(4); // return 8
    }

    public static class KthLargest {
        public PriorityQueue<Integer> queue;
        public int index;

        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>();
            index = k;
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
                if (queue.size() > index) {
                    queue.poll();
                }
            }
        }

        public int add(int val) {
            queue.add(val);
            if (queue.size() > index) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
