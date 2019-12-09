package br.projeto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.projeto.dao.ClienteDAO;

public class ClienteBancoDAO implements ClienteDAO{
    
	public ClienteBancoDAO(){
	}

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;

    public void conectar() {
        String servidor = "jdbc:mysql://localhost:3306/mydb";
        String usuario = "root";
        String senha = "Theo@1703";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(servidor, usuario, senha);
            this.statement = this.connection.createStatement();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }
	
    public boolean estaConectado() {
        if (this.connection != null) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            String query = "SELECT * FROM Cliente";
            this.resultset = this.statement.executeQuery(query);
            this.statement = this.connection.createStatement();
            while (this.resultset.next()) {
                lista.add(new Cliente(this.resultset.getString("idCliente"), this.resultset.getString("nomeCliente"),
                        this.resultset.getString("endereco"), this.resultset.getString("telefone")));
            }
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return lista;
    }

    public void inserirCliente(String nome, String endereco, String telefone) {
        telefone = telefone.replace("(", "");
        telefone = telefone.replace(")", "");
        telefone = telefone.replace("-", "");
        telefone = telefone.replace(" ", "");
        try {
            String query = "INSERT INTO Cliente (nomeCliente, endereco, telefone) VALUES ('" + nome + "', '"
                    + endereco + "', '" + telefone + "');";
            this.statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente -> " + e.getMessage());
        }
    }

    public void editarCliente(int idCliente, String nomeCliente, String endereco, String telefone) {
        try {
            String query = "UPDATE Cliente SET nomeCliente = '" + nomeCliente + "', endereco ='"
                    + endereco + "', telefone = '" + telefone + "' WHERE idCliente ='" +
                    idCliente + "';";
            System.out.println(query);
            this.statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void apagarCliente(int idCliente, String nomeCliente, String endereco, String telefone) {
        try {
            String query = "DELETE FROM Cliente SET nomeCliente = '"+ nomeCliente + "', endereco = '" 
            		+ endereco + "', telefone = '" + telefone + "' WHERE idCliente ='" +
            		idCliente +"';";
            this.statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

	@Override
	public void inserirCliente(Cliente model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarCliente(int idCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apagarCliente(int idCliente) {
		// TODO Auto-generated method stub
		
	}
	
	public static void getConnection() {
		// TODO Auto-generated method stub 
	}
}
