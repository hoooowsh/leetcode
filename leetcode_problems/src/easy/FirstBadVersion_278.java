package easy;

public class FirstBadVersion_278 {
	public static void main(String args[]) {

	}

	/*
	 * The isBadVersion API is defined in the parent class VersionControl. boolean
	 * isBadVersion(int version);
	 */

	// Always remember that {mid = lo + (hi - lo) /2}

//	public class Solution extends VersionControl {
//		public int firstBadVersion(int n) {
//	        int lo = 0;
//	        int hi = n;
//	        int mid = 1;
//
//	        while(lo < hi){
//	            mid = lo + (hi - lo) /2;
//	            if(isBadVersion(mid)){
//	                hi = mid - 1;
//	                if(hi < 1){
//	                    return mid;
//	                } 
//	                if (!isBadVersion(hi)){
//	                    return mid;
//	                }
//	                continue;
//	            }else{
//	                lo = mid + 1;
//	                if(lo > n){
//	                    return mid;
//	                } 
//	                if (isBadVersion(lo)){
//	                    return lo;
//	                }
//	                continue;
//	            }
//	        }
//	        return mid;
//	    }
//	}
}
