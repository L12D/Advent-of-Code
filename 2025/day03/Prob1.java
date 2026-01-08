import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Prob1 {

    public static void main(String[] args) throws Exception {
        List<String> banks = Files.readAllLines(Path.of("2025/day03/input.txt"));
        int n = 0;
        int n1;
        int n2;
        int i_max;
        int j_max;
        for (String bank: banks) {
            i_max = 0;
            for (int i = 0; i < bank.length() - 1; i++) {
                if (bank.charAt(i) > bank.charAt(i_max)) {
                    i_max = i;
                }
            }
            n1 = bank.charAt(i_max) - '0';
            j_max = i_max + 1;
            for (int j = i_max + 1; j < bank.length(); j++) {
                if (bank.charAt(j) > bank.charAt(j_max)) {
                    j_max = j;
                }
            }
            n2 = bank.charAt(j_max) - '0';
            n += 10*n1 + n2;
        }
        System.out.println(n);
    }

}