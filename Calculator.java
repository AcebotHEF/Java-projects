import java.util.Scanner;

public class Calculator {
    private String input;
    private int pos = -1;
    private char currentChar;

    // Constructor: it takes input string. remove spaces and initializes the parser
    public Calculator(String input) {
        this.input = addImplicitMultiplication(input.replaceAll(" ", ""));
        advance();
    }

    // This method inserts explicit '*' for cases of implicit multiplication,
    // such as: 6(2+1) → 6*(2+1), or (2+1)(3+4) → (2+1)*(3+4), or 4)5 → 4)*5
    private String addImplicitMultiplication(String expr) {
        StringBuilder result = new StringBuilder(); // To build the modified expression
        char prev = '\0';  // Tracks the previous character (initially empty)

        // Loop through each character in the input expression
        for (int i = 0; i < expr.length(); i++) {
            char curr = expr.charAt(i);

            // Check for cases where implicit multiplication occurs:
            // 1. A digit or closing parenthesis is followed by:
            //    - An opening parenthesis (e.g., 6( or )( )
            //    - Another digit (e.g., 2 3 → 2*3 for clarity)
            if ((Character.isDigit(prev) || prev == ')') && (curr == '(' || Character.isDigit(curr))) {
                result.append('*'); // Insert the missing '*'
            }
            // Add the current character to the result
            result.append(curr);
            prev = curr; // Update the previous character for the next loop
        }

        return result.toString(); // Return the modified expression
    }

    // advance to the next character in the input string
    private void advance() {
        pos++;
        if (pos < input.length()) {
            currentChar = input.charAt(pos);
        } else {
            currentChar = '\0';
        }
    }
    // check if current character matches expected char and advance if it does 
    private boolean match(char ch) {
        if (currentChar == ch) {
            advance(); // use the character and move to the next one
            return true;
        }
        return false;
    }
    // start parsing and return the final result
    public double parse() {
        double result = expression();
        if (pos < input.length()) { // if character still remain, it's an error
            throw new RuntimeException("Unexpected character: " + currentChar);
        }
        return result; // return final computed result
    }

    // expression = term { (+|-) term }
    private double expression() {
        double result = term();
        // if there's a "+" operator, Add by the next factor
        if (currentChar == '+') {
            match('+');
            result += expression();
        } 
        // if there's a "-" operator, substract by the next factor
        else if (currentChar == '-') {
            match('-');
            result -= expression();
        }

        return result;
    }

    // term = factor { (*|/) factor }
    private double term() {
        double result = factor(); // evaluate the first factor
        
        // if there's a "*" operator, multiply by the next factor
        if (currentChar == '*') {
            match('*');
            result *= term();
        } 
        // if there's a '/' operator, divide by the next factor 
        else if (currentChar == '/') {
            match('/'); // check '/'
            result /= term(); // divides by next term
        }

        return result; // return result of term
    }

    // factor = number | '(' expression ')' | unary +/-
    private double factor() {
        // Handle unary plus
        if (match('+')) {
            return factor();
        } 
        // Handle unary minus
        else if (match('-')) {
            return -factor();
        }

        double result = 0;
        
        // if factor starts with '(', it's a sub expression
        if (match('(')) {
            result = expression(); // Evaluate expression inside parentheses
            if (!match(')')) {
                throw new RuntimeException("Missing closing parenthesis");
            }
        } 
        // Otherwise it's a number
        else {
            StringBuilder sb = new StringBuilder();
            // Build number characters (including decimal points)
            while ((currentChar >= '0' && currentChar <= '9') || currentChar == '.') {
                sb.append(currentChar); // Append current digit
                advance(); // move to next character 
            }

            // if no number is built, it's an error 
            if (sb.length() == 0) {
                throw new RuntimeException("Expected number but found: " + currentChar);
            }
            result = Double.parseDouble(sb.toString()); // convert string to double 
        }

        return result; // Return the numeric result 
    }

    // Main Method containing the user input and display the result
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for reading input 
        System.out.print("Please enter arithmetic expression: ");
        String input = scanner.nextLine(); // Read the full expression 
        Calculator calculator = new Calculator(input); // Create calculator instance 
        double result = calculator.parse(); // Calculate the expression following BODMAS
        System.out.println("Result: " + result); // Print the result

        scanner.close();
    }
}
    