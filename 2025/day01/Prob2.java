import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Prob2 {

    public static void main(String args[]) throws Exception {
        List<String> rotations = Files.readAllLines(Path.of("2025/day01/input.txt"));
        int position = 50;
        int n = 0;
        for (String rotation: rotations) {
            char direction = rotation.charAt(0);
            int distance = Integer.parseInt(rotation.substring(1));
            int oldPosition = position;
            if (direction == 'L') {
                position -= distance;
                if (position < 0) {
                    n += (Math.abs(position))/100 + (oldPosition == 0 ? 0 : 1);
                } else if (position == 0) {
                    n++;
                }
            } else {
                position += distance;
                n += position/100;
            }
            position = mod(position, 100);
        }
        System.out.println(n);
    }

    public static int mod(int n, int m) {
        while (n < 0){
            n += m;
        }
        while (n >= m) {
            n -= m;
        }
        return n;
    }
    
}
