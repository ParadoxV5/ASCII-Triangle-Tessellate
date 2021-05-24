import java.util.Scanner;
public abstract class Main {
  static int inputNumber(Scanner scanner, String prompt) {
    int inpt;
    System.out.println(prompt);
    while(true) {
      // Loop until a valid input is given: { n | n ∈ ℝ⁺ }
      System.out.print('\t');
      try {
        inpt = Integer.parseInt(scanner.nextLine());
        if(inpt > 0) return inpt;
      } catch(NumberFormatException __) {}
    }
  }
  public static void main(String[] __) {
    int height, columns, rows, /* Loop variables -> */ row, length, line;
    try(Scanner scanner = new Scanner(System.in)) {
      height  = inputNumber(scanner, "Enter height of triangles:");
      columns = inputNumber(scanner, "Enter number of traingles per row:");
      rows    = inputNumber(scanner, "Enter number of rows:");
    }
    
    for(row = 0; row < rows; ++row) {
      if(row % 2 == 0) {
        // Computers iterate starting from 0
        // thus this part is actually for odd rows (#0, #2,…)
        length = 2*height - 1; // The number of '*'s for the longest line
        for(line = 0; line < height; ++line) {
          // For convention. Equivalent to (from row 1 to row last) - 1
          System.out.println(
            (" ".repeat(line+1) + "*".repeat(length) + " ".repeat(line)).repeat(columns)
          );
            // <line> + 1 ' 's, <length> '*'s, and <line> ' 's
            //   +1 for an extra padding on the left
          length -= 2;
            // each line has 1 less ' ' on each end and
            //   2 less '*' in the center.
        }
      } else {
        /*
          thus this part is for even rows (#1, #3,…)
          All is the same but this is the vertically flipped &
            character-swapped version for odd rows.
          *****     *     *       *** *****
           ***  ->  **   ***  ->  **   ***
            *       *** *****     *     *
        */
        length = 1;
        for(line = height - 1; line >= 0; --line) {
          System.out.println(
            ("*".repeat(line+1) + " ".repeat(length) + "*".repeat(line)).repeat(columns)
          );
          length += 2;
        }
      }
    }
  }
}