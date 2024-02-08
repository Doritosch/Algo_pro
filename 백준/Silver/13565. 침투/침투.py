import sys
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
figure = [list(map(int, str(input()))) for _ in range(n)]
answer = []

mx = [1, 0, -1, 0]
my = [0, 1, 0, -1]
count_1 = figure[n-1].count(1)

def dfs(x, y):
    # 인접구역 확인
    if figure[x][y] == 0:
        figure[x][y] = 1
        for i in range(4):
            dx = x + mx[i]
            dy = y + my[i]
            if (dx >= 0 and dx < n) and (dy >= 0 and dy < m):
                dfs(dx, dy)

for i in range(m):
    if figure[0][i] == 0: 
        dfs(0,i)

count_2 = figure[n-1].count(1)

if count_1 == count_2:
    print("NO")
else:
    print("YES")