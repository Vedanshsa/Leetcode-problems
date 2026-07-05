class Solution {
    public int numOfStrings(String[] p, String w) {
        int c=0;
        for(String s:p) if(w.contains(s)) c++;
        return c;
    }
}
