//
//  main.cpp
//  mergelinkedlist
//
//  Created by Yanqiao Zhan on 1/8/15.
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
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode *head,*cur=head;
        if(l1==NULL)return l2;
        if(l2==NULL)return l1;
        while(l1!=NULL||l2!=NULL){
            if(l1!=NULL&&l2!=NULL)
            {
                if(l1->val<=l2->val)
                {
                    cur->next=l1;
                    cur=cur->next;
                    l1=l1->next;
                }
                else if(l1->val>l2->val)
                {
                    cur->next=l2;
                    cur=cur->next;
                    l2=l2->next;
                }
            }
            else if(l1!=NULL&&l2==NULL)
            {
                cur->next=l1;
                break;
            }
            else if(l1==NULL&&l2!=NULL)
            {
                cur->next=l2;
                break;
            }
        }
        return head;
    }
};
int main(int argc, const char * argv[]) {
    ListNode*a,*b;
    b=new ListNode(1);
    a=new ListNode(4);
    Solution s;
    s.mergeTwoLists(a, b);
    
    return 0;
}
