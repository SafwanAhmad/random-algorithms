
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.IOException;

public class TrialDivisionPrime
{
	private static List<Integer> primes;
	private static long numPrimes;

        private static void init() {
            primes = new ArrayList<>();
            numPrimes = 0;
        }


	public static void generatePrimes(int range)
	{
		int i = 2;
		
		while(i < range)
		{
			if(isAPrime(i) == true)
			{
				primes.add(i);
				numPrimes++;
			}
			i++;
		}
	}

	public static boolean isAPrime(int number)
	{
		int divisor = 2;
		boolean isPrime = true;

		while(divisor*divisor <= number)
		{
			if(number % divisor == 0)
			{
				isPrime = false;
				break;
			}
			divisor++;
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

	public static void main(String ...args)throws IOException
	{
                Scanner in = new Scanner(System.in);
                int tests = in.nextInt();

                for(;tests>0; tests--){
                    int range = in.nextInt();

                    init();

                    long startTime = System.currentTimeMillis();
                    generatePrimes(range);
                    long endTime = System.currentTimeMillis();
     
                    printList();
                    System.out.println("\n"+numPrimes +" primes generated in " +(endTime-startTime)+ "ms.");
                }
	}
}

