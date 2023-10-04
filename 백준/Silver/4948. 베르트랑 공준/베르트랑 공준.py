arr = [True for i in range(123456 * 2 + 1)]
    
for i in range(2, len(arr)):
    if arr[i] == True:
        for j in range(i+i, len(arr), i):
            arr[j] = False

while(n := int(input())) != 0:
    count = 0
    for i in range(n+1, 2*n+1):
        if arr[i] == True :
            count += 1
    print(count)