bool cmp(vector<int>& a, vector<int>& b) {
    return a[1] < b[1];
}


class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {

         if (points.empty()) return 0;

       sort(points.begin(), points.end(), cmp);   


       int arrows = 1;           
    int end = points[0][1];   

    for (auto &p : points) {
        if (p[0] > end) {     
            arrows++;        
            end = p[1];       
        }
    }
    return arrows;
    }
};
