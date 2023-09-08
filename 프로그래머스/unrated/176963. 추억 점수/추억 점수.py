def solution(name, yearning, photo):
    answer = []
    dic = {person:yearning[i] for i, person in enumerate(name)}
    sum = 0
    for name_li in photo:
        for i in range(len(name_li)):
            if name_li[i] in dic:
                sum += dic.get(name_li[i])
        answer.append(sum)
        sum = 0
    
    return answer