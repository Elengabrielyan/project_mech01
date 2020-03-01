package Study;
import java.util.*;


public class project01 {
	float v;
	float x;
	float t;
	float s;
	float a_x;
	float a_n;
	
	public project01(float v,float x, float t, float s, float a_x, float a_n) {
		Scanner scan = new Scanner(System.in); 
		if(v < 20 || v > 80) {
			System.out.println("Write right values for V[20,80]");
			this.v = scan.nextFloat();
		}
		else {
			this.v = v;
		}
		if(x < 10 || x > 150) {
			System.out.println("Write right values for X[10-150]");
			this.x = scan.nextFloat();
		}
		else {
			this.x = x;
		}
		if(t < 2 || t > 5) {
			System.out.println("Write right values for T[2,5]");
			this.t = scan.nextFloat();
		}
		else {
			this.t = t;
		}
		if(s < 5 || s > 20) {
			System.out.println("Write right values for S[5,20]");
			this.s = scan.nextFloat();
		}
		else {
			this.s = s;
		}
		if(a_x < 1 || a_x > 3) {
			System.out.println("Write right values for Positive Acc[1,3]");
			this.a_x = scan.nextFloat();
		}
		else {
			this.a_x = a_x;
		}
		if(a_n < 1 || a_n > 3) {
			System.out.println("Write right values for Negative Acc[1,3]");
			this.a_n = scan.nextFloat();
		}
		else {
			this.a_n = a_n;
		}
		scan.close();
	}
	
	public boolean possible() {
		System.out.println("The Vmax is:" +  v+a_x*t);
		return ((x+s)/(v+a_x*t)<=t);
	}
	
	public boolean impossible() {
		return (((x+s)/(v+a_x*t)<=t) && ((x+s)/(v-a_n*t)>=t));
	}
	public void two_cars(project01 car2) {
		if(car2.possible() && possible())
			System.out.println("They both cross it");
		else if(car2.possible() || possible()) {
			System.out.println("One of them does or the second one hits the first one");
		}
		else {
			System.out.println("They don't cross it");
		}
	}
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in); 
	
	System.out.println("Initial speed [20,80]");  
    float v = scan.nextFloat(); 
    
    System.out.println("Distance to Intersection [10-150]");  
    float x = scan.nextFloat();
    
    System.out.println("Duration of yellow light[2,5]");
    float t = scan.nextFloat();
      
    System.out.println("Intersection's width [5,20]");  
    float s = scan.nextFloat();

    System.out.println("Positive Acceleration [1,3]"); 
    float a_x = scan.nextFloat();
    
    System.out.println("Negative Acceleration [1,3]");  
    float a_n = scan.nextFloat();  
    
    System.out.println("distance [10, 100]");  
    float d = scan.nextFloat();  
	if (d < 10 || d > 100) {
		System.out.print("please input right value [10, 100]");
		d = scan.nextFloat();
	}

    scan.close();
    project01 car = new project01(v, x, t, s, a_x, a_n);
    project01 car2 = new project01(v, x+d, t, s, a_x, a_n);
    car.two_cars(car2);
}
}
