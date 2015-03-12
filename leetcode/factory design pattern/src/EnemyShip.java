
public abstract class EnemyShip {
	private double Attack;
	private String Name;
	public String getname()
	{
		return Name;
	}
	public void setname(String newname)
	{
		Name=newname;
	}
	public double getattack()
	{
		return Attack;
	}
	public void setattack(double newattack)
	{
		Attack=newattack;
	}
	public void displayEnemyShip()
	{
		System.out.println("Name: "+Name+"\nAttack: "+Attack);
	}
	public void followHeroShip()
	{
		System.out.println(getname()+" is following the hero.");
	}
}
