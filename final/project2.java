
import java.util.Scanner;

public class project2 {
	private Mass M1, M2, M3;
	private double myu1, myu2, myu3;
	private double force;
	private int g = 10;
	private boolean direction; 
	
		public project2(double my1, double my2, double my3, Mass m1, Mass m2, Mass m3, double f){
			M1 = m1;
			M2 = m2; 
			M3 = m3;
			myu1 = my1;
			myu2 = my2; 
			myu3 = my3;
			force = f;
			g = 10;
			
			if (!((myu1 > 0 && myu1 <= 0.5) && (myu2 > 0 && myu2 <= 0.5) && (myu3 > 0 && myu3 <= 0.5)))
				System.out.println("myus are > 0 and <= 0.5 ");

			if (!(force >= -300 && force <= 300))
				System.out.println("force should be >= -300 and <= 300 ");

			if (force < 0)
				direction = false;
			else
				direction = true;
		}

	public 	double m1Acceleration(){
			double m1Acceleration = (force - myu1*(M1.getMass()*g + M2.getMass()*g) - M2.getMass()*myu2*g) / M1.getMass();
			if (m1Acceleration < 0)
				return 0;
			    return m1Acceleration;
		} 
  
	public	double getm2Accel(){
			double friction = -(M2.getMass()*myu2*g);

			double frictionOnM2 = friction;

			if (force == 0)
				frictionOnM2 = 0;

			
			double Xforce = M1.getAccel()*M3.getMass(); //the force that acts on M3 from M1, when the object is moving
			double mrAccel = (M3.getMass()*g - Xforce * myu3 - frictionOnM2 + friction) / (M2.getMass() + M3.getMass());

			if (mrAccel < 0 && force == 0)
				return 0;
			System.out.println(Xforce+" Force"); 
			System.out.println(mrAccel+"Accel"); 
			return mrAccel;
			
		}
		
		
		void action(){
			
			M1.setAcceleration(m1Acceleration());
			M2.setAcceleration(getm2Accel());
			M3.setAcceleration(getm2Accel());
			
			double t = 0;
			double dt = 0.01; //let's take it small to gain more data

			while (t < 5){
				
				double dxOfm1 = ((M1.getVelocity()*dt) + M1.getAccel() * ((dt = 0.001*dt) / 2));
				double dvOfm1 = M1.getAccel()*dt;
				M1.setVelocity(M1.getVelocity() + dvOfm1);
				

				double dxofm2 = ((M2.getVelocity()*dt) + M2.getAccel() *((dt = 0.001*dt) / 2));
				double dvOfm2 = M2.getAccel()*dt;
				M2.setVelocity(M2.getVelocity() + dvOfm2);

				double dyOfm3 = dxofm2;
				double dwOfm3 = dvOfm2;
				M3.setVelocity(M3.getVelocity() + dwOfm3);

				M1.setxCoordinate(M1.getxCoordinate() + dxOfm1);
				M3.setxCoordinate(M1.getxCoordinate());

				M2.setxCoordinate(M2.getxCoordinate() + dxofm2);
				if (M2.getxCoordinate() < M1.getxCoordinate() - 10)
					M2.setxCoordinate(M1.getxCoordinate() - 10);	
				else if (M2.getxCoordinate() > M1.getxCoordinate())
					M2.setxCoordinate(M1.getxCoordinate());	

				if (M2.getAccel() > 0)
					dyOfm3 = -dyOfm3;

				M3.setyCoordinate(M3.getyCoordinate() + dyOfm3);

				if (M3.getyCoordinate() < 5)
					M3.setyCoordinate(5);	
				else if (M3.getyCoordinate() > 15)
					
					M3.setyCoordinate(15);	
				
				t += dt = 0.001;
			}
			System.out.println(M1.getyCoordinate());
			System.out.println(M1.getxCoordinate());
			System.out.println(M2.getyCoordinate());
			System.out.println(M2.getxCoordinate());

		}
		
		
public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("value for the myu1, myus are > 0 and <= 0.5");
        double my1 = scan.nextFloat();
        
        System.out.println("value for the myu2");
        double my2 = scan.nextFloat();
        System.out.println("value for the myu3");
        double my3 = scan.nextFloat();
        
        System.out.println("value for the x1");
        double x1 = scan.nextFloat();
        System.out.println("value for the y1");
        double m1 = scan.nextFloat();
        System.out.println("value for the m1");
        double y1 = scan.nextFloat();
        
        System.out.println("value for the x2");
        double x2 = scan.nextFloat();
        System.out.println("value for the y2");
        double y2 = scan.nextFloat();
        System.out.println("value for the m2");
        double m2 = scan.nextFloat();
        
        
        System.out.println("value for the x3");
        double x3 = scan.nextFloat();
        System.out.println("value for the y3");
        double y3 = scan.nextFloat();
        System.out.println("value for the m3");
        double m3 = scan.nextFloat();
        
        System.out.println("value for the f");
        double f = scan.nextFloat();
        
      
        project2 test = new project2(my1, my2, my3, new Mass(x1, y1, m1), new Mass(x2, y2, m2), new Mass(x3, y3, m3), f);
        test.action();
    }
		
}
