/**A program that generates the 500th Lucas Number
 * Name: Victor Li (251124330)
 * Date: 03/02/2022
 */

import java.util.Scanner;

public class LucasNumbersB{

    /**This function is a helper method used to call the recursive
     * @param int The positioned number in the Lucas Sequence you want returned
     * @return The Lucas Number
    */
    public static BigNumber lucasB(int n){
        // Call the recursive algorithmn, we default Ln and Ln-1 to 0 because we don't know their values, the third value is
        // the paramater used to find the desired Lucas Number
        BigNumber[] tester = lucasRecursive(new BigNumber[]{new BigNumber(0, 500),new BigNumber(0, 500),new BigNumber(n, 10)});
        // Return the first parameter which is the desired Lucas Number
        return tester[0];
    } 

    /**This function is the recurusive function used to find the Lucas Number
     * @return An array of numbers containing Ln, Ln-1, and the parameter of the Lucas Sequence of Lninputstream
     * @param n An array of numbers containing Ln, Ln-1, and the parameter of the Lucas Sequence of Ln
     */
    public static BigNumber[] lucasRecursive(BigNumber[] n){
        // Base cases used in the lucas sequence formula
        if (Integer.parseInt(n[2].getString()) <= 1){
            return new BigNumber[]{new BigNumber(1, 500),new BigNumber(2, 500),new BigNumber(1, 10)};
        }
        // Get the previous number in the lucas sequence to calcuate the one ahead of the current
        BigNumber decrease = new BigNumber(1, 10);
        n[2].decrease(decrease);
        BigNumber[] tempArray = lucasRecursive(new BigNumber[] {n[0], n[1], n[2]});
        // Matrix multiplication using hint B, so x11 = Ln + Ln-1 and x12 = Ln
        BigNumber sum = new BigNumber(0, 500);
        sum.increase(tempArray[0]);
        sum.increase(tempArray[1]);
        // Return the Lucas Number
        return new BigNumber[]{sum, tempArray[0], n[2]};
    }
    /**Helper method that helps remove the leading zeroes from a string
     * @param str The String needing to be cleaned up
     * @return The same string with no leading zeroes
      */
    public static String removeLeadingZeros(String str) {
        while (str.indexOf("0")==0)
          str = str.substring(1);
        return str;
      }

    public static void main(String args[]){
        // Asks the user for their input
        Scanner input = new Scanner(System.in);
        System.out.print("Which element of the lucas sequence do you want?: ");
        int element = Integer.parseInt(input.next());

        // Runs the algorithm to find the desired number
        BigNumber test = lucasB(element);

        // Outputs the number properly without leading zeroes
        String tempString = "";
        for (int x = 0; x < test.getBigNumber().length; x++){
            tempString += test.getBigNumber()[x];
        }
        System.out.println(removeLeadingZeros(tempString));

        // Closes the scanner
        input.close();
        
    }
}