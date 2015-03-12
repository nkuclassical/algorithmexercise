import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;


/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
	

public class Solution {
   /* Stack<TreeNode>s=new Stack;
    public Solution(TreeNode root) {
        while(root!=null)
        {
        	s.push(root);
        	root=root.left;
        }
    }

    
    public boolean hasNext() {
        return (!s.isEmpty());
    }

    
    public int next() {
        TreeNode current=s.pop();
        TreeNode currentvalue=current;
        current=current.right;
        while(current!=null)
        {
        	s.push(current);
        	current=current.left;
        }
        return currentvalue.val;
    }
    public static void main(String[]args)
    {
    	//TreeNode*root=new 
    	
    	String s="a b c d ";
    	//int i=0;
    	for(int i=0;i<15;i++)
    		System.out.println(s.charAt(i));
    }
}*/

class ParkingLot 
{
    Vector<ParkingSpace> vacantParkingSpaces = null;
    Vector<ParkingSpace> fullParkingSpaces = null;

    int parkingSpaceCount = 0;

    boolean isFull;
    boolean isEmpty;

    ParkingSpace findNearestVacant(ParkingType type)
    {
        Iterator<ParkingSpace> itr = vacantParkingSpaces.iterator();

        while(itr.hasNext())
        {
            ParkingSpace parkingSpace = itr.next();

            if(parkingSpace.parkingType == type)
            {
                return parkingSpace;
            }
        }
        return null;
    }

    void parkVehicle(ParkingType type, Vehicle vehicle)
    {
        if(!isFull())
        {
            ParkingSpace parkingSpace = findNearestVacant(type);

            if(parkingSpace != null)
            {
                parkingSpace.vehicle = vehicle;
                parkingSpace.isVacant = false;

                vacantParkingSpaces.remove(parkingSpace);
                fullParkingSpaces.add(parkingSpace);

                if(fullParkingSpaces.size() == parkingSpaceCount)
                    isFull = true;

                isEmpty = false;
            }
        }
    }

    void releaseVehicle(Vehicle vehicle)
    {
        if(!isEmpty())
        {
            Iterator<ParkingSpace> itr = fullParkingSpaces.iterator();

            while(itr.hasNext())
            {
                ParkingSpace parkingSpace = itr.next();

                if(parkingSpace.vehicle.equals(vehicle))
                {
                    fullParkingSpaces.remove(parkingSpace);
                    vacantParkingSpaces.add(parkingSpace);

                    parkingSpace.isVacant = true;
                    parkingSpace.vehicle = null;

                    if(vacantParkingSpaces.size() == parkingSpaceCount)
                        isEmpty = true;

                    isFull = false;
                }
            }
        }
    }

    boolean isFull()
    {
        return isFull;
    }

    boolean isEmpty()
    {
        return isEmpty;
    }
}

class ParkingSpace 
{
    boolean isVacant;
    Vehicle vehicle;
    ParkingType parkingType;
    int distance;
}

class Vehicle 
{
    int num;
}

enum ParkingType
{
    REGULAR,
    HANDICAPPED,
    COMPACT,
    MAX_PARKING_TYPE,
}
