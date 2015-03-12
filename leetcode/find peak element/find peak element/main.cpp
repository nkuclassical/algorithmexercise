//
//  main.cpp
//  find peak element
//
//  Created by Yanqiao Zhan on 1/11/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        ListNode*cur=head;
        ListNode*pre=new ListNode(-1);
        pre->next=head;
        head=pre;
        for(int i=1;i<m;i++)
        {
            cur=cur->next;
            pre=pre->next;
        }
        ListNode*tail=cur;
        ListNode*temp=cur;
        pre->next=pre->next->next;
        for(int i=m;i<n;i++)
        {
            temp=pre->next;
            pre->next=pre->next->next;
            temp->next=cur;
            cur=temp;
        }
        tail->next=pre->next;
        pre->next=temp;
        return head->next;
    }
};int main(int argc, const char * argv[]) {
    Solution s;
    ListNode*head=new ListNode(1);
    ListNode*cur=head;
    cur->next=new ListNode(2);
    cur=cur->next;
    cur->next=new ListNode(3);
    cur=cur->next;
    cur->next=new ListNode(4);
    cur=cur->next;
    cur->next=new ListNode(5);
    cur=cur->next;
    cur=s.reverseBetween(head, 1, 5);
    while(cur!=NULL)
    {
        cout<<cur->val<<" ";
        cur=cur->next;
    }
    cout<<endl;
    return 0;
}
