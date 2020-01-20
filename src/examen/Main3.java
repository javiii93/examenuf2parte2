package examen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el nombre, primer apellido, segundo apellido");
		System.out.println("Separado por espacios");
		System.out.println("EJEMPLO: Javier Linde Maldonado");
		String nombre = sc.nextLine();
		String[] separarNombre = nombre.split(" ");
		mostrarImporteTotalSeguro(separarNombre[0], separarNombre[1], separarNombre[2]);
		// mostrarImporteTotalSeguro("JOAQUIM", "SORIA", "SORIA");
		sc.close();
	}

	public static void mostrarImporteTotalSeguro(String nom, String cognom1, String cognom2) {
		Connection.conexionJDBC();
		int idSeguro = 0, totalAsistencias = 0;
		float importe = 0f;

		try {
			String idSeguroQuery = "select idSeguro from seguro where nombre='" + nom + "' and ape1='" + cognom1
					+ "' and ape2='" + cognom2 + "';";

			Statement stmnt;
			Statement stmnt1;

			stmnt = Connection.connection.createStatement();
			ResultSet rsst = stmnt.executeQuery(idSeguroQuery);
			if (rsst.next()) {
				idSeguro = rsst.getInt("idSeguro");
				// System.out.println(idSeguro);
			}
			stmnt1 = Connection.connection.createStatement();
			String sumaPrecio = "select * from asistenciamedica where IdSeguro=" + idSeguro + ";";
			ResultSet rsst2 = stmnt1.executeQuery(sumaPrecio);
			if (rsst2.next()) {
				totalAsistencias++;
				importe = importe + rsst2.getFloat("importe");
			}
			System.out.println("Nom de l assegurat: " + nom + " " + cognom1 + " " + cognom2);
			System.out.println("Total assistencia medica:" + totalAsistencias);
			System.out.println("Import: " + importe + " euros");

			Connection.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
