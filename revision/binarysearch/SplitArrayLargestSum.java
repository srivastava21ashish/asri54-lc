package revision.binarysearch;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        long l=0, r=0;
        for(int n:nums){
            l=Math.max(l,n);
            r+=n;
        }
        long ans = r;
        while(l<=r){
            long mid = l+(r-l)/2;
            if(canSplit(mid, nums, k)){
                //find better solution
                ans = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return (int)ans;
    }

    private boolean canSplit(long mid, int[] nums, int k){
        long m = 1, sum=0;
        for(int n:nums){
            if(sum+n > mid){
                m++;
                sum=n;
            }else{
                sum+=n;
            }
        }
        if(m<=k){
            return true;
        }
        return false;
    }
}
