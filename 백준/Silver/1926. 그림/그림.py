import sys
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
paper = [list(map(int, input().split())) for _ in range(n)]
area = 0
answer = []

mx = [1, 0, -1, 0]
my = [0, 1, 0, -1]

def dfs(x, y):
    global area
    # 인접구역 확인
    if paper[x][y] == 1:
        paper[x][y] = 0
        area += 1
        for i in range(4):
            dx = x + mx[i]
            dy = y + my[i]
            if (dx >= 0 and dx < n) and (dy >= 0 and dy < m):
                dfs(dx, dy)

for i in range(n):
    for j in range(m):
        if paper[i][j] == 1: 
            dfs(i,j)
            answer.append(area)
            area = 0

print(len(answer))
if answer:
    print(max(answer))
else:
    print(0)