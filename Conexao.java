import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexao {
	public void conexaoLerPf(ArrayList<PessoaFisica> cliPf){
		PessoaFisica cliente = new PessoaFisica();
		try{
		String userName = "root";
	    String password = "";
	    String url = "jdbc:mysql://localhost:3301/seguradora?useSSL=false";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from cliente");
		while(rs.next()){
		cliente.setCliente(rs.getString("cliente"));
		cliente.setCpf(rs.getInt("cpf"));
		cliente.setEndereco(rs.getString("endereco"));
		cliente.setValorImovel(rs.getDouble("valorimovel"));
		cliente.setAreaImovel(rs.getInt("areaimovel"));
		cliente.setResidencia(rs.getBoolean("residencia"));
		cliente.setDataSinistro(rs.getString("datasinistro"));
		cliente.setTemSinistro(rs.getBoolean("sinistro"));
		cliPf.add(cliente);
		cliente = new PessoaFisica();
		}
		rs.close();
		st.close();
		conn.close();
		}catch(ClassNotFoundException e){
			
		}catch(SQLException e){
			
		}

		}
	public void guardarClientePf(String cliente, int cpf){
	
		try{
			String userName = "root";
	        String password = "";
	        String url = "jdbc:mysql://localhost:3301/seguradora?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "insert into cliente(cliente,cpf) value (?,?)";
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente);
			stmt.setInt(2, cpf);
			stmt.execute();  
	        stmt.close();
			conn.close();
		} catch(ClassNotFoundException e){
			System.out.println("conexao Erro");
		}catch (SQLException e) {
			System.out.println("cpf já existe.");
		}
		
}
	public void conexaoLerPj(ArrayList<PessoaJuridica> cliPj){
		PessoaJuridica cliente = new PessoaJuridica();
		try{
		String userName = "root";
	    String password = "";
	    String url = "jdbc:mysql://localhost:3301/seguradora?useSSL=false";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, userName, password);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from cliente_emp");
		while(rs.next()){
		cliente.setCliente(rs.getString("cliente"));
		cliente.setCnpj(rs.getInt("cnpj"));
		cliente.setValorImovel(rs.getInt("valorimovel"));
		cliente.setNumFuncionarios(rs.getInt("numfuncionarios"));
		cliente.setNumVisitasDiarias(rs.getInt("numvisitas"));
		cliente.setRamo(rs.getInt("ramo"));
		cliente.setDataSinistro(rs.getString("datasinistro"));
		cliente.setTemSinistro(rs.getBoolean("temsinistro"));
		cliPj.add(cliente);
		cliente = new PessoaJuridica();
		}
		rs.close();
		st.close();
		conn.close();
		}catch(ClassNotFoundException e){
			
		}catch(SQLException e){
			
		}
		
	}
	public void guardarCliPj(String cliente, int cnpj){
		try{
			String userName = "root";
	        String password = "";
	        String url = "jdbc:mysql://localhost:3301/seguradora?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "insert into cliente_emp(cliente,cnpj) value (?,?)";
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cliente);
			stmt.setInt(2, cnpj);
			stmt.execute();  
	        stmt.close();
			conn.close();
		} catch(ClassNotFoundException e){
			System.out.println("conexao Erro");
		}catch (SQLException e) {
			System.out.println("cnpj ja existe.");
		}
	}
	
	public void guardarContratoPj(PessoaJuridica cliente){
		
		try{
			String userName = "root";
	        String password = "";
	        String url = "jdbc:mysql://localhost:3301/seguradora?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "update cliente_emp set valorimovel=?,numfuncionarios=?,numvisitas=?,ramo=? where cnpj = ?";
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, cliente.getValorImovel());
			stmt.setInt(2, cliente.getNumFuncionarios());
			stmt.setInt(3, cliente.getNumVisitasDiarias());
			stmt.setInt(4, cliente.getRamo());
			stmt.setInt(5, cliente.getCnpj());
			stmt.execute();  
	        stmt.close();
			conn.close();
		} catch(ClassNotFoundException e){
			System.out.println("conexao Erro");
		}catch (SQLException e) {
			System.out.println("cnpj não existe.");
		}
	}
	public void guardarcontratoPf(PessoaFisica cliente){
		
		try{
		String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3301/seguradora?useSSL=false";
		Class.forName("com.mysql.jdbc.Driver");
		String sql = "update cliente set endereco = ?,valorimovel = ?,areaimovel = ?,residencia = ? where cpf = ?";
		Connection conn = DriverManager.getConnection(url, userName, password);
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, cliente.getEndereco());
		stmt.setDouble(2, cliente.getValorImovel());
		stmt.setInt(3, cliente.getAreaImovel());
		stmt.setBoolean(4, cliente.isResidencia());
		stmt.setInt(5, cliente.getCpf());
		stmt.execute();  
        stmt.close();
		conn.close();
		}catch(SQLException e){
			System.out.println("CPF não encontrado.");
		}catch(ClassNotFoundException e){
			
		}
	}
	
	public void guardarSinistroPf(PessoaFisica cliente){
		try{
			String userName = "root";
	        String password = "";
	        String url = "jdbc:mysql://localhost:3301/seguradora?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "update cliente set sinistro = ?,datasinistro=? where cpf = ?";
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, cliente.isTemSinistro());
			stmt.setString(2, cliente.getDataSinistro());
			stmt.setInt(3, cliente.getCpf());
			stmt.execute();  
	        stmt.close();
			conn.close();
			}catch(SQLException e){
				System.out.println("erro sql sinistro pf");
			}catch(ClassNotFoundException e){
				
			}
		
	}
	public void guardarSinistroPj(PessoaJuridica cliente){
		try{
			String userName = "root";
	        String password = "";
	        String url = "jdbc:mysql://localhost:3301/seguradora?useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "update cliente_emp set temsinistro = ?,datasinistro=? where cnpj = ?";
			Connection conn = DriverManager.getConnection(url, userName, password);
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBoolean(1, cliente.isTemSinistro());
			stmt.setString(2, cliente.getDataSinistro());
			stmt.setInt(3, cliente.getCnpj());
			stmt.execute();  
	        stmt.close();
			conn.close();
			}catch(SQLException e){
				System.out.println("erro sql sinistro pj");
			}catch(ClassNotFoundException e){
				
			}
		
	}

}
