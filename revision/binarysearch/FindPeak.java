package revision.binarysearch;

public class FindPeak {
    public int findPeakElement(int[] nums) {
        int l=0, r=nums.length-1;
        
        if(r<=0){
            return r;
        }
        if(nums[0] > getRight(0, nums)){
            return 0;
        }
        if(nums[r] > getLeft(r, nums)){
            return r;
        }
        while(l<=r){
            int mid = l+(r-l)/2;
            int num = nums[mid];
            int left = getLeft(mid, nums);
            int right = getRight(mid, nums); 
            //System.out.println("mid "+mid+"left "+left+"right "+right);
            if(num > left && num > right){
                return mid;
            }else if(left > num){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }

    private int getLeft(int idx, int[] nums){
        return idx-1 >= 0 ? nums[idx-1] : Integer.MIN_VALUE;
    }

    private int getRight(int idx, int[] nums){
        return idx+1 < nums.length ? nums[idx+1] : Integer.MIN_VALUE;
    }
}
