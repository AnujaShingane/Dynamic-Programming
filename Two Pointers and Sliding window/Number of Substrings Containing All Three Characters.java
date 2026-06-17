class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen,-1);
        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            lastSeen[ch-'a'] = i;
            int min = (int)(1e9);

            for(int j = 0 ; j<3 ; j++){
                min = Math.min(min,lastSeen[j]);
            }
            if(min!=-1){
                ans+=(min+1);
            }
        }
        return ans;
    }
}
