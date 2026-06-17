class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        int minlen = Integer.MAX_VALUE;
        int l=0;
        int r=0;
        int start = 0;
        for(int i = 0 ; i < t.length() ; i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        while(r<n){
            if(map.containsKey(s.charAt(r))){
                if (map.get(s.charAt(r)) > 0) count++;
                map.put(s.charAt(r),map.get(s.charAt(r))-1); 
            }

            while(count==t.length()){
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    start = l;
                }

                if (map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    if (map.get(s.charAt(l)) > 0) count--; // break match
                }
                l++;
            }

            r++;
        }

        if(minlen==Integer.MAX_VALUE)return "";
        else return s.substring(start,start+minlen);
    }
}
