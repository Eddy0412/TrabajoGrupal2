package DbManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import model.ClienteAppend;
import model.DetalleFactura;
import model.Factura;

public class Crud {

	private Dbconnection conn;
	private PreparedStatement preparedStatement;
	private ResultSet resultset, resultset2;
	private String query;

	public Crud() {
		conn = new Dbconnection();
	}

	public void insertAll() {
	}

	public ArrayList<Factura> selectFacturasByCliente(int CLnumero) {
		try {
			ArrayList<Factura> facturas = new ArrayList<>();
			query = "SELECT * FROM factura WHERE CLnumero=?";
			preparedStatement = conn.getCon().prepareStatement(query);
			preparedStatement.setInt(1, CLnumero);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				Factura factura = new Factura(resultset.getInt("FAnumero"), resultset.getString("FAproveedor"),
						resultset.getDate("FAfecha"), resultset.getInt("CLnumero"));
				factura.setDetalleFacturas(selectDetalleFacturaByFactura(factura.getFAnumero()));
				facturas.add(factura);
			}
			return facturas;
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

	public ArrayList<DetalleFactura> selectDetalleFacturaByFactura(int FAnumero) {
		try {
			ArrayList<DetalleFactura> detalleFactura = new ArrayList<>();
			query = "SELECT * FROM fadetalles WHERE FAnumero=?";
			preparedStatement = conn.getCon().prepareStatement(query);
			preparedStatement.setInt(1, FAnumero);
			resultset2 = preparedStatement.executeQuery();
			while (resultset2.next()) {
				detalleFactura.add(new DetalleFactura(resultset2.getInt("id_FAdetalles"),
						resultset2.getString("FAarticulo"), resultset2.getInt("FAcantidad"),
						resultset2.getString("FAunidad"), resultset2.getDouble("FAtotal"),
						resultset2.getDouble("FAitbm"), resultset2.getInt("FAnumero")));
			}
			return detalleFactura;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			query = "";
			closeStament();
			conn.CloseConnection();
		}

	}

	public ArrayList<ClienteAppend> countFacturaClientes() {
		try {
			ArrayList<ClienteAppend> clientesCuntFacturas = new ArrayList<>();
			query = "SELECT cliente.*,COUNT(factura.FAnumero)as count FROM factura INNER JOIN cliente where factura.CLnumero=cliente.CLnumero GROUP BY cliente.CLnumero";
			preparedStatement = conn.getCon().prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				clientesCuntFacturas.add(new ClienteAppend(resultset.getInt("CLnumero"), resultset.getString("CLid"),
						resultset.getString("CLnombre"), resultset.getString("CLapellido"),
						resultset.getString("CLdireccion"), resultset.getString("CLtelefono"),
						resultset.getString("CLactividad"), resultset.getInt("count")));
			}
			return clientesCuntFacturas;
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

	public Cliente selectClienteByCliente(int CLnumero) {

		try {
			query = "SELECT * FROM cliente WHERE CLnumero =?";
			preparedStatement = conn.getCon().prepareStatement(query);
			preparedStatement.setInt(1, CLnumero);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				Cliente cliente = new Cliente(resultset.getInt("CLnumero"), resultset.getString("CLid"),
						resultset.getString("CLnombre"), resultset.getString("CLapellido"),
						resultset.getString("CLdireccion"), resultset.getString("CLtelefono"),
						resultset.getString("CLactividad"));
				return cliente;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeResultSet();
			query = "";
			closeStament();
			conn.CloseConnection();
		}
		return null;
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
