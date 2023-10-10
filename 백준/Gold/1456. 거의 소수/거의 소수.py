a, b = map(int,input().split())

arr = [True] * (10000001)
count = 0
for i in range(2, len(arr)):
    if arr[i] == True:
        for j in range(i+i, len(arr), i):
            arr[j] = False
for i in range(2, len(arr)):
    if arr[i] == True:
        temp = i
        while(temp*i <= b):
            temp *= i
            if temp >= a:
                count += 1
print(count)