package cadalunos;

import java.sql.*;
import java.util.*;

//Classe para conexão do banco de dados
public class Dao {
    private String BASE_URL;
    private String DATABASE_USER;
    private final String DATABASE_PASS;
    
    private final Connection connection;
    private final Statement statement;
    private ResultSet resultSet;
    
    public Dao() throws Exception {
        this.DATABASE_USER = "root";
        this.DATABASE_PASS = "root";
        this.BASE_URL = "jdbc:mysql://localhost:3306/aula";
        
        //Abre uma conexão com o banco de dados toda vez que a classe for instanciada
        this.connection = DriverManager.getConnection(this.BASE_URL, this.DATABASE_USER, this.DATABASE_PASS);
        this.statement = this.connection.createStatement();        
    }
    
    public ArrayList QueryExecute(String Query) throws Exception {
        String Resultado = "";
        ArrayList<String> alunos = new ArrayList();
        
        this.resultSet = this.statement.executeQuery(Query);
        
        while(resultSet.next()) {
            alunos.add(this.resultSet.getString("nome"));
        }
        
        return alunos;
    }
}