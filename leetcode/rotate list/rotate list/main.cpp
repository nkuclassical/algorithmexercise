//
//  main.cpp
//  rotate list
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
    ListNode *rotateRight(ListNode *head, int k) {
        ListNode*fast=head;
        for(int i=0;i<k;i++)
        {
            fast=fast->next;
        }
    }
};
int main(int argc, const char * argv[]) {

    return 0;
}
