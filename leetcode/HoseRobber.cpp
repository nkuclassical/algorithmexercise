class Solution {
public:
    int rob(vector<int> &num) {
        if(num.size()==0)return 0;
        if(num.size()==1)return num[0];
        if(num[1]<num[0])num[1]=num[0];
        for(int i=2;i<num.size();i++)
        {
            if(num[i]+num[i-2]>num[i-1])
                num[i]+=num[i-2];
            else
                num[i]=num[i-1];
        }
        return num[num.size()-1];
    }
};
