package main;

import java.util.Scanner;

public class ServerApplication {

	@SuppressWarnings("resource")
	static String input() {
		return new Scanner(System.in).next();
	}

	static void show(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		show("1 - Server");
		String app = input();
		if (app.contentEquals("1")) {
			show("server start");
			UDPServer server = new UDPServer();
			server.run();
		}
	}
}
