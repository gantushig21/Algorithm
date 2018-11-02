#include<iostream>
#include<string>

using namespace std;

class Solution {
    public:
        int numJewelsInStones(string J, string S) {
            return 5;
        }
};

int main() {
    string J = "aA", S = "aAAbbbb";

    Solution solution;
    cout<<solution.numJewelsInStones(J, S)<<endl;
}