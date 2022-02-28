import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Estadistica F1");
		String login="", password="", check;
		System.out.println("Introduzca su login:");
		login = sc.next();
		System.out.println("Introduzca su contraseña:");
		password = sc.next();
		check = login(login, password);
		if(check.equals("error")) {
			System.out.println("Login o contraseña incorrecto");
		}else {
			menu(check);
		}
		sc.close();
	}
	
	public static String login(String login, String password) {
		String check="error";
		if(login.equals("admin")&&password.equals("1234")) {
			System.out.println("Hola admin");
			check="admin";
		}else if(login.equals("user1")&&password.equals("psswd1")){
			System.out.println("Hola " + login);
			check="user";
		}
		return check;
	}
	
	public static void menu(String check) {
		int option=0;
		System.out.println("Eliga opcion de menu(introducir numero):");
		if(check=="admin") {
			System.out.println("1)Option 1\n2)Option 2");
		try {
			option = sc.nextInt();
			if((option>0)&&(option<3)) {
				
			}else {
				System.out.println("No existe opcion");
				System.out.println("Introduzca de nuevo:");
				option = sc.nextInt();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No existe opcion");
			System.out.println("Introduzca de nuevo:");
			option = sc.nextInt();
		}
		switch(option) {
			case 1:
				System.out.println("Has elegido menu admin 1");
			break;
			case 2:
				System.out.println("Has elegido menu admin 2");
			break;
		}
		}else if(check=="user") {
			System.out.println("1)Option 1\n2)Option 2");
			try {
				option = sc.nextInt();
				if((option>0)&&(option<3)) {
					
				}else {
					System.out.println("No existe opcion");
					System.out.println("Introduzca de nuevo:");
					option = sc.nextInt();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No existe opcion");
				System.out.println("Introduzca de nuevo:");
				option = sc.nextInt();
			}
			switch(option) {
			case 1:
				System.out.println("Has elegido menu user 1");
			break;
			case 2:
				System.out.println("Has elegido menu user 2");
			break;
			}
		}
	}
}