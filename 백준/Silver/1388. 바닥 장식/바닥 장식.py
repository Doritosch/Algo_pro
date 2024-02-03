N, M = map(int, input().split())
floor = [list(map(str, input())) for _ in range(N)]
answer = 0

def check_tile(x, y):
    tile_type = floor[x][y]
    floor[x][y] = '1' # 방문표시

    # 인접구역 확인
    if tile_type == '|':
        for a in [-1,1]:
            dx = x + a
            if (dx >= 0 and dx < N) and floor[dx][y] == '|':
                check_tile(dx, y)

    if tile_type == '-':
        for b in [-1,1]:
            dy = y + b
            if (dy >= 0 and dy < M) and floor[x][dy] == '-':
                check_tile(x,dy)

for i in range(N):
    for j in range(M):
        if floor[i][j] == '-' or floor[i][j] == '|':
            answer += 1 
            check_tile(i,j)

print(answer)