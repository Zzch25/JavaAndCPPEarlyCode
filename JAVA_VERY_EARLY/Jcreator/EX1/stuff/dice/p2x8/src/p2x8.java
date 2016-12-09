import java.util.Random;
public class p2x8 {
    
    public static void main(String[] args) 
    {
    	Random generator = new Random();
		int int1;
		int int2;
		int int3;
		int int4;
		int int5;
		int int6;
		int intM; //input highest value, lowest will be one
		
		intM = 49;
		
		int1 = (generator.nextInt(intM)+1);
		int2 = (generator.nextInt(intM)+1);
		int3 = (generator.nextInt(intM)+1);
		int4 = (generator.nextInt(intM)+1);
		int5 = (generator.nextInt(intM)+1);
		int6 = (generator.nextInt(intM)+1);
		System.out.println("Your numbers are...");
		System.out.println(int1);
		System.out.println(int2);
		System.out.println(int3);
		System.out.println(int4);
		System.out.println(int5);
		System.out.println(int6);	
    }
}
