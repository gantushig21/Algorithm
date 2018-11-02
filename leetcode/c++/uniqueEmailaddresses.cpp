#include<iostream>
#include<vector>
#include<set>

using namespace std;

class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        set<string> emls;

        string local, domain;
        int at, plus;
        for (string email : emails) {
            at = email.find("@");
            domain = email.substr(at);
            local = email.substr(0, at);
            local = local.replace(local.begin(), local.end(), ".", "");

            plus = local.find("+");
            if (plus > -1)
                local = local.substr(0, plus);

            emls.insert(local + domain);
        }
    
        return emls.size();
    }
};

int main() {
    string emls[] = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
    vector<string> emails;

    for (string email : emls)
        emails.push_back(email);

    Solution solution;
    cout<<solution.numUniqueEmails(emails)<<endl;
}