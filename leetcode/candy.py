class Solution:
    # @param ratings, a list of integer
    # @return an integer
    def candy(self, ratings):
        if len(ratings)==1:return 1
        candy,l=[],min(ratings)
        for i in ratings:
            candy.append(i+1-l)
        for i in range(len(ratings)):
            if i==0:
                if ratings[0]<=ratings[1]:
                    candy[0]=1
                else:
                    candy[0]=candy[1]+1
            elif i==len(ratings)-1:
                if ratings[i]<=ratings[i-1]:
                    candy[i]=1
                else:
                    candy[i]=candy[i-1]+1
            else:
                if ratings[i]<=ratings[i+1] and ratings[i]<=ratings[i-1]:
                    candy[i]=1
                elif ratings[i]>ratings[i+1] and ratings[i]<=ratings[i-1]:
                        candy[i]=candy[i+1]+1
                elif ratings[i]<=ratings[i+1] and ratings[i]>ratings[i-1]:
                        candy[i]=candy[i-1]+1
                else:
                    candy[i]=max(candy[i+1],candy[i-1])+1
        for i in range(len(ratings)-1,-1,-1):
            if i==0:
                if ratings[0]<=ratings[1]:
                    candy[0]=1
                else:
                    candy[0]=candy[1]+1
            elif i==len(ratings)-1:
                if ratings[i]<=ratings[i-1]:
                    candy[i]=1
                else:
                    candy[i]=candy[i-1]+1
            else:
                if ratings[i]<=ratings[i+1] and ratings[i]<=ratings[i-1]:
                    candy[i]=1
                elif ratings[i]>ratings[i+1] and ratings[i]<=ratings[i-1]:
                        candy[i]=candy[i+1]+1
                elif ratings[i]<=ratings[i+1] and ratings[i]>ratings[i-1]:
                        candy[i]=candy[i-1]+1
                else:
                    candy[i]=max(candy[i+1],candy[i-1])+1
        return sum(candy)