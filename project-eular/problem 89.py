import re
f=open('problem 89_roman.txt','r')
s=f.read()
print len(s)-len(re.sub("DCCCC|LXXXX|VIIII|IIII|XXXX|CCCC","  ",s))
f.close()
