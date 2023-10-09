n = int(input())

arr = [True] * (n+1)
arr[1] = False
answer = []
for i in range(2,len(arr)):
    if arr[i] == True:
        for j in range(i+i,len(arr),i):
            arr[j] = False

def find_4_prime(n):
    if n < 8:
        return answer
    elif n % 2 == 0:
        answer.append(2)
        answer.append(2)
        n -= 4
        for i in range(2,n):
            if arr[i] == True & arr[n-i] == True:
                answer.append(i)
                answer.append(n-i)
                return answer
    else:
        answer.append(2)
        answer.append(3)
        n -= 5
        for i in range(2,n):
            if arr[i] == True & arr[n-i] == True:
                answer.append(i)
                answer.append(n-i)
                return answer
    
answer = find_4_prime(n)
if len(answer) != 4:
    print(-1)
else:
    print(' '.join(map(str,answer)))