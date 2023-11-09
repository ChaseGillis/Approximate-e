/* 
 * Homework 9, Problem 4
 * Chase Gillis 11/08/2023
 * Approximate e
Approximate e using the following series: 

𝑒 = (1+(1/1!)+(1/2!)+(1/3!)+(1/4!)+(1/5!)+⋯+ 1/𝑖! ) 

In order to get better precision, use BigDecimal with 25 digits of precision in the computation. 
Write a program that displays the e value for i = 100, 200, ..., 1000.
 */
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
public class ApproximateE {
    public static void main(String[] args) {
        //Declarations
        BigDecimal[] approximations = new BigDecimal[10];//This stores the approximations for each value
        for (int count = 0, i = 100; i <= 1000; i += 100) {//test values
            BigDecimal approximation = BigDecimal.ONE;//Reset approximation to 1 to account for the og 1 in the formula
            BigInteger factorial = BigInteger.ONE;//start it at one so it never reaches 0
            for (int j = 1; j <= i; j++) {//computational level of approximation
                factorial = factorial.multiply(BigInteger.valueOf(j));//calculate the factorial
                //System.out.println(factorial);//Test Line
                //1 is always the numerator so divide it as the fraction and round the decimal to 25 as per the instructions
                BigDecimal approx = BigDecimal.ONE.divide(new BigDecimal(factorial), 25, RoundingMode.HALF_EVEN);
                approximation = approximation.add(approx);//add up that term in the sequence
            }
            approximations[count] = approximation;//store the approximation 
            count++;//update to keep storing correctly
        }
        //Output
        for (int i = 100, l= 0; i <= 1000; i += 100, l++) {
            System.out.println("i = " + i + " e approximates to " + approximations[l]);//output
            //NOTE THE DECIMALS ARE SO SIMILIAR, THEY PRODUCE THE SAME OUTPUT SINCE WE ARE ROUNDING TO 25!!!
        }
    }
}