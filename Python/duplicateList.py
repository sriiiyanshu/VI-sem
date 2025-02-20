a=[10,20,30,10,20]
res=[]
for val in a:
    if val not in res:
        res.append(val)
        
print(res)

res2=list(set(a))
print(res2)


#aShIsH = AsHiSh

str = "aShIsH"
str2=''
for i in str:
    if i.islower():
        str2+=(i.upper())
    else:
        str2+=(i.lower())
        
print(str2)