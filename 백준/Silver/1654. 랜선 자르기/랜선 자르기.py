K, N = map(int, input().split())
li = []
for i  in range(K):
    li.append(int(input()))

low = 1
high = max(li)

def binary_search(low, high):
    global answer
    if low > high:
        return
    
    mid = (low+high)//2
    count = 0
    
    for i in li:
        count += i//mid
    if count >= N:
        answer = mid
        binary_search(mid+1, high)
    else:
        binary_search(low, mid-1)

binary_search(low, high)
print(answer)