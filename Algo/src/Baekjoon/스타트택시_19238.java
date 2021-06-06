package Baekjoon;



public class 스타트택시_19238 {
	
	
	public static void main(String[] args) {
		Vehicle obj = new Car("Spark");
		System.out.println(obj.getName());		
	}	
	

}
abstract class Vehicle{
	String name;
	abstract public String getName(String Val);
	public String getName() {
		return "Vehicle name: " +name;
	}
}

class Car extends Vehicle{
	public Car(String val) {
		name = super.name = val;
	}
	public String getName(String val) {
		return "Car name: " +val;
		
	}
	public String getName(byte val[]) {
		return "Car name :"+val;
	}
}

