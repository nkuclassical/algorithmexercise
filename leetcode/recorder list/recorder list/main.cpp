//
//  main.cpp
//  recorder list
//
//  Created by Yanqiao Zhan on 1/22/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;
struct ListNode
{
    int val;
    ListNode*next;
    ListNode(int x):val(x),next(NULL){}
};
class Solution{
public:
    void reorderList(ListNode*head)
    {
        vector<int>listvalue;
        if(head==NULL)return ;
        ListNode*cur=head;
        listvalue.push_back(head->val);
        while(cur->next!=NULL)
        {
            listvalue.push_back(cur->next->val);
            cur=cur->next;
        }
        cur=head;
        for(int i=listvalue.size()-1;i>listvalue.size()/2;i--)
        {
            ListNode *temp=new ListNode(listvalue[i]);
            temp->next=cur->next;
            cur->next=temp;
            cur=cur->next->next;
        }
        if(listvalue.size()%2==0)
            cur->next->next=NULL;
        else
            cur->next=NULL;
        
    }
};
int main(int argc, const char * argv[]) {

    return 0;
}
