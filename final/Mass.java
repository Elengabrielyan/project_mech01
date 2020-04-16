
public class Mass{
	private double xCoordinate;
	private double yCoordinate;
	private double velocity;
	private double accel;
	private double mass;
	
	public Mass(double x, double y, double mass){
		if(!(mass > 0 && mass <= 10))
			System.out.print(" should be bigger than 0 and smaller= 10" );

		xCoordinate = x;
		yCoordinate = y;
		this.mass = mass;
	}  

//setters
	void setxCoordinate(double x){
		xCoordinate = x;
	}

	void setyCoordinate(double y){
		yCoordinate = y;
	}

	void setAcceleration(double a){
		accel = a;
	}

	void setVelocity(double v){
		velocity = v;
	}

//getters

	double getxCoordinate(){
		return xCoordinate;
	}

	double getyCoordinate(){
		return yCoordinate;
	}

	double getMass(){
		return mass;
	}

	public double getAccel(){
		return this.accel;
	}

	double getVelocity(){
		return velocity;
	}
	
	public Mass(Mass m){
		xCoordinate = m.getxCoordinate();
		yCoordinate = m.getyCoordinate();
		mass = m.getMass();
		velocity = m.getVelocity();
		accel = m.getAccel();
	}
	
};