

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * Servlet implementation class Graph
 */
@WebServlet("/Graph1")
public class Graph1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Mongo mongo = new Mongo("localhost", 27017);

		DB db = mongo.getDB("webservices");
		
		DBCollection collection = db.getCollection("dummyColl");

        ArrayList<MyWSDLModel> savePlayers = new ArrayList<MyWSDLModel>();
        DBCursor cursor = collection.find();
        //DBObject found = null;
        
        int i=1;
        //System.out.println(cursor.count());
        //System.out.println(cursor.length());
        
        List<String> reposetimeList=new ArrayList<String>();
        
        while(cursor.hasNext() ){
        	//System.out.println("inset record :"+i);
        	//System.out.println(cursor.next());
            
        	DBObject found = cursor.next();  
        	
        	
        	//for ()
        	String id = (String)found.get("_id");
            String name = (String)found.get("ws_name");
            String time = (String)found.get("res_time");
            String method = (String)found.get("method_name");
            
            reposetimeList.add((String)found.get("res_time"));
            
            System.out.println(id+" "+name+ " "+time+" "+method);
            
            MyWSDLModel model= new MyWSDLModel();
            
            model.setId(id);
            model.setMethod(method);
            model.setName(name);
            model.setTime(time);

            savePlayers.add(model);  
            
            
        	}
        
          
        
        for (MyWSDLModel m : savePlayers){
        	System.out.println(m.getName());
        }		
   
        
        
        request.setAttribute("project", savePlayers);
		
		
	//	getServletContext().setAttribute("methods", methods);
		
        
	request.getRequestDispatcher("Graph1.jsp").forward(request, response);
	
	
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		ServletContext context = getServletContext();
		//@SuppressWarnings("unchecked")
		List<MyWSDLModel> project = new ArrayList<MyWSDLModel>();
				
		project = 
		(List<MyWSDLModel>) request.getAttribute("project");
		
		System.out.println(project);
		for(MyWSDLModel m : project)
		{
			System.out.println(m.getId());
		}
		
   
		request.setAttribute("project", project);

		doGet(request, response);
	}

}
