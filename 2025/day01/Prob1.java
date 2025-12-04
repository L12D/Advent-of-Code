import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Prob1 {

    public static void main(String args[]) throws Exception {
        List<String> rotations = Files.readAllLines(Path.of("2025/day01/input.txt"));
        int position = 50;
        int n = 0;
        for (String rotation: rotations) {
            char direction = rotation.charAt(0);
            int distance = Integer.parseInt(rotation.substring(1));
            if (direction == 'L') {
                position -= distance;
            } else {
                position += distance;
            }
            position %= 100;
            if (position == 0) {
                n++;
            }
        }
        System.out.println(n);
    }

}