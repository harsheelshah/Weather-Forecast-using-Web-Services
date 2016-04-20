import org.bson.types.ObjectId;


public class MyWSDLModel {
	
	
    private String id;
	private String name;
	private String time;
	private String method;
	
	
	
	public MyWSDLModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyWSDLModel(String id, String name, String time, String method) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.method = method;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
}
