package eu.impact_project.iif.ws.generic;

import java.util.List;

import eu.impact_project.iif.ws.generic.example.HelloImpl;

public class Test {
	
	/*public void setUp() throws Exception {
		// start the web service
		HelloImpl implementor = new HelloImpl();
		ServerStarter.startSoapServer(9001, "helloWorld", implementor);
		
		ServerStarter.startWebServer(9002);
	}
	*/
	
	
	public static void main(String[] args) throws Exception {
		
		/*HelloImpl implementor = new HelloImpl();
		ServerStarter.startSoapServer(9001, "helloWorld", implementor);
		
		ServerStarter.startWebServer(9002);*/
		
		

		
		// create service from a wsdl
		SoapService service = new SoapService("http://www.webservicex.com/globalweather.asmx?wsdl");
		
		// iterate through all operations and inputs
		for(SoapOperation op : service.getOperations()) {
			System.out.println("Operation:");
			System.out.println(op.getName());
			
			/*System.out.println("Operation Documentation:");
			System.out.println(op.getDocumentation());
			
			System.out.println("Default request message:");
			System.out.println(op.getRequest());*/
			
			System.out.println("Input fields:");
			for (SoapInput in : op.getInputs()) {
				System.out.println(in.getName());
				//System.out.println(in.);
				/*System.out.println(in.getDocumentation());
				System.out.println(in.getDefaultValue());
				System.out.println(in.isMultiValued());*/
				
			}
			System.out.println("-------------------------------------------");

		}
		
		// set an input value for a specific operation
		SoapOperation op1 = service.getOperation("GetCitiesByCountry");
		op1.getInput("CountryName").setValue("india");
		
		// get the results
		List<SoapOutput> outs = op1.execute();
	String outName = outs.get(0).getName();
		String outValue = outs.get(0).getValue();
		System.out.println("Output: ");
		System.out.println(outName + " : " + outValue);
		
		
		// get the soap request and response messages
		//System.out.println(op1.getRequest());
		//System.out.println(op1.getResponse());
		
		/*ServerStarter.stopAll();*/
	
		
		
	}
}


