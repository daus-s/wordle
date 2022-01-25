
#get input
def get_input(words):
    #find matches
    #both green + yellow + black
    disallowed_letters = []
    requirement =  ['*','*','*','*','*']
    required_letters = []

    for i in range(6):
        word  = input("enter word: ")[0:5]
        value = input("values gyb: ")[0:5]

        #print (words)

        for i in range(5):
            if value[i] == 'g':
                #then only words with the letter in that position are allowed
                requirement[i] = word[i]
            if value[i] == 'y':
                #yellow is in the other positions easy enough dumb fuck
                required_letters.append(word[i])
            if value[i] == 'b':
                #this letter is disallowed
                disallowed_letters.append(word[i])

        print (disallowed_letters)
        print (required_letters)
        print (requirement)

        for char in disallowed_letters:
            for i in range(len(words)):
                if words[i].__contains__(char):
                    #print (f'removed {word} for having {char} present')
                    #print (f'checking {word} for disallowed letter {char}')
                    words.remove(words[i])
                    i -= 1

        for char in required_letters:
            for i in range(len(words)):
                if not words[i].__contains__(char):
                    #print (f'removed {word} for not having {char} present')
                    words.remove(word)
                    i -= 1

            #for i in range(5):
            #    if requirement[i] != '*':
            #        for w in words:
            #            if w[i] != requirement[i]:
            #                words.remove(w)
        print (words)




def main(arg):
    src = "words.txt"
    f = open(src,"r")
    words = f.readlines()
    get_input(words)

if __name__ == '__main__':
    import sys
    main(sys.argv)
    pass
