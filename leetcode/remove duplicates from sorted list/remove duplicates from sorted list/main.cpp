//
//  main.cpp
//  remove duplicates from sorted list
//
//  Created by Yanqiao Zhan on 1/9/15.
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
    ListNode *deleteDuplicates(ListNode *head) {
        if(head==NULL)return head;
        ListNode*cur=head;
        while(cur->next!=NULL)
        {
            if(cur->val==cur->next->val)
            {
                if(cur->next->next!=NULL)
                {
                    cur->next=cur->next->next;
                }
                else
                {
                    cur->next=NULL;
                }
            }
            
        }
        return head;
    }
};
int main(int argc, const char * argv[]) {
    return 0;
}
