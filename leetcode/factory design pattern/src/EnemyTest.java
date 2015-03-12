import java.util.Scanner;
public class EnemyTest {
	public static void main(String[]args)
	{
		Scanner in=new Scanner(System.in);
		String enemshiptype=null;
		EnemyShip newship=null;
		EnemyShipFactory esf=new EnemyShipFactory();
		System.out.println("Type in the Enemy type(B/R/U)");
		if(in.hasNext())
		{
			enemshiptype=in.nextLine();
			
			newship=esf.shiptype(enemshiptype);
		}
		
		if(esf!=null)
		{
			doStuffEnemy(newship);
		}
		else 
		{
			
			System.out.println("Retype in the type of Enemy!");
		}
		
	}
	public static void doStuffEnemy(EnemyShip newship)
	{
		newship.displayEnemyShip();
		newship.followHeroShip();
		
	}
}
