package DbManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Registros;

public class Crud {

	private Dbconnection conn;
	private PreparedStatement preparedStatement;
	private ResultSet resultset;
	private String query;

	public Crud() {
		conn = new Dbconnection();
	}

	public void insertAll() {
	}

	public ArrayList<Registros> selectFacturasByNombre(String nombre) {
		try {
			ArrayList<Registros> registros = new ArrayList<>();
			query = "SELECT * FROM registros WHERE nombre like ?";
			preparedStatement = conn.getCon().prepareStatement(query);
			preparedStatement.setString(1,"%"+ nombre+"%");
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				Registros registros2 = new Registros(resultset.getString("nombre"), resultset.getString("telefono"));
				
				registros.add(registros2);
			}
			return registros;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeResultSet();
			query = "";
			closeStament();
			conn.CloseConnection();
		}

	}


	public ArrayList<Registros> selectFacturasByTelefono(String telefono) {
		try {
			ArrayList<Registros> registros = new ArrayList<>();
			query = "SELECT * FROM registros WHERE telefono LIKE ?";
			preparedStatement = conn.getCon().prepareStatement(query);
			preparedStatement.setString(1, "%"+telefono+"%");
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				Registros registros2 = new Registros(resultset.getString("nombre"), resultset.getString("telefono"));
				
				registros.add(registros2);
			}
			return registros;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeResultSet();
			query = "";
			closeStament();
			conn.CloseConnection();
		}

	}
	public void closeStament() {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeResultSet() {
		try {
			if (resultset != null) {
				resultset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
	}

	public void updateAll() {
	}

}
