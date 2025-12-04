def main():
    with open("2025/day01/input.txt") as f:
        rotations = f.readlines()
    position = 50
    n = 0
    for rotation in rotations:
        direction = rotation[0]
        distance = int(rotation[1:])
        oldPosition = position
        if direction == 'L':
            position -= distance
            if position < 0:
                n += abs(position)//100 + (0 if oldPosition == 0 else 1)
            elif position == 0:
                n += 1
        else:
            position += distance
            n += position//100
        position %= 100
    print(n)


if __name__ == "__main__":
    main()