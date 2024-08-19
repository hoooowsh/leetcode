package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetrandomO1_380 {
    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        r.insert(0);
        r.insert(1);
        r.remove(0);
        r.insert(2);
        r.remove(1);
        r.getRandom();
    }

    static class RandomizedSet {
        private ArrayList<Integer> arr;
        private HashMap<Integer, Integer> hash1;
        Random rand;

        public RandomizedSet() {
            arr = new ArrayList<>();
            hash1 = new HashMap<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if (hash1.keySet().contains(val)) {
                return false;
            } else {
                arr.add(val);
                int pos = arr.size() - 1;
                hash1.put(val, pos);
                return true;
            }
        }

        public boolean remove(int val) {
            if (!hash1.keySet().contains(val)) {
                return false;
            } else {
                int index = hash1.get(val);
                arr.set(index, arr.get(arr.size() - 1));
                hash1.put(arr.get(index), index);
                arr.remove(arr.size() - 1);
                hash1.remove(val);
                return true;
            }
        }

        public int getRandom() {
            int random = rand.nextInt(arr.size());
            return arr.get(random);
        }
    }
}
