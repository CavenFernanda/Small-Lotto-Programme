/**
 * GenerateNumbers.java
 * STEP 6: This class generates six unique lotto numbers
 * @author Kruben Naidoo
 * Date: Monday, 22 June 2020
 */

package lottogui;

public class GenerateNumbers {
    public static int numbers[] = new int[6];

    // this method below stores six unique lotto numbers in the array 'numbers'
    public static void populateValues() {
        boolean flag;		
        for (int i = 0; i < 6; i++) {
            do {
                flag = false;
                numbers[i] = (int)(Math.random() * 48 + 1);
                for (int j = 0; j < i; j++) {
                    if (numbers[i] == numbers[j]) {
                        flag = true;
                        break;
                    }
                }
            } while (flag);
        }
    }
}
	