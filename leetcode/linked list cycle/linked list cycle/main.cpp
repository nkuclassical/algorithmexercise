//
//  main.cpp
//  linked list cycle
//
//  Created by Yanqiao Zhan on 1/6/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
using namespace std;
struct ListNode{
    int val;
    ListNode*next;
    ListNode(int x):val(x),next(NULL){}
};
class Solution
{
public:
    bool hasCycle(ListNode*head){
        if(head==NULL||head->next==NULL)return false;
        ListNode*pace1=head;
        ListNode*pace2=head->next;
        while(pace1!=NULL&&pace2!=NULL)
        {
            if(pace1==pace2)
            {
                return true;
            }
            pace1=pace1->next;
            pace2=pace2->next;
            if(pace2==NULL)
                return false;
            pace2=pace2->next;
        }
        return false;
    }
};
int main(int argc, const char * argv[]) {

    return 0;
}
