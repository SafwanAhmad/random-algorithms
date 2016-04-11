import java.lang.Integer;
import java.util.Scanner;
import java.lang.IllegalArgumentException;


public class FastPrimeSieve
{
    private static boolean[] isPrime;
    private static int range;
    private static int countPrime = 0;

    public static void init(int range)
    {
        isPrime = new boolean[range+1];

        for(int i = 0; i < isPrime.length; i++)
        {
            isPrime[i] = true;
        }
        FastPrimeSieve.range = range;
        countPrime = 0;
    }

    public static void findPrimes()
    {
        int candidate = 2;

        while(candidate <= range)
        {

            if(isPrime[candidate] == true)
            {
                markOffAllMultiples(candidate, range);
            }
            candidate++;   
        }

    }

    public static void markOffAllMultiples(int prime, int range)
    {
        int multiplier = prime;

        //To avoid integer overflow during multiplication
        while( safeProduct(prime, multiplier) <=  range)
        {
            isPrime[prime*multiplier] = false;
            multiplier++;
        }
    }

    private static int safeProduct(int a, int b)
    {
        int product = a*b;

        if(a != 0 && b == product/a)
        {
            return product;
        }
        return Integer.MAX_VALUE;
    }

    public static void printList()
    {
        for(int i = 2; i < isPrime.length; i++)
        {
            if(isPrime[i] == true)
            {   
                countPrime++;
                System.out.println(i);
            }
        }
    }

    public static void main(String ...args)
    {   
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for( ; tests > 0; tests--){
             
             int range = sc.nextInt();

             if(range <= 0 || range == Integer.MAX_VALUE)
             {
                 throw new IllegalArgumentException("Range" + range +" should be in [1," + Integer.MAX_VALUE + ")");
             }
    
             init(range);
             long startTime = System.currentTimeMillis();
             findPrimes();
             long endTime = System.currentTimeMillis();
             printList();

             System.out.println(countPrime + " primes generated in " + (endTime-startTime) + "ms.");
        }
    }
}

