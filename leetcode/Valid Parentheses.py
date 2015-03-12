class Solution:
    # @return a boolean
    def isValid(self, s):
        lst=[]
        for i in s:
            if i=='[' or i=='(' or i=='{':
                lst.append(i)
            if len(lst)==0 and (i==']' or i==')' or i=='}'):
                return False
            if len(lst)!=0:
                if i==']' and lst.pop()!='[':
                    return False
                elif i==')' and lst.pop()!='(':
                    return False
                elif i=='}' and lst.pop()!='{':
                    return False
        if len(lst)==0:
            return True
        else:
            return False
