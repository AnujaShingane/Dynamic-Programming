class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxlen = 0;
        int l = 0;
        int r = 0;

        while(r<n){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0)map.remove(fruits[l]);
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }

        return maxlen;
    }
}
