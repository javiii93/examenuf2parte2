package examen;

public interface DatosConexion {
	String db = "seguros";
	String url = "jdbc:mysql://localhost/"+db+"?useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user = "root", psswd = "";

}
