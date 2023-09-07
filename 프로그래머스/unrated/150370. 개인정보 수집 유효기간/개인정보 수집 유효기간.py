def solution(today, terms, privacies):
    answer = []
    privacie = []
    index = -1
    today = today.split(".")

    for temp in privacies:
        temp = temp.replace('.'," ")
        privacie.append(temp.split(" "))
        
    to_res = ((int(today[0]) * 12) + (int(today[1])) + (int(today[2]) / 32))
    
    for i,inform in enumerate(privacie):
        for j in range(len(terms)):
            if inform[3] in terms[j]:
                index = j
                break
                
        res = (int(terms[index][2:]) + (int(inform[0]) * 12) + (int(inform[1])) + (int(inform[2]) / 32))
        if res <= to_res:
            answer.append(i+1)
    
    return answer