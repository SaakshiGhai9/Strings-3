// Time Complexity: Processing each group is O(1) and processing number of groups  O(log(n))
// Space Complexity: O( log (n))
public class IntegerToEnglishWords {
        private static final String[] LESS_THAN_20 = {
                "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        private static final String[] TENS = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0) return "Zero";

            StringBuilder result = new StringBuilder();
            int thousandGroup = 0;

            while (num > 0) {
                if (num % 1000 != 0) {
                    result.insert(0, helper(num % 1000) + THOUSANDS[thousandGroup] + " ");
                }
                num /= 1000;
                thousandGroup++;
            }

            return result.toString().trim();
        }

        private String helper(int num) {
            if (num == 0) return "";
            else if (num < 20) return LESS_THAN_20[num] + " ";
            else if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
            else return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }

        public static void main(String[] args) {
            IntegerToEnglishWords converter = new IntegerToEnglishWords();

            // Example 1
            int num1 = 123;
            System.out.println("123 in words: " + converter.numberToWords(num1)); // Output: "One Hundred Twenty Three"

            // Example 2
            int num2 = 12345;
            System.out.println("12345 in words: " + converter.numberToWords(num2)); // Output: "Twelve Thousand Three Hundred Forty Five"

            // Example 3
            int num3 = 1000000;
            System.out.println("1000000 in words: " + converter.numberToWords(num3)); // Output: "One Million"
        }
    }
