m,n = map(int,input().split())

arr = [True] * (n+1)
arr[1] = False
for i in range(2,len(arr)):
    if arr[i] == True:
        for j in range(i+i,len(arr),i):
            arr[j] = False

for i in range(m,n+1):
    if arr[i] == True:
        print(i)