package main;

public class DataInfo {
	
	private int sequence;
	private String message;
	private byte[] data;

	public DataInfo(byte[] data, int sequence) {
		this.sequence = sequence;
		this.data = data;
	}
	
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
