public class Avg {
	
	public static void main(String[]args) {
		
		float total = calculateCourseSum();
		System.out.println("In main, sum ="+ total);
		
		float average = calculateCourseAverage();
		System.out.println("In main, average ="+average);
		
	}
	
	public static float calculateCourseSum() {
		int math = 100;
		int oop=92;
		int clanguage=95;
		int compdesign = 100;
		int dreamfuture = 90;
		
		int sum = math + oop + clanguage + compdesign + dreamfuture;
		
		System.out.println("sum: "+sum);
		
		return sum;
	}
	
	
	
	public static float calculateCourseAverage() {
		float sum = calculateCourseSum();
		
		float avg = sum/5;
		
		return avg;
	}
}
