



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

import eu.impact_project.iif.ws.generic.SoapInput;
import eu.impact_project.iif.ws.generic.SoapOperation;
import eu.impact_project.iif.ws.generic.SoapService;

/**
 * Servlet implementation class Login2
 */
@WebServlet("/MyWSDLmethod")
public class MyWSDLmethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyWSDLmethod() {
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
		
		
		
		
		
		String method = request.getParameter("method");
		System.out.println("------>"+method);
		HttpSession session1=request.getSession();  
		String WSDLurl=(String) session1.getAttribute("WSDLurl");
		session1.setAttribute("method", method);
		System.out.println(WSDLurl);
		
		String wsdlName=(String) session1.getAttribute("wsdlName");
		//session1.setAttribute("wsdlName", wsdlName);
		System.out.println("name,,,,,,,,,,,,,,,dfdf");
		System.out.println(wsdlName);
		
		List<String> inputs=new ArrayList<String>();
		
		if(WSDLurl!=null){
		
				SoapService service = new SoapService(WSDLurl);
				for(SoapOperation op : service.getOperations()) {
					
					
					
					if(op.getName().equals(method)){
						System.out.println("inside if");
						for (SoapInput in : op.getInputs()) {
							inputs.add(in.getName());
							System.out.println(in.getName());
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
		
	request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		// iterate through all operations and inputs
		
		
		
	}

		
	

