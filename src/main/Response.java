package main;

public class Response {
	
	private DataInfo message;
	
	public Response(DataInfo message) {
		this.message = message;
	}
	
	public DataInfo getMessage() {
		return message;
	}

}
