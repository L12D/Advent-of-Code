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
        m, index = find(bank[:-11])
        true_index = index + 1
        joltage = m*pow(10, 11)
        for battery in range(11, 0, -1):
            if battery != 1:
                m, index = find(bank[true_index:-battery+1])
            else:
                m, index = find(bank[true_index:])
            true_index += index + 1
            joltage += m*pow(10, battery-1)
        p += joltage
        # print(joltage)
    print(p)
    

if __name__ == "__main__":
    main()