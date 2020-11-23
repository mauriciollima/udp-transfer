package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

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

	public Boolean connect() {
		try {
			//conecta localhost:4999
			DatagramSocket socket = new DatagramSocket(4999);
			InetAddress ipAddress = InetAddress.getByName("localhost");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Boolean.TRUE;
	}

	public String send(DataInfo message) {
		// pegando os dados(byte) da mensagem
		buf = message.getData();

		// construção do pacote
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);

		String response = "";

		try {

			// envia para o server
			socket.send(packet);
			packet = new DatagramPacket(buf, buf.length);

			// recebe response do server
			socket.receive(packet);

			response = new String(packet.getData(), 0, packet.getLength());
			return response;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	public void slowStart() {

	}
	
	public List<DataInfo> buildPackets(byte[] data) {
		List<DataInfo> packets = new ArrayList<DataInfo>();

		int maxBytes = 300;
		
		
		return null;
	}

	public void close() {
		socket.close();
	}
	
    public long getCRC(byte[] data) {
        CRC32 crc = new CRC32();
        crc.update(data);
        return crc.getValue();
    }

}