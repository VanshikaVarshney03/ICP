#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
    int characterReplacement(string s, int k) {
        vector<int> count(26, 0);
        int l= 0, maxl= 0, maxc = 0;

        for (int r= 0; r < s.size(); r++) {
            char ch = s[r];
            count[ch - 'A']++;
            maxc = max(maxc, count[ch - 'A']);

            while (r - l + 1 - maxc > k) {
                count[s[l] - 'A']--;
                l++;
            }

            maxl = max(maxl, r - l+ 1);
        }

        return maxl;
    }
};
