package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache_146 {
	public static void main(String args[]) {
		LRUCache test = new LRUCache(2);
		test.put(1, 1);
		test.put(2, 2);
		test.get(1);
		test.put(3, 3);
		test.get(2);
		test.put(4, 4);
		test.get(1);
		test.get(3);
		test.get(4);
	}

	// slow version
	public static class LRUCache {
		private HashMap<Integer, Integer> hash;
		private Queue<Integer> queue;
		private int size;

		public LRUCache(int capacity) {
			this.hash = new HashMap<>();
			this.queue = new LinkedList<>();
			this.size = capacity;
		}

		public int get(int key) {
			if (!this.hash.containsKey(key)) {
				return -1;
			} else {
				queue.remove(key);
				queue.add(key);
				return hash.get(key);
			}
		}

		public void put(int key, int value) {
			if (!this.hash.containsKey(key)) {
				if (this.queue.size() >= this.size) {
					int k = queue.poll();
					hash.remove(k);
					hash.put(key, value);
					queue.add(key);
				} else {
					hash.put(key, value);
					queue.add(key);
				}
			} else {
				hash.put(key, value);
				queue.remove(key);
				queue.add(key);
			}
		}
	}

	// faster version, key idea is using a doubled linked list to keep track with
	// the order, and a hashmap with key as key and listnode as value
	public static class LRUCache2 {

	}
}
