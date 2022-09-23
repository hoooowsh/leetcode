package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAveragefromDataStream_346 {

	public static void main(String args[]) {
		MovingAverage movingAverage = new MovingAverage(3);
		movingAverage.next(1); // return 1.0 = 1 / 1
		movingAverage.next(10); // return 5.5 = (1 + 10) / 2
		movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
		movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
	}

	public static class MovingAverage {
		Queue<Integer> q;
		int size;
		int sum;

		public MovingAverage(int size) {
			q = new LinkedList<>();
			this.size = size;
			this.sum = 0;
		}

		public double next(int val) {
			if (q.size() == size) {
				sum -= q.poll();
				sum += val;
				q.add(val);
				return (double) sum / this.size;
			} else {
				q.add(val);
				sum += val;
				return (double) sum / q.size();
			}
		}
	}
}
