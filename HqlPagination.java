package HQLPagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.MavenProject2.Address;

public class HqlPagination 
{

	public static void main(String[] args)
	{
	SessionFactory factory =new Configuration().configure().buildSessionFactory();	
	Session s = factory.openSession();
	
	Query query = s.createQuery(" from Address");
	
//	implement pagging
	
	query.setFirstResult(0);
	
	query.setMaxResults(1);
	
	List<Address> list = query.list();
	
	for(Address st : list)
	{
		System.out.println(st.getCity()+ " : " + st.getAddressId() + " : " + st.getStreet());
	}
	
	s.close();
	factory.close();
	
	}
}
