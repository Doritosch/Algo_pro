def concatenate(r1, r2):
    return [''.join(x) for x in zip(r1,r2,r1)]

def star(n):
    if n == 1:
        return ['*']
    n//=3
    x = star(n)
    a = concatenate(x,x)
    b = concatenate(x, [' '*n]*n)
    
    return a + b + a

print('\n'.join(star(int(input()))))