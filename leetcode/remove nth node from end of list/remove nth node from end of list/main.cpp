//
//  main.cpp
//  remove nth node from end of list
//
//  Created by Yanqiao Zhan on 1/6/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        ListNode*fast=head,*slow=head;
        int step=0;
        for(int i=0;i<n;i++)
        {
            fast=fast->next;
            step++;
        }
        if(fast==NULL)
        {
            head=head->next;
            delete slow;
            return head;
        }
        while(fast->next!=NULL)
        {
            fast=fast->next;
            slow=slow->next;
        }
        ListNode*temp=slow->next;
        slow->next=slow->next->next;
        delete temp;
        return head;
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
