def main():
    with open("2025/day01/input.txt") as f:
        rotations = f.read().split("\n")
    position = 50
    n = 0
    for rotation in rotations:
        direction = rotation[0]
        distance = int(rotation[1:])
        if direction == 'L':
            position -= distance
        else:
            position += distance
        position %= 100
        if position == 0:
            n += 1
    print(n)


if __name__ == "__main__":
    main()