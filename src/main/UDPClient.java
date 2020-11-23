package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class UDPClient {
	private DatagramSocket socket;
	private InetAddress address;
	private byte[] buf;
	static List<DataInfo> messages = new ArrayList<DataInfo>();

	public UDPClient() {
		try {
			socket = new DatagramSocket();
			address = InetAddress.getByName("localhost");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean connect() {
		try {
			DatagramSocket socket = new DatagramSocket(4999);
			InetAddress ipAddress = InetAddress.getByName("localhost");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Boolean.TRUE;
	}

	public String send(DataInfo message) {
		
		//pegando os dados(byte) da mensagem
		buf = message.getData();
		
		//construção do pacote
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
		
		
		String received = "";
		try {
			
			//envia para o server
			socket.send(packet);
			packet = new DatagramPacket(buf, buf.length);
			
			//recebe response do server
			socket.receive(packet);
			
			received = new String(packet.getData(), 0, packet.getLength());
			return received;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return received;
	}

	public void close() {
		socket.close();
	}
}