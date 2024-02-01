N = int(input())
CL = list(map(int, input().split()))
M = int(input())
ML = list(map(int, input().split()))
CL.sort()

def binary_search(target, data):
    start = 0
    end = len(data) - 1
    
    while(start <= end):
        mid = (start + end) // 2
        
        if data[mid] == target:
            return 1
        elif data[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0

answer = []

for item in ML:
    answer.append(binary_search(item, CL))

print(' '.join(map(str, answer)))