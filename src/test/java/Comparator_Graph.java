

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class Comparator_Graph
 */
@WebServlet("/Comparator_Graph")
public class Comparator_Graph extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comparator_Graph() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   
			request.getRequestDispatcher("Graph.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String project1 = request.getParameter("project1");
		String project2 = request.getParameter("project2");
		
		System.out.println(project1+ " "+project2);
	
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
            
            //reposetimeList.add((String)found.get("res_time"));
            
            //System.out.println(id+" "+name+ " "+time+" "+method);
            
            MyWSDLModel model= new MyWSDLModel();
            
            model.setId(id);
            model.setMethod(method);
            model.setName(name);
            model.setTime(time);

            savePlayers.add(model);  
            
            
        	}
        
          
        
        for (MyWSDLModel m : savePlayers){
        	if(m.getId().equals(project1)){
        		request.setAttribute("project1", m.getTime());
        		request.setAttribute("name1", m.getId());
        		System.out.println( m.getTime()+" "+m.getId());
        	}
        }
        
        for (MyWSDLModel m : savePlayers){
        	if(m.getId().equals(project2)){
        		request.setAttribute("project2", m.getTime());
        		request.setAttribute("name2", m.getId());
        		System.out.println( m.getTime()+  " "+ m.getId());
        	}
        }
        
        doGet(request, response);
		
	}

}
