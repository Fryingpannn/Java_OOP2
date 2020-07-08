package airTransport;

public class Test {

	private int hi;
	private Object obj;
	
	public Test() {
		hi = 5;
	}
	
	public Test(Object noll) {
		obj = noll;
	}
	
	public boolean equals(Object otherObj) {
		Test other = (Test) otherObj;
		return (
				hi == other.getHi());
	}
	
	public int getHi(){
		return hi;
	}
}
