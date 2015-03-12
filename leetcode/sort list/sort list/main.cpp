//
//  main.cpp
//  sort list
//
//  Created by Yanqiao Zhan on 1/10/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) {
        val = x;
        next = NULL;
    }
};

class Solution {
public:
    ListNode *sortList(ListNode *head) {
        ListNode*result,*cur=head;
        vector<int>value;
        while(cur!=NULL)
        {
            value.push_back(cur->val);
            cur=cur->next;
        }
        sort(value.begin(),value.end());
        if(value.size()==0||value.size()==1)return head;

        result=new ListNode(value[0]);
        head=result;
       for(int i=1;i<value.size();i++)
        {
            result->next=new ListNode(value[i]);
            result=result->next;
        }
        return head;
    }
};
int main()
{
    ListNode*head,*cur;
//    head=new ListNode(1);
    head=NULL;
    cur=head;
    /*for(int i=0;i<10;i++)
    {
        head->next=new ListNode(20-i);
        head=head->next;
    }*/
    Solution s;
    head=s.sortList(cur);
    while(head!=NULL)
    {
        cout<<head->val<<endl;
        head=head->next;
    }
    return 0;
}