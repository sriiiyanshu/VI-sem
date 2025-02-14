str = [1,1,1,1,2,3,4,5]
freq={}
for word in str:
    if word in freq:
        freq[word]+=1
    else:
        freq[word]=1
        
print(freq)

lmao=set()
for i in str:
    lmao.add(i)
    
print(lmao)


