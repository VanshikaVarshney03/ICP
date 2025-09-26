//Brute Force
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
           int first = -1, last = -1;
    for(int i = 0; i < nums.size(); i++) {
        if(nums[i] == target) {
            if(first == -1) first = i;
            last = i;
        }
    }
    return {first, last};




    }
};



//Optimized 


#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
   
    int firstOcc(vector<int>& nums, int n, int key) {
        int s = 0, e = n - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == key) {
                ans = mid;
                e = mid - 1;  
            }
            else if (key > nums[mid]) {
                s = mid + 1;  
            }
            else {
                e = mid - 1;  
            }
        }
        return ans;
    }


    int lastOcc(vector<int>& nums, int n, int key) {
        int s = 0, e = n - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == key) {
                ans = mid;
                s = mid + 1;  
            }
            else if (key > nums[mid]) {
                s = mid + 1;  
            }
            else {
                e = mid - 1;  
            }
        }
        return ans;
    }


    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        int first = firstOcc(nums, n, target);
        int last = lastOcc(nums, n, target);
        return {first, last};  
    }
};
