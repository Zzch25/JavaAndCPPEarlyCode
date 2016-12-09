public class TestTimeMachine
{
	public static void main(String [] args)
	{
		TimeMachine test = new TimeMachine();
		System.out.println("getIns: " + test.getIns());
		System.out.println("isActive: " + test.isActive());
		System.out.println("getWookieA: " + test.getWookieA());
		System.out.println("getWookieB: " + test.getWookieB());
		System.out.println("killWookieA: " + test.killWookieA());
		System.out.println("killWookieB: " + test.killWookieB());
		System.out.println("=================");
	
		TimeMachine test2 = new TimeMachine();
		System.out.println("getIns: " + test2.getIns());
		System.out.println("setActive");
		test2.setActive();
		System.out.println("isActive: " + test2.isActive());
		System.out.println("setInactive");
		test2.setInactive();
		System.out.println("isActive: " + test2.isActive());
		System.out.println("=================");
		
		Wookie bob = new Wookie();
		Wookie jill = new Wookie();
		
		TimeMachine test3 = new TimeMachine();
		System.out.println("getWookieA: " + test3.getWookieA());
		System.out.println("getWookieB: " + test3.getWookieB());
		System.out.println("killWookieA: " + test3.killWookieA());
		System.out.println("killWookieB: " + test3.killWookieB());
		System.out.println("Add Wookie A");
		test3.addWookieA(bob);
		System.out.println("getWookieA: " + test3.getWookieA().getName());
		System.out.println("Add Wookie B");
		test3.addWookieB(jill);
		System.out.println("getWookieB: " + test3.getWookieB().getName());
		System.out.println("killWookieA: " + test3.killWookieA().getName());
		System.out.println("killWookieB: " + test3.killWookieB().getName());
		System.out.println("getWookieA: " + test3.getWookieA());
		System.out.println("getWookieB: " + test3.getWookieB());
		System.out.println("=================");
		
		Wookie billy = new Wookie();
		Wookie milton = new Wookie();
		
		TimeMachine test4 = new TimeMachine();
		System.out.println("Add Wookie A, " + bob.getName());
		test4.addWookieA(bob);
		System.out.println("getWookieA: " + test4.getWookieA().getName());
		System.out.println("Add Wookie B, " + jill.getName());
		test4.addWookieB(jill);
		System.out.println("getWookieB: " + test4.getWookieB().getName());
		System.out.println("Add Wookie A, " + billy.getName());
		test4.addWookieA(billy);
		System.out.println("getWookieA: " + test4.getWookieA().getName());
		System.out.println("Add Wookie B, " + milton.getName());
		test4.addWookieB(milton);
		System.out.println("getWookieB: " + test4.getWookieB().getName());
		System.out.println("Int: " + test4.getInt());
		System.out.println("Eng: " + test4.getEng());
		System.out.println("FortA: " + test4.getFortA());
		System.out.println("FortB: " + test4.getFortB());
		System.out.println("WisA: " + test4.getWisA());
		System.out.println("WisB: " + test4.getWisB());
		System.out.println("killWookieA: " + test4.killWookieA().getName());
		System.out.println("Int: " + test4.getInt());
		System.out.println("Eng: " + test4.getEng());
		System.out.println("FortA: " + test4.getFortA());
		System.out.println("FortB: " + test4.getFortB());
		System.out.println("WisA: " + test4.getWisA());
		System.out.println("WisB: " + test4.getWisB());
		System.out.println("killWookieB: " + test4.killWookieB().getName());
		System.out.println("Int: " + test4.getInt());
		System.out.println("Eng: " + test4.getEng());
		System.out.println("FortA: " + test4.getFortA());
		System.out.println("FortB: " + test4.getFortB());
		System.out.println("WisA: " + test4.getWisA());
		System.out.println("WisB: " + test4.getWisB());
		System.out.println("getWookieA: " + test4.getWookieA());
		System.out.println("getWookieB: " + test4.getWookieB());
		System.out.println("=================");
	}
}