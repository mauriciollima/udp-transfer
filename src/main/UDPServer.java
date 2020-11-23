package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer extends Thread {

	private DatagramSocket socket;
	private boolean running;
	private byte[] buf = new byte[300];

	public UDPServer() {
		try {
			socket = new DatagramSocket(4445);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		running = true;
		while (running) {
			sleep(1000);
			
			//recebe do client
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			receive(packet);
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			packet = new DatagramPacket(buf, buf.length, address, port);
			
			
			String received = new String(packet.getData(), 0, packet.getLength());
			System.out.println("message from client: " +received);
//			sleep(1000);
			if (received.equals("end")) {
				running = false;
				continue;
			}
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		socket.close();
	}
	
	public void sleep(int s) {
//		System.out.println("sleeping "+s);
		try {
			Thread.sleep(s);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public void receive(DatagramPacket packet) {
//		System.out.println("receive " +packet);
		try {
			socket.receive(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}