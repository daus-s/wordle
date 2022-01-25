import alphatize as alpha

#utility file
def concat():
    src1 = input('enter filename 1: ')
    src2 = input('enter filename 2: ')
    dst = input('enter concat filename: ')
    f1 = open(src1, 'r')
    f2 = open(src2, 'r')
    f3 = open(dst, 'a+')

    ln1 = f1.readlines()
    ln2 = f2.readlines()

    sorted = alpha.sort2(ln1, ln2)

    f3.writelines(sorted)


def main():
    concat()

if __name__ == '__main__':
    main()
