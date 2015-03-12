class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self,s):
        maxlength,fast,slow=0,0,0
        d=dict()
        for i in range(len(s)):
            fast=i
            if s[i] in d:
                if d[s[i]]==1:#already in it
                    maxlength=max(fast-slow,maxlength)
                    for j in range(slow,fast):
                        if s[i]!=s[j]:
                            d[s[j]]=0
                        else:
                            slow=j+1
                            break
                else:
                    maxlength=max(fast-slow+1,maxlength)
                    d[s[i]]=1
            else:
                maxlength=max(fast-slow+1,maxlength)
                d[s[i]]=1
        return maxlength