class Solution {
public:
void clear(vector<vector<char>>& grid,int i ,int j ){
    if(i<0||i>=grid.size()||j<0||j>=grid[0].size()||grid[i][j]=='0') return ;
       grid[i][j]='0';
       clear(grid,i+1,j);
       clear(grid,i-1,j);
         clear(grid,i,j+1);
           clear(grid,i,j-1);


}
    int numIslands(vector<vector<char>>& grid) {
        int count =0;
        int n = grid.size();
        for(int i =0;i<n;i++){
            for(int j=0;j<grid[0].size();j++){
              if(grid[i][j]=='1'){
                count++;
                clear(grid,i,j);
              }
                


            }
        }
        return count;
    }
};
