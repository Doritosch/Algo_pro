
def solution(a, b):
    day = ('THU','FRI','SAT','SUN','MON','TUE','WED')
    md = {1:31, 2:29, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}
    sum = 0
    
    for i,j in md.items():
        if a == i:
            break
        sum += j
        
    answer = day[(sum + b) % 7]
    return answer