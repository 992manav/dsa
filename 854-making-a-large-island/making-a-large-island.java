class Pair{
    int r;
    int c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}

class Solution {
    int[][] visited;
    Map<Integer,Integer> map;
    int n;
    int m;
    int[][] grid;

    int bfs(int i,int j,int grp){
        int area=0;
        Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(i,j));
        visited[i][j]=grp;

        int[] dirx={0,0,1,-1};
        int[] diry={1,-1,0,0};

        while(!q.isEmpty()){
            Pair p=q.poll();
            area++;

            int r=p.r;
            int c=p.c;

            for(int k=0;k<4;k++){
                int nr=r+dirx[k];
                int nc=c+diry[k];

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(grid[nr][nc]==1 && visited[nr][nc]==-1){
                        visited[nr][nc]=grp;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
        return area;
    }

    int check(int r,int c){
        int area=1;
        int[] dirx={0,0,1,-1};
        int[] diry={1,-1,0,0};

        Set<Integer> set=new HashSet<>();

        for(int i=0;i<4;i++){
            int nr=r+dirx[i];
            int nc=c+diry[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m){
                if(grid[nr][nc]==1){
                    set.add(visited[nr][nc]);
                }
            }
        }

        for(Integer grp:set){
            area+=map.get(grp);
        }
        return area;
    }

    public int largestIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        this.grid=grid;

        visited=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],-1);
        }

        map=new HashMap<>();

        int group_no=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==-1){
                    int area=bfs(i,j,group_no);
                    map.put(group_no,area);
                    group_no++;
                }
            }
        }

        int max_area=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    max_area=Math.max(max_area,check(i,j));
                }
            }
        }

        if(max_area==0){
            for(int v:map.values()){
                max_area=Math.max(max_area,v);
            }
        }

        return max_area;
    }
}
