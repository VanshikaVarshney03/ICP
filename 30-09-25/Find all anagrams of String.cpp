class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
    vector<int> result, pCount(26, 0), window(26, 0);
    int k = p.length();

    for (char c : p) pCount[c - 'a']++;  

    for (int i = 0; i < s.length(); i++) {
        window[s[i] - 'a']++;             
        if (i >= k) window[s[i - k] - 'a']--;  
        if (window == pCount) result.push_back(i - k + 1);
    }

    return result;
    }
};
