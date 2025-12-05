import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Prob2 {

    public static void main(String args[]) throws Exception {
        String[] ranges = Files.readString(Path.of("2025/day02/input.txt")).split(",");
        Set<Long> validIds = new HashSet<>();
        
        for (String range: ranges) {
            String[] parts = range.split("-");
            long a = Long.parseLong(parts[0]);
            long b = Long.parseLong(parts[1]);
            
            // Check all possible lengths in the range
            int minLen = String.valueOf(a).length();
            int maxLen = String.valueOf(b).length();
            
            for (int len = minLen; len <= maxLen; len++) {
                checkRepeatingPatterns(a, b, len, 2, validIds);
                checkRepeatingPatterns(a, b, len, 3, validIds);
                checkRepeatingPatterns(a, b, len, 5, validIds);
                checkRepeatingPatterns(a, b, len, 7, validIds);
            }
        }

        long sum = 0;
        for (long n: validIds) {
            sum += n;
        }
        System.out.println(sum);
    }
    
    private static void checkRepeatingPatterns(long a, long b, int totalLen, int repetitions, Set<Long> validIds) {
        if (totalLen % repetitions != 0) return;
        
        int patternLen = totalLen / repetitions;
        long minPattern = (long)Math.pow(10, patternLen - 1);
        long maxPattern = (long)Math.pow(10, patternLen) - 1;
        
        for (long pattern = minPattern; pattern <= maxPattern; pattern++) {
            long id = 0;
            for (int i = 0; i < repetitions; i++) {
                id += pattern * (long)Math.pow(10, i * patternLen);
            }
            
            if (id >= a && id <= b) {
                validIds.add(id);
            }
            
            if (id > b) break;
        }
    }
}