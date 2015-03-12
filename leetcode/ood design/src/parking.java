
public class parking {
	public static void main(String[]args)
	{
		spots spot=new spots();
		vehicle newcome=new vehicle();
		spot=new bigspot();
		newcome=new bigvehicle();
		vehicle newcome1=new mediumvehicle();
		if(newcome.type>spot.type)
		{
			System.out.println("The car is too big!");
		}
		else
		{
			System.out.println("Success to park it!");
			newcome.parkingid=spot.stopcar(newcome);
			newcome1.parkingid=spot.stopcar(newcome1);
		}
		

		vehicle back=spot.redeemcar(newcome1.parkingid);
		if(back!=null)
		{
			System.out.println("Get it! car id is "+back.parkingid);
		}
		else System.out.println("Didn't find the car");
	}
}
