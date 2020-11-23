package main;

public class Message {
	
	public static int sequence = 0;
	private int ack;
	byte[] data;
	
	public Message() {
		this.sequence = sequence + 1;
		this.ack = sequence;
	}
	
	public Message(byte[] data) {
		this.sequence = sequence + 1;
		this.ack = sequence;
		this.data = data;
	}

}
