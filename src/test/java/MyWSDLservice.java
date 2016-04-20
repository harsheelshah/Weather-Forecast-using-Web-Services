



import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import eu.impact_project.iif.ws.generic.SoapInput;
import eu.impact_project.iif.ws.generic.SoapOperation;
import eu.impact_project.iif.ws.generic.SoapService;

/**
 * Servlet implementation class Login2
 */
@WebServlet("/MyWSDLservice")
public class MyWSDLservice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyWSDLservice() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {

		super.init(config);
			
		
    	
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("index.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		System.out.println(request.getParameter("wsdlURL"));
		
		String WSDLurl = request.getParameter("wsdlURL");
		String wsdlName = request.getParameter("wsdlName");
		
		HttpSession session1=request.getSession();  
		session1.setAttribute("WSDLurl", WSDLurl);
		session1.setAttribute("wsdlName", wsdlName);
		List<String> methods=new ArrayList<String>();
		
		if(WSDLurl!=null){
		
				SoapService service = new SoapService(WSDLurl);
				for(SoapOperation op : service.getOperations()) {
					System.out.println("Operation:");
					System.out.println(op.getName());
					methods.add(op.getName());
					/*System.out.println("Operation Documentation:");
					System.out.println(op.getDocumentation());
					
					System.out.println("Default request message:");
					System.out.println(op.getRequest());*/
					
					/*System.out.println("Input fields:");
					for (SoapInput in : op.getInputs()) {
						System.out.println(in.getName());*/
						//System.out.println(in.);
						/*System.out.println(in.getDocumentation());
						System.out.println(in.getDefaultValue());
						System.out.println(in.isMultiValued());*/
						
					}
					System.out.println("-------------------------------------------");

				}
		getServletContext().setAttribute("wsdlURL", WSDLurl);
		
		
		Mongo mongo = new Mongo("localhost", 27017);

		DB db = mongo.getDB("webservices");
		
		DBCollection collection = db.getCollection("dummyColl");

        ArrayList<MyWSDLModel> savePlayers = new ArrayList<MyWSDLModel>();
        DBCursor cursor = collection.find();
        //DBObject found = null;
        
        int i=1;
        //System.out.println(cursor.count());
        //System.out.println(cursor.length());
        
        
        while(cursor.hasNext() ){
        	//System.out.println("inset record :"+i);
        	//System.out.println(cursor.next());
            
        	DBObject found = cursor.next();  
        	
        	
        	//for ()
        	String id = (String)found.get("_id");
            String name = (String)found.get("ws_name");
            String time = (String)found.get("res_time");
            String method = (String)found.get("method_name");
            
            System.out.println(id+" "+name+ " "+time+" "+method);
            
            MyWSDLModel model= new MyWSDLModel();
            
            model.setId(id);
            model.setMethod(method);
            model.setName(name);
            model.setTime(time);

            savePlayers.add(model);  
        	}
            /*MyWSDLModel player = new MyWSDLModel(id,name,time,method);
            System.out.println(player.getName());
            */
            
        	//i++;
        
        
        
        for (MyWSDLModel m : savePlayers){
        	System.out.println(m.getName());
        }
   
        request.getSession().setAttribute("project", savePlayers);
		
		
		getServletContext().setAttribute("methods", methods);
		
	request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		// iterate through all operations and inputs
		
		
		
	}

		
	

