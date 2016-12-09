public class TestLocation
{
	public static void main(String [] args)
	{
		Location test;
		
		for(int i = 0; i<5; i++)
		{
			test = new Location();
			System.out.println("getLName: " + test.getLName());
			System.out.println("getEName: " + test.getEName());
			System.out.println("getType: " + test.getType());
			System.out.println("getRating: " + test.getRating());
			System.out.println("==============================");
		}
		
		test = new Location("", 250, "", "i");
		System.out.println("getLName: " + test.getLName());
		System.out.println("getEName: " + test.getEName());
		System.out.println("getType: " + test.getType());
		System.out.println("getRating: " + test.getRating());
		System.out.println("==============================");
		
		test = new Location("", -250, "", "f");
		System.out.println("getLName: " + test.getLName());
		System.out.println("getEName: " + test.getEName());
		System.out.println("getType: " + test.getType());
		System.out.println("getRating: " + test.getRating());
		System.out.println("==============================");
		
		test = new Location("Party", 0, "Fun Time", "i");
		System.out.println("getLName: " + test.getLName());
		System.out.println("getEName: " + test.getEName());
		System.out.println("getType: " + test.getType());
		System.out.println("getRating: " + test.getRating());
		System.out.println("==============================");
		
		test = new Location("Halfway!?", 250, "Spare Parts", "e");
		System.out.println("getLName: " + test.getLName());
		System.out.println("getEName: " + test.getEName());
		System.out.println("getType: " + test.getType());
		System.out.println("getRating: " + test.getRating());
		System.out.println("==============================");
		
		test = new Location("Meh", 350, "Meh", "w");
		System.out.println("getLName: " + test.getLName());
		System.out.println("getEName: " + test.getEName());
		System.out.println("getType: " + test.getType());
		System.out.println("getRating: " + test.getRating());
		System.out.println("==============================");
		
		test = new Location("A Rock & A Hard Place", 500, "Your Gonna Have A Bad Time", "f");
		System.out.println("getLName: " + test.getLName());
		System.out.println("getEName: " + test.getEName());
		System.out.println("getType: " + test.getType());
		System.out.println("getRating: " + test.getRating());
		System.out.println("==============================");
		
		Location test1;
		Location test2;
		Location test3;
		Location test4;
		
		test1 = new Location("test1", 250, "", "i");
		System.out.println("getLName: " + test1.getLName());
		System.out.println("getEName: " + test1.getEName());
		System.out.println("getType: " + test1.getType());
		System.out.println("getRating: " + test1.getRating());
		System.out.println("==============================");
		
		test2 = new Location("test2", 250, "", "e");
		System.out.println("getLName: " + test2.getLName());
		System.out.println("getEName: " + test2.getEName());
		System.out.println("getType: " + test2.getType());
		System.out.println("getRating: " + test2.getRating());
		System.out.println("==============================");
		
		test3 = new Location("test3", 250, "", "w");
		System.out.println("getLName: " + test3.getLName());
		System.out.println("getEName: " + test3.getEName());
		System.out.println("getType: " + test3.getType());
		System.out.println("getRating: " + test3.getRating());
		System.out.println("==============================");
		
		test4 = new Location("test4", 250, "", "f");
		System.out.println("getLName: " + test4.getLName());
		System.out.println("getEName: " + test4.getEName());
		System.out.println("getType: " + test4.getType());
		System.out.println("getRating: " + test4.getRating());
		
		Wookie bob = new Wookie("Bob", 250, 2, 3, 3);
		Wookie jill = new Wookie("Jill", 250, 2, 2, 1);
		
		TimeMachine TM1 = new TimeMachine("a",10);
		TM1.addWookieA(bob);
		TM1.addWookieB(jill);
		TM1.setActive();
		
		TimeMachine TM2 = new TimeMachine("b",8);
		TM2.addWookieA(bob);
		TM2.addWookieB(jill);
		TM2.setActive();
		
		TimeMachine TM3 = new TimeMachine("c",6);
		TM3.addWookieA(bob);
		TM3.addWookieB(jill);
		TM3.setActive();
		
		TimeMachine TM25 = new TimeMachine("d",0);
		TM25.addWookieA(bob);
		TM25.addWookieB(jill);
		TM25.setActive();
		
		System.out.println("===========SIM TESTING===========");
		
		System.out.println("Wookie Bob");
		System.out.println(bob.getName());
		System.out.println(bob.getAge());
		System.out.println(bob.getRank());
		System.out.println(bob.getEng());
		System.out.println(bob.getFort());
		System.out.println(bob.getTH());
		System.out.println("==============================");
		
		System.out.println("Wookie Jill");
		System.out.println(jill.getName());
		System.out.println(jill.getAge());
		System.out.println(jill.getRank());
		System.out.println(jill.getEng());
		System.out.println(jill.getFort());
		System.out.println(jill.getTH());
		System.out.println("==============================");
		
		System.out.println("Simulation TM1 @ test1");
		System.out.println("----------------------------");
		System.out.println("Pre Exe:");
		System.out.println("Wookie A: " + TM1.getWookieA().getName());
		System.out.println("Wookie B: " + TM1.getWookieB().getName());
		System.out.println("Active?: " + TM1.isActive());
		test1.simulate(TM1);
		System.out.println("Post Exe:");
		System.out.println("Wookie A: " + TM1.getWookieA());
		System.out.println("Wookie B: " + TM1.getWookieB());
		System.out.println("Active?: " + TM1.isActive());
		System.out.println("==============================");
		System.out.println("Simulation TM2 @ test2");
		System.out.println("----------------------------");
		System.out.println("Pre Exe:");
		System.out.println("Wookie A: " + TM2.getWookieA().getName());
		System.out.println("Wookie B: " + TM2.getWookieB().getName());
		System.out.println("Active?: " + TM2.isActive());
		test2.simulate(TM2);
		System.out.println("Post Exe:");
		System.out.println("Wookie A: " + TM2.getWookieA());
		System.out.println("Wookie B: " + TM2.getWookieB());
		System.out.println("Active?: " + TM2.isActive());
		System.out.println("==============================");
		System.out.println("Simulation TM3 @ test3");
		System.out.println("----------------------------");
		System.out.println("Pre Exe:");
		System.out.println("Wookie A: " + TM3.getWookieA().getName());
		System.out.println("Wookie B: " + TM3.getWookieB().getName());
		System.out.println("Active?: " + TM3.isActive());
		test3.simulate(TM3);
		System.out.println("Post Exe:");
		System.out.println("Wookie A: " + TM3.getWookieA());
		System.out.println("Wookie B: " + TM3.getWookieB());
		System.out.println("Active?: " + TM3.isActive());
		System.out.println("==============================");
		System.out.println("Simulation TM25 @ test4");
		System.out.println("------------------------------");
		System.out.println("Pre Exe:");
		System.out.println("Wookie A: " + TM25.getWookieA().getName());
		System.out.println("Wookie B: " + TM25.getWookieB().getName());
		System.out.println("Active?: " + TM25.isActive());
		test4.simulate(TM25);
		System.out.println("Post Exe:");
		System.out.println("Wookie A: " + TM25.getWookieA());
		System.out.println("Wookie B: " + TM25.getWookieB());
		System.out.println("Active?: " + TM25.isActive());
		System.out.println("==============================");
	}
}