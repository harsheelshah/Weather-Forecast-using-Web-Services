import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.UnknownHostException;
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

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import eu.impact_project.iif.ws.generic.SoapInput;
import eu.impact_project.iif.ws.generic.SoapOperation;
import eu.impact_project.iif.ws.generic.SoapOutput;
import eu.impact_project.iif.ws.generic.SoapService;

import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;
/**
 * Servlet implementation class Login2
 */
@WebServlet("/MyWSDLinput")
public class MyWSDLinput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyWSDLinput() {
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
		
	//	response.sendRedirect("Home.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		long lStartTime = new Date().getTime(); // start time

		
		//String method = request.getParameter("method");
		//System.out.println("------>"+method);
		SoapService service=null;
		HttpSession session1=request.getSession();  
		String WSDLurl=(String) session1.getAttribute("WSDLurl");
		String method=(String) session1.getAttribute("method");
		String wsdlName=(String) session1.getAttribute("wsdlName");
		System.out.println("url ka name");
		System.out.println(wsdlName);

		System.out.println(WSDLurl);
		
		List<String> inputs=new ArrayList<String>();
		
		if(WSDLurl!=null){
		
				 service = new SoapService(WSDLurl);
				for(SoapOperation op : service.getOperations()) {
					
					
					
					if(op.getName().equals(method)){
						System.out.println("inside if");
						for (SoapInput in : op.getInputs()) {
							inputs.add(in.getName());
							
						}
						
					}
					
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
		
		getServletContext().setAttribute("inputs", inputs);
		
		
		SoapOperation op1 = service.getOperation(method);
		
		for(String input:inputs){
		op1.getInput(input).setValue(request.getParameter(input));
		}
		// get the results
		
		
		String save = request.getParameter("save");
		if(save!=null){
		List<SoapOutput> outs = op1.execute();
		
		System.out.println(op1.getResponse());
		
		for(SoapOutput output:outs){
			
		}
				
		getServletContext().setAttribute("output", outs);
		}
		
		long lEndTime = new Date().getTime(); // end time
		
		long difference = lEndTime - lStartTime; // check different

		session1.setAttribute("diff", difference);
		
		//------------------------ db part start ------------------//
		
		//String save = request.getParameter("save");

		boolean flag=false;
		if(save!=null){
			flag=true;
		Mongo mongo = new Mongo("localhost", 27017);
		
		DB db = mongo.getDB("webservices");
		
		
		DBCollection collection = db.getCollection("dummyColl");

		System.out.println("JSON parse example...");
		
		String json = "{'_id':'"+wsdlName+"', 'ws_name' : '"+WSDLurl+"','res_time' : '"+difference+"'," +
		  "'method_name' : '"+method+"' }";

		DBObject dbObject = (DBObject)JSON.parse(json);
				
		collection.insert(dbObject);

		DBCursor cursorDocJSON = collection.find();
		while (cursorDocJSON.hasNext()) {
			System.out.println(cursorDocJSON.next());
		}

		//collection.remove(new BasicDBObject());
				
	    
		}

		request.setAttribute("flag", flag);
		
		//------------------------- db part end -------------------//
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		// iterate through all operations and inputs
		
		
		
	}

		
	

