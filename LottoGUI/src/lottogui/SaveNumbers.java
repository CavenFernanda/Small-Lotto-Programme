/**
 * SaveNumbers.java
 * STEP 7: This class saves the numbers to a sequential textfile
 * @author Kruben Naidoo
 * Date: Monday, 22 June 2020
 */

package lottogui;
import java.io.*;

public class SaveNumbers {
    public static void storeValues(int nums[]) {
        try {
            // Create a print writer on this file
            PrintWriter out = new PrintWriter(new FileWriter("lotto.txt", true));
            for (int i = 0; i < 6; i++) {
                out.println(nums[i]);
            }
            // Close the file print writer
            out.close();
        }
        catch  (IOException e) {
            // Catch any IO exceptions
            e.printStackTrace();
        }
    }
}
			