
/**A substitute for BigInt using arrays since we weren't allowed to use it in the assignment
 * Name: Victor Li (251124330)
 * Date: 03/02/2022
 */
public class BigNumber{
    // The array that stores the digits of the number
    int[] bigNumber;

    /**Instantiates the class
     * @param number the starting number (has to be 1 digit only)
     * @param length the maximum amount of digits, if you go above it overflows
     */
    public BigNumber(int number, int length){
        bigNumber = new int[length];
        bigNumber[length - 1] = number;
    }

    /**Returns the array
     * @return The array that stores the digits of the numbers
     */
    public int[] getBigNumber(){
        return bigNumber;
    }

    /**Returns a String equalivent of the class
     * @return The number stored in the array as a String
     */
    public String getString(){
        String tempString = "";
        for (int x = 0; x < bigNumber.length; x++){
            tempString += bigNumber[x];
        }
        return tempString;
    }

    /**Adds the value of another BigNumber to this BigNumber
     * @param toBeAdded The number to be added towards this classes' number
     */
    public void increase(BigNumber toBeAdded){
        int carry = 0;
        // Iterates from the least significant digit to the most significant digit, adding both including the carry value
        for (int currentDigit = bigNumber.length - 1; currentDigit >= 0; currentDigit--){
            int tempNumber = bigNumber[currentDigit] + toBeAdded.getBigNumber()[currentDigit] + carry;
            // If the sum is above 10, make the take 10 away from the sum, and use it to add at the next digit instead
            if (tempNumber > 9){
                carry = 1;
                bigNumber[currentDigit] = tempNumber % 10;
            }
            else{
            // Add normally
                carry = 0;
                bigNumber[currentDigit] = tempNumber;
            }
        }
    }

    /**Subtracts the value of another BigNumber to this BigNumber
     * @param toBeSubbed The number to be subtracted
     */
    public void decrease(BigNumber toBeSubbed){
        // Iterates from the least significant digit to the most significant digit, and subtracting both
        for (int currentDigit = bigNumber.length - 1; currentDigit >= 0; currentDigit--){
            int tempNumber = bigNumber[currentDigit] - toBeSubbed.getBigNumber()[currentDigit];
            // If the difference is negative, than borrow a 10 from the next digit and add 10 to the difference
            if (tempNumber < 0){
                bigNumber[currentDigit - 1] -= 1;
                bigNumber[currentDigit] = tempNumber + 10;
            }
            else{
            // Subtract normally
                bigNumber[currentDigit] = tempNumber;
            }
        }
    }
}