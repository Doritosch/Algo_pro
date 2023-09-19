N,K = map(int,input().split(" "))
Mem = [i+1 for i in range(N)]
Answer = []
index = 0

while(Mem) :
    index=  (index + (K-1)) % len(Mem)
    Answer.append(str(Mem.pop(index)))
    
print("<"+", ".join(Answer)+">")