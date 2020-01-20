package examen;

import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {

	public static void main(String[] args) {
		actualizarImporteDermatitisInfecciosa();

	}

	public static void actualizarImporteDermatitisInfecciosa() {
		Connection.conexionJDBC();
		String update = "UPDATE asistenciamedica SET importe= 6523.34 WHERE breveDescripcion ='Dermatitis infecciosa';";
		Statement stmnt;
		try {
			stmnt = Connection.connection.createStatement();
			stmnt.executeUpdate(update);
			System.out.println("importe de dermatitis infecciosa actualizado");
			Connection.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
//Actualitza l'import de l'assistència mèdica de la Dermatitis infecciosa a 6523,34. 
