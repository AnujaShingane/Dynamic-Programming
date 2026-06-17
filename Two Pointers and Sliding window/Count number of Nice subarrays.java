class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] arr = nums.clone();

        for(int i = 0 ; i < n ; i++){
            if(arr[i]%2 == 0){
                arr[i]=0;
            }else arr[i] = 1;
        }

        return func(arr,k) - func(arr,k-1);
    }

    public int func(int[] nums,int goal) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int cnt = 0;
        int n = nums.length;
        if(goal<0)return 0;

        while(r<n){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            if(sum<=goal)cnt+=(r-l+1);
            r++;
        }

        return cnt;
    }
}
