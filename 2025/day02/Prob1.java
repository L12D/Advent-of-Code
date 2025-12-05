import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Prob1 {

    public static void main(String args[]) throws Exception {
        String[] ranges = Files.readString(Path.of("2025/day02/input.txt")).split(",");
        long n = 0;
        for (String range: ranges) {
            // System.out.println(range);
            String[] parts = range.split("-");
            long a = Long.parseLong(parts[0]);
            long b = Long.parseLong(parts[1]);
            int a_len = parts[0].length();

            long IdHalf;
            int power;
            if (a_len%2 == 1) {
                IdHalf = (long)Math.pow(10, a_len/2);
                power = a_len/2 + 1;
            } else {
                IdHalf = a/(long)Math.pow(10, a_len/2);
                power = a_len/2;
            }

            long Id = IdHalf*(long)Math.pow(10, power) + IdHalf;
            while (Id <= b) {
                if (Id >= a) {
                    // System.out.println("\t" + Id);
                    n += Id;
                }
                IdHalf++;
                if (IdHalf >= (long)Math.pow(10, power)) break;
                Id = IdHalf*(long)Math.pow(10, power) + IdHalf;
            }
        }
        System.out.println(n);
    }
    
}
