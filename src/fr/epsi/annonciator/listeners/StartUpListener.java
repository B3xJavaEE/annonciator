package fr.epsi.annonciator.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class StartUpListener implements ServletContextListener {
	
	private static final Logger logger = LogManager.getLogger(StartUpListener.class);	
	private final static String version = "0.1";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.error("Demarrage de l'application");
		
	}

}

/*
package fr.epsi.SecondProjet.listeners;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


import fr.epsi.SecondProjet.beans.Contact;


@WebListener
public class StartUpListener implements ServletContextListener {
	
	private static final Logger Logger = LogManager.getLogger(StartUpListener.class);	
	private final static String version = "0.1";
	private static List<Contact> listOfContacts;
	
    /**
     * Default constructor.
    public StartUpListener() {
        // TODO Auto-generated constructor stub	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
    public void contextInitialized(ServletContextEvent context)  {
        // TODO Auto-generated method stub
    	Logger.error("Demarage de l'application");
    	context.getServletContext().setAttribute("version", version);
    	
    	/*
    	listOfContacts = getListOfDefaultContacts();
    	context.getServletContext().setAttribute("contacts", listOfContacts);
    	
    	//Initializing MBean
    	MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    	ObjectName name = null;

    	try {
    		//Contact
    		name = new ObjectName("fr.epsi.secondProjet.jmx:type=ContactMbean");
    		fr.epsi.SecondProjet.jmx.Contact mbean = new fr.epsi.SecondProjet.jmx.Contact();

    		mbs.registerMBean(mbean, name);
    		
    		//Maintenance
    		name = new ObjectName("fr.epsi.secondProjet.jmx:type=MaintenanceModeMBean");
    		fr.epsi.SecondProjet.jmx.MaintenanceModeMBean mbean_maintenance = new fr.epsi.SecondProjet.jmx.MaintenanceMode();
    		mbs.registerMBean(mbean_maintenance, name);	
    	} catch (MalformedObjectNameException e) {
    		e.printStackTrace();
    	} catch (NullPointerException e) {
    		e.printStackTrace();
    	} catch (InstanceAlreadyExistsException e) {
    		e.printStackTrace();
    	} catch (MBeanRegistrationException e) {
    		e.printStackTrace();
    	} catch (NotCompliantMBeanException e) {
    		e.printStackTrace();
    	}
    	
    	//Initialisation de la bdd
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			//Connection con = DriverManager.getConnection("jdbc:hsqldb;hsql://localhost:9003","SA","");
			Connection con = (Connection) DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
			Logger.info("connection : " + con);
			
			listOfContacts = new ArrayList<Contact>();
			ResultSet results = null;
			String requete = "SELECT * FROM CONTACTS";
			
			Statement stmt = con.createStatement();
			results = stmt.executeQuery(requete);
			
			Logger.error("results : " + results);
			
			while(results.next()) {
				Contact contact = new Contact();
				contact.setId(Integer.toString(results.getInt(1)));
				contact.setName(results.getString(2));
				
				listOfContacts.add(contact);
			}
			
			Logger.error("list : " + listOfContacts);
			con.close();
		} catch (ClassNotFoundException e){
			Logger.error("class not found : " + e.getMessage());
		} catch (SQLException e) {
			Logger.error("sql error : " + e.getMessage());
		}
		
		context.getServletContext().setAttribute("contacts", listOfContacts);
    }
    
    private static List<Contact> getListOfDefaultContacts() {
    	List<Contact> listOfContacts = new ArrayList<Contact>() {{
    		add(new Contact("0","Bouchet",new Date(1994,01,25)));
    		add(new Contact("1","Bouchet_Bis",new Date(1994,01,25)));
    		add(new Contact("2","Loquet",new Date(1995,03,13)));
    	}};
    	
    	return listOfContacts;
    }
        
    static public String getVersion(){
    	return version;
    }
    
    public static List<Contact> getListOfContact(){
    	return listOfContacts;
    }
    
    public static void setListOfContact(List<Contact> list){
    	listOfContacts = list;
    }
}
*/