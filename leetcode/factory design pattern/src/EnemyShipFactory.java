
public class EnemyShipFactory {
	public EnemyShip shiptype(String newship)
	{
		EnemyShip returntype=null;
		
		if(newship.equals("B"))
		{
			returntype=new BigUFOEnemyShip();
		}
		else if(newship.equals("U"))
		{
			returntype= new UFOEnemyShip();
		}
		else if(newship.equals("R"))
		{
			returntype= new RocketEnemyShip();
		}
		else returntype= null;
		returntype.displayEnemyShip();
		return returntype;
	}
}
