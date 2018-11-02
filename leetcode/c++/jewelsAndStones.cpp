#include<iostream>
#include<cstdio>
#include<string>
#include<set>

using namespace std;

class Solution {
    public:
        int numJewelsInStones(string J, string S) {
            set<char> set;
            for (char ch : J)
                set.insert(ch);

            int count = 0;
            for (char ch : S)
                if (set.find(ch) != set.end()) count++;

            return count;
        }
};

int main() {
    // string J = "aA", S = "aAAbbbb";
    string J = "z", S = "ZZ";

    Solution solution;
    cout<<solution.numJewelsInStones(J, S)<<endl;
}