package main;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UDPService {

	UDPServer server;
	UDPClient client;
	Message message;

	public UDPService(UDPServer server, UDPClient client) {
		this.server = server;
		this.client = client;
	}
	
	public String startServer() {
		return "server start";
	}

	public String connect() {
		return "server connect";
	}
	
	public String disconnect() {
		return "server disconnect";
	}
	
	public String sendFile() {
		return "send file";
	}
	
	public String pickFile() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("selected file: " + chooser.getSelectedFile().getPath());
			return chooser.getSelectedFile().getPath();
		}
		return null;
	}

}
