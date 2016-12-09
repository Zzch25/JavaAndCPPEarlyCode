public class WookieTest
{
	public static void main(String [] args)
	{
		Wookie test = new Wookie();
		System.out.println(test.getName());
		System.out.println(test.getAge());
		System.out.println(test.getRank());
		System.out.println(test.getEng());
		System.out.println(test.getFort());
		System.out.println(test.getTH());
		
		Wookie test2 = new Wookie("test2",-25025,-12314,-100000,-10000);
		System.out.println(test2.getName());
		System.out.println(test2.getAge());
		System.out.println(test2.getRank());
		System.out.println(test2.getEng());
		System.out.println(test2.getFort());
		System.out.println(test2.getTH());
		
		Wookie test3 = new Wookie("test3",25025,12314,100000,10000);
		System.out.println(test3.getName());
		System.out.println(test3.getAge());
		System.out.println(test3.getRank());
		System.out.println(test3.getEng());
		System.out.println(test3.getFort());
		System.out.println(test3.getTH());
		
		Wookie test4 = new Wookie("",250,3,3,3);
		System.out.println(test4.getName());
		System.out.println(test4.getAge());
		System.out.println(test4.getRank());
		System.out.println(test4.getEng());
		System.out.println(test4.getFort());
		System.out.println(test4.getTH());
	}
}