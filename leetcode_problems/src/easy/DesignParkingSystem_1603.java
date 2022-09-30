package easy;

public class DesignParkingSystem_1603 {
	public static void main(String args[]) {

	}

	public static class ParkingSystem {

		int big;
		int mid;
		int small;
		int curb;
		int curm;
		int curs;

		public ParkingSystem(int big, int medium, int small) {
			this.big = big;
			this.mid = medium;
			this.small = small;
			curb = 0;
			curm = 0;
			curs = 0;
		}

		public boolean addCar(int carType) {
			if (carType == 1) {
				curb++;
				if (curb > this.big) {
					return false;
				} else {
					return true;
				}
			} else if (carType == 2) {
				curm++;
				if (curm > this.mid) {
					return false;
				} else {
					return true;
				}
			} else {
				curs++;
				if (curs > this.small) {
					return false;
				} else {
					return true;
				}
			}
		}
	}
}
