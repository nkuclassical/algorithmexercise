#include <iostream>
#include <queue>
using namespace std;

int sum[101];//tree/subtree with root i has sum[i] vertices.
int parent[101];
int relation[101][101];
int matrix[101][101];
int k;
int elementsumsubtree(int index)
{
    if(sum[index]!=0)return sum[index];
    else
    {
        int sm=0;
        for(int i=0;i<=100;i++)
        {
            if(relation[index][i]==1)
            {
                sm+=elementsumsubtree(i);
            }
        }
        sm++;
        sum[index]=sm;
        return sm;
        
    }
}
void findresult(int root)
{
    for(int i=0;i<=100;i++)
    {
        if(relation[root][i]==1)
        {
            if(elementsumsubtree(i)%2==0)
            {
                k++;
            }
            findresult(i);
        }
    }
}

int main()
{
    int n,m;
    cin>>n>>m;
    for(int i=0;i<=100;i++)//initializtion
    {
        sum[i]=0;
        parent[i]=-1;
        for(int j=0;j<100;j++)
        {
            relation[i][j]=0;
            matrix[i][j]=0;
        }
    }
    int node1,node2,root;
    for(int i=0;i<m;i++)
    {
        cin>>node1>>node2;
        if(i==0)
            root=node1;
        matrix[node1][node2]=1;
        matrix[node2][node1]=1;
    }
    queue<int>q;
    q.push(root);
    while(!q.empty())
    {
        int node=q.front();
        q.pop();
        for(int i=0;i<=100;i++)
        {
            if(matrix[node][i]==1&&parent[node]!=i)
            {
                parent[i]=node;
                relation[node][i]=1;
                q.push(i);
            }
        }
    }
    k=0;
    findresult(root);
    cout<<k<<endl;
    return 0;
}