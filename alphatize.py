#utility

#sort 2 pre-sorted lists combined
def sort2(a1, a2):
    if len(a2) > len(a1):
        sort2(a2, a1)

    #print(a1)
    #print(a2)
    j = 0;
    for i in a2:
        while j < len(a1)+1:
            #print (f'{i} > {a1[j]} and {i} < {a1[j+1]} = {i > a1[j] and i < a1[j+1]}')
            if i > a1[j-1] and i < a1[j+1]:
                a1.insert(j+1, i)
                print (f'inserted {i} between {a1[j-1]} and {a1[j+1]}')
                break
            else:
                j+=1
    #a1 should be sorted
    return a1
