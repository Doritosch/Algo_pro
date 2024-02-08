import sys
from collections import deque
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
paper = [list(map(int, input().split())) for _ in range(n)]
answer = []

mx = [1, 0, -1, 0]
my = [0, 1, 0, -1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    paper[x][y] = 0
    area = 1
    # 인접구역 확인
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            dx = x + mx[i]
            dy = y + my[i]
            if (dx >= 0 and dx < n) and (dy >= 0 and dy < m) and paper[dx][dy] == 1:
                paper[dx][dy] = 0
                queue.append((dx, dy))
                area += 1
    return area

for i in range(n):
    for j in range(m):
        if paper[i][j] == 1: 
            answer.append(bfs(i, j))

print(len(answer))
if answer:
    print(max(answer))
else:
    print(0)