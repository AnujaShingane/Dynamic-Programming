class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int maxlen = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;

        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0)map.remove(s.charAt(l));
                l++;
            }
            
            if(map.size()==k)maxlen = Math.max(maxlen,r-l+1);
            r++;
        }

        return (maxlen == Integer.MIN_VALUE) ? -1 : maxlen;
    }
}
