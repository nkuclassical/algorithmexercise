import java.util.Hashtable;


public class spots {
	protected int type;
	Hashtable<Integer, vehicle> hash=new Hashtable();
	int id;
	public spots()
	{
		id=0;
	}
	public vehicle redeemcar(int id)
	{
		if(hash.containsKey(id))
		{
			vehicle back=hash.get(id);
			hash.remove(id);
			return back;
		}
		else return null;
	}
	public int stopcar(vehicle car)
	{
		id++;
		hash.put(id, car);
		
		return id;
	}
}

