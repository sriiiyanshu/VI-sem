
def fun(n):
    if n==0 or n==1:
        return 1
    fact= n * fun(n-1)
    return fact
    
print(fun(5))
