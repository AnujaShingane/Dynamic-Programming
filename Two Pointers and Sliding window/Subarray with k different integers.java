class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k) - func(nums,k-1);
    }

    public int func(int[] nums,int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        if(k<0)return 0;

        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            if(map.size()<=k){
                cnt += (r-l+1);
            }
            r++;
        }

        return cnt;
    }
}
