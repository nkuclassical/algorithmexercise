class Solution:
    # @return an integer
    def atoi(self, str):
        if str!='':
            str=str.strip()
            if str[0]!='-' and str[0]!='+' and (str[0]<'0' or str[0]>'9'):
                return 0
            for i in range(1,len(str)):
                if str[i]<'0' or str[i]>'9':
                    if i==1 and (str[0]=='+' or str[0]=='-'):
                        return 0
                    else:
                        str=str[0:i]
                        break
            if int(str)>=2**31:
                return 2**31-1
            elif int(str)<=-2**31:
                return -2**31
            else:
                return int(str)
        else:
            return 0