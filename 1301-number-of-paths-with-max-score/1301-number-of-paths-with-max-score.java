import java.util.*;

class Solution {
    static final int M=1_000_000_007;
    public int[] pathsWithMaxScore(List<String> b) {
        int n=b.size();
        int[][] dp=new int[n+1][n+1];
        int[][] c=new int[n+1][n+1];
        for(int[] x:dp)Arrays.fill(x,-1);
        c[n-1][n-1]=1;dp[n-1][n-1]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(b.get(i).charAt(j)=='X'||(i==n-1&&j==n-1))continue;
                int v=b.get(i).charAt(j)=='E'?0:b.get(i).charAt(j)-'0';
                int mx=-1;
                for(int[] d:new int[][]{{1,0},{0,1},{1,1}}){
                    int x=i+d[0],y=j+d[1];
                    if(x<n&&y<n&&dp[x][y]!=-1){
                        mx=Math.max(mx,dp[x][y]);
                    }
                }
                if(mx==-1)continue;
                dp[i][j]=mx+v;
                for(int[] d:new int[][]{{1,0},{0,1},{1,1}}){
                    int x=i+d[0],y=j+d[1];
                    if(x<n&&y<n&&dp[x][y]==mx){
                        c[i][j]=(c[i][j]+c[x][y])%M;
                    }
                }
            }
        }
        return dp[0][0]==-1?new int[]{0,0}:new int[]{dp[0][0],c[0][0]};
    }
}
