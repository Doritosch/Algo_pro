n = int(input())

def Padovan(n):
    pdv = [0] * (n+3)
    
    pdv[1] = pdv[2] = pdv[3] = 1
    
    for i in range(4, n+1):
        pdv[i] = pdv[i-2] + pdv[i-3]
    
    return pdv[n]
        
for i in range(n):
    case = int(input())
    print(Padovan(case))