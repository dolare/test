package consulting_assignment;

public class Point {
	double x;
	double y;
	double z;
	

	public Point(double x,double y,double z){
		this.x = x;
		this.y = y;
		this.z = z;	
	}
	
	public  void setPoint(double x,double y,double z){
		this.x = x;
		this.y = y;
		this.z = z;	
	}
	
	public double getDistance(){
		return (x*x + y*y + z*z);
	}
	
	
	
	public static void main(String[] args){
		Point p1 = new Point(1,2,3);
		System.out.println(p1.getDistance());
		p1.setPoint(3, 4, 5);
		System.out.println(p1.getDistance());
	}
}




