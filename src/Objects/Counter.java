
package Objects;


import corbaJavaGenerated.CounterCORBA.*;

public class Counter extends CounterInterfacePOA{
	private int count = 0;
	
	public void incrementCounter () {
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	public void printCounter() {
		System.out.println("The value of the count is : " + count + "." );
	}
}
