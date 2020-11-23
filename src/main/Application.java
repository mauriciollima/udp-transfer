package main;

import java.util.Scanner;

public class Application {

	@SuppressWarnings("resource")
	static String input() {
		return new Scanner(System.in).next();
	}

	static void show(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		show("1 - Server");
		show("2 - Client");
		
		String app = input();

		if (app.contentEquals("1")) {
			show("Server");
			UDPServer server = new UDPServer();
			server.run();
		}

		if (app.contentEquals("2")) {
			show("Client");
			UDPClient client = new UDPClient();
			client.sendEcho("teste");
		}
	}
}
