

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * Servlet implementation class MyWSDLList
 */
@WebServlet("/MyWSDLList")
public class MyWSDLList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void init(ServletConfig config) throws ServletException {

		super.init(config);
		
	}


    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    		//response.sendRedirect("projectlist.jsp");
    		System.out.println("in get");
    		
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
       
            request.setAttribute("project", savePlayers);
    		
        	request.getRequestDispatcher("projectlist.jsp").forward(request, response);
        	
        	
	}

    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("delete");
		
		System.out.println(name);
		Mongo mongo = new Mongo("localhost", 27017);

		DB db = mongo.getDB("webservices");
		
		DBCollection collection = db.getCollection("dummyColl");

		
		BasicDBObject document = new BasicDBObject();
		document.put("_id", name);
		collection.remove(document);
		
		
		doGet(request, response);
		
	}

}
