package medium;

public class TowSum2InputArraySorted_167 {
    public void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        int[] result = new int[2];
        while (head != tail) {
            if (numbers[head] + numbers[tail] == target) {
                result[0] = head + 1;
                result[1] = tail + 1;
                break;
            } else if (numbers[head] + numbers[tail] < target) {
                head++;
            } else {
                tail--;
            }
        }
        return result;
    }
}
