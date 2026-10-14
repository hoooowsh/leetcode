package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache_146 {
	public static void main(String args[]) {
		LRUCache2 test = new LRUCache2(2);
		test.put(1, 1);
		test.put(2, 2);
		System.out.println(test.get(1));
		test.put(3, 3);
		System.out.println(test.get(2));
		test.put(4, 4);
		System.out.println(test.get(1));
		System.out.println(test.get(3));
		System.out.println(test.get(4));
	}

	public static class LRUCache2 {

		private HashMap<Integer, Node> map;
		private int capacity;
		private Node head;
		private Node tail;

		public LRUCache2(int capacity) {
			map = new HashMap<>();
			this.capacity = capacity;
			head = new Node(-1, -1);
			tail = new Node(-1, -1);
			head.next = tail;
			tail.prev = head;
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}
			Node node = map.get(key);
			moveToTail(node); // Refresh recency
			return node.val;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				node.val = value;
				moveToTail(node);
			} else {
				if (map.size() == capacity) {
					// Evict LRU node (node right after dummy head)
					Node lru = head.next;
					removeNode(lru);
					map.remove(lru.key);
				}
				Node newNode = new Node(key, value);
				addToTail(newNode);
				map.put(key, newNode);
			}
		}

		private void removeNode(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		private void addToTail(Node node) {
			// Insert before dummy tail
			node.prev = tail.prev;
			node.next = tail;
			tail.prev.next = node;
			tail.prev = node;
		}

		private void moveToTail(Node node) {
			removeNode(node);
			addToTail(node);
		}

		class Node {
			Node next;
			Node prev;
			int val;
			int key;

			public Node(int key, int val) {
				this.key = key;
				this.val = val;
			}
		}
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
}
