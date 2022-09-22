package medium;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class StockPriceFluctuation_2034 {
	public static void main(String args[]) {
		StockPrice stockPrice = new StockPrice();
		stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
		stockPrice.update(2, 5); // Timestamps are [1,2] with corresponding prices [10,5].
		stockPrice.current(); // return 5, the latest timestamp is 2 with the price being 5.
		stockPrice.maximum(); // return 10, the maximum price is 10 at timestamp 1.
		stockPrice.update(1, 3); // The previous timestamp 1 had the wrong price, so it is updated to 3.
									// Timestamps are [1,2] with corresponding prices [3,5].
		stockPrice.maximum(); // return 5, the maximum price is 5 after the correction.
		stockPrice.update(4, 2); // Timestamps are [1,2,4] with corresponding prices [3,5,2].
		stockPrice.minimum();

	}

	public static class StockPrice {
		HashMap<Integer, Integer> map;
		TreeMap<Integer, Integer> price;
		TreeSet<Integer> latest;

		public StockPrice() {
			map = new HashMap<>();
			price = new TreeMap<>();
			latest = new TreeSet<>();
		}

		public void update(int timestamp, int price) {
			// if there is conflict, only update price, remove old and add new
			if (map.keySet().contains(timestamp)) {
				// remove old price
				if (this.price.get(map.get(timestamp)) == 1) {
					this.price.remove(map.get(timestamp));
					this.price.put(price, 1);
				} else {
					this.price.put(map.get(timestamp), this.price.get(map.get(timestamp)) - 1);
				}
				// add new price
				if (this.price.keySet().contains(price)) {
					this.price.put(price, this.price.get(price) + 1);
				} else {
					this.price.put(price, 1);
				}
				map.put(timestamp, price);
			} else {
				map.put(timestamp, price);
				latest.add(timestamp);
				if (this.price.keySet().contains(price)) {
					this.price.put(price, this.price.get(price) + 1);
					return;
				}
				this.price.put(price, 1);
			}
		}

		public int current() {
			return map.get(latest.last());
		}

		public int maximum() {
			return price.lastKey();
		}

		public int minimum() {
			return price.firstKey();
		}
	}
}
