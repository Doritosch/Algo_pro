n = int(input())
arr = [True] * (10000+1)
    
for i in range(2, len(arr)):
    if arr[i] == True:
        for j in range(i+i,len(arr),i):
            arr[j] = False

for i in range(n):
    num = int(input())
    for j in range(num//2, num):
        if arr[j] == True & arr[num-j] == True :
            print(num-j, j)
            break