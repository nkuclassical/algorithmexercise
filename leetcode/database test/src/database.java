import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

class employee
{
int a;	
}
public class database {
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet = null;
    
    public void readDataBase()
    {
    	try{
    		//Class.forName("com.mysql.jdbc.Driver");
    		connect=DriverManager.getConnection("jdbc:mysql://localhost/photograph?"+"user=root&password=q1111111");
    		statement=connect.createStatement();
    		resultSet=statement.executeQuery("select * from photographerlist");
    		writeResultSet(resultSet);
    		/*preparedStatement=(PreparedStatement) connect.prepareStatement("insert into orders values (20,3,2,100);");
    		preparedStatement.execute();
    		System.out.println("....................");
    		
    		resultSet=statement.executeQuery("select * from orders");
    		writeResultSet(resultSet);
    		//preparedStatement=(PreparedStatement) connect.prepareStatement("select * from mysqlpractice.orders");
    		//resultSet=preparedStatement.executeQuery();
    		System.out.println("....................");
    		writeResultSet(resultSet);
    		preparedStatement=(PreparedStatement) connect.prepareStatement("delete from orders where orderid=20;");
    		preparedStatement.execute();
    		
    		resultSet=statement.executeQuery("select * from orders");
    		writeResultSet(resultSet);*/
    	}
    	catch(Exception e)
    	{
    		
    	}
    	finally{}
    }
    private void writeMetaData(ResultSet resultSet)throws SQLException
    {
    	System.out.println("The colums in the tables are: ");
    	System.out.println("Table: "+resultSet.getMetaData().getColumnName(1));
    	for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++)
    	{
    		System.out.println("Column "+i+" "+resultSet.getMetaData().getColumnName(i));
    	}
    }
    private void writeResultSet(ResultSet resultSet) throws SQLException
    {
    	
    	 while(resultSet.next())
         {
             
             String name=resultSet.getString("name");
             String id=resultSet.getString("id");
             String sexual=resultSet.getString("sexual");
             System.out.println("Name: "+name);
             System.out.println("ID: "+id);
             System.out.println("Sexual: "+sexual);
             
         }
    }    
    private void close()
    {
    	
    }
    private void close(Closeable c)
    {
    	try
    	{
    		if(c!=null)
    		{
    			c.close();
    		}
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
	public static void main(String[] args) {

        database d=new database();
        
       	d.readDataBase();
       	employee test=new employee();
       	test.a=1;
       	System.out.println(test.a);
        
    }

}
