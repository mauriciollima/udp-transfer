package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	private DatagramSocket socket;
	private InetAddress address;
	private byte[] buf;

	public UDPClient() {
		try {
			socket = new DatagramSocket();
			address = InetAddress.getByName("localhost");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String sendEcho(String msg) {
		buf = msg.getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
		String received = "";
		try {
			socket.send(packet);
			packet = new DatagramPacket(buf, buf.length);
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