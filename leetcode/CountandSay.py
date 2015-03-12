class Solution:
    # @return a string
    def countAndSay(self, n):
        s,say,count='1',[],1
        for i in range(n-1):
            for j in range(len(s)):
                if j+1<len(s) and s[j]==s[j+1]:            
                    count+=1
                else:
                    say+=str(count)+s[j]
                    count=1
            s=''.join(say)
            say=[]
        return s