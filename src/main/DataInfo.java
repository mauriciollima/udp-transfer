package main;

public class DataInfo {
	
	private int sequence;
	private byte[] data;
	long CRC;

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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public long getCRC() {
		return CRC;
	}

	public void setCRC(long cRC) {
		CRC = cRC;
	}
	

}
