import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Integer;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class PrimeSieve
{
    private static List<Integer> primes;
    
    private static void init() {
        primes = new ArrayList<>();
    }

    public static void generatePrimes(int range)
    {
        //Add the first known prime to the list
        primes.add(2);
        
        int candidate = 3;
        while(candidate < range)
        {
            if(isAPrime(candidate))
            {
                primes.add(candidate);
            }
            candidate++;
        }
    }


    public static boolean isAPrime(int candidate)
    {
        Iterator<Integer> itr = primes.iterator();
        boolean isPrime = true;

        while(itr.hasNext())
        {
            int divisor = itr.next();

            if(safeProduct(divisor,divisor) > candidate)
            {
                break;
            }

            if(candidate % divisor == 0)
            {
                isPrime = false;
                break;
            }
            
        }
        return isPrime;
    }

    public static void printList()
    {
        Iterator<Integer> itr = primes.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }


    /* Returns product of two integers if it is within the range of an int,
     * or the maximum value of a signed int if overflow is detected.
     */
    private static int safeProduct(int a, int b) {
        int product = a*b;
        if(a!=0 && product/a==b){return product;}

        return Integer.MAX_VALUE;
    }

    public static void main(String ...args) throws IOException, IllegalArgumentException
    {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for(;tests>0; tests--) {

            init();
            int range = sc.nextInt();

            if(range <= 0 || range == Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Range "+ range + 
                    " should be a value in [1,"+ Integer.MAX_VALUE + "]");
            }
            long startTime = System.currentTimeMillis();
            generatePrimes(range);
            long endTime = System.currentTimeMillis();
            printList();
            System.out.println("\n"+primes.size()+ " primes generated in "+ (endTime-startTime)+"ms." );
        }
    }
}

