arr=[5,8,9,1,4,2,6,3]

for i in range(1,len(arr)):
    key=arr[i]
    j=i-1
    
    while(arr[j]>key and j>=0):
        arr[j+1]=arr[j]
        j-=1
    
    arr[j+1]=key
    
print(arr)