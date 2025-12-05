def find(l):
    m = 0
    index = 0
    for i in range(len(l)):
        if l[i] > m:
            m = l[i]
            index = i
    return (m, index)


def main():
    with open("2025/day03/input.txt") as f:
        banks = f.read().split("\n")
    p = 0
    for bank in banks:
        bank = [int(n) for n in list(bank)]
        m, index = find(bank[:-1])
        n = max(bank[index+1:])
        p += 10*m + n
    print(p)
    

if __name__ == "__main__":
    main()