def pow(a,b,c):
    if b == 1:
        return a % c
    elif b % 2 == 0:
        return (pow(a, b // 2, c) ** 2) % c
    else:
        return (pow(a, b // 2, c) ** 2) * a % c
A, B, C = map(int,input().split())
print(pow(A,B,C))