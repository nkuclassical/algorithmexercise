//
//  main.cpp
//  merge
//
//  Created by Yanqiao Zhan on 3/4/15.
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
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode*newlist=new ListNode(-1),*head=newlist;
        ListNode*teml1=l1,*teml2=l2;
        cout<<"lists1 "<<endl;
        ListNode*cur1=l1;
        while(cur1)
        {
            cout<<cur1->val<<" ";
            cur1=cur1->next;
        }
        cout<<endl;
        cout<<"lists2 "<<endl;
        cur1=l2;
        while(cur1)
        {
            cout<<cur1->val<<" ";
            cur1=cur1->next;
        }
        cout<<endl;
        while(teml1!=NULL||teml2!=NULL)
        {
            if(teml1!=NULL&&teml2!=NULL)
            {
                if(teml1->val<teml2->val)
                {
                    newlist->next=new ListNode(teml1->val);
                    teml1=teml1->next;
                    //newlist=newlist->next;
                }
                else
                {
                    newlist->next=new ListNode(teml2->val);
                    teml2=teml2->next;
                    //newlist=newlist->next;
                }
            }
            else if(teml1==NULL)
            {
                newlist->next=new ListNode(teml2->val);
                teml2=teml2->next;
                //newlist=newlist->next;
            }
            else if(teml2==NULL)
            {
                newlist->next=new ListNode(teml1->val);
                teml1=teml1->next;
                //newlist=newlist->next;
            }
            else if(teml1==NULL&&teml2==NULL)
            {
                break;
            }
            newlist=newlist->next;
        }

        return head->next;
    }
    ListNode *mergeKLists(vector<ListNode*>&lists)
    {
        if(lists.size()>2)
        {

            vector<ListNode*>v1=vector<ListNode*>(lists.begin(),lists.begin()+lists.size()/2);
            vector<ListNode*>v2=vector<ListNode*>(lists.begin()+lists.size()/2,lists.end());
            ListNode*tem1=mergeKLists(v1);
            
            ListNode*tem2=mergeKLists(v2);
            vector<ListNode*>newv;
            newv.push_back(tem1);
            newv.push_back(tem2);
            return mergeKLists(newv);
        }
        else if(lists.size()==2)
        {
            return mergeTwoLists(lists[0],lists[1]);
        }
        else //if(lists.size()==1)
        {
            return lists[0];
        }
//        else
    }
    void rotate(int nums[], int n, int k) {
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    void reverse(int nums[],int begin,int end)
    {
        while(begin<end)
        {
            int temp=nums[begin];
            nums[begin]=nums[end];
            nums[end]=temp;
            begin++;
            end--;
        }
    }
};
int main(int argc, const char * argv[]) {
    // insert code here...
    Solution s;
   /* ListNode*head1=new ListNode(-2);
    ListNode*cur=new ListNode(-3),*head3=cur;
    cur->next=new ListNode(-2);
    cur=cur->next;
        cur->next=new ListNode(1);
    vector<ListNode*>lists;
    lists.push_back(NULL);
    lists.push_back(head1);
    lists.push_back(head3);
    head1=s.mergeKLists(lists);
    while(head1!=NULL)
    {
        cout<<head1->val<<" ";
        head1=head1->next;
    }*/
    int nums[]={1,2,3,4,5,6,7};
    
    s.rotate(nums, 7, 3);
    for(int i=0;i<7;i++)
    {
        cout<<nums[i]<<" ";
    }
    cout<<endl;
    return 0;
}
