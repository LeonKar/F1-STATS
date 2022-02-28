import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Estadistica F1");
		String login="", password="", check;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su login:");
		login = sc.next();
		System.out.println("Introduzca su contraseña:");
		password = sc.next();
		check = login(login, password);
		if(check.equals("error")) {
			System.out.println("Login o contraseña incorrecto");
		}
	}
	
	public static String login(String login, String password) {
		String check="error";
		if(login.equals("admin")&&password.equals("1234")) {
			System.out.println("Hola admin");
		}else if(login.equals("user1")&&password.equals("password1")){
			System.out.println("Hola " + login);
		}
		return check;
	}
}