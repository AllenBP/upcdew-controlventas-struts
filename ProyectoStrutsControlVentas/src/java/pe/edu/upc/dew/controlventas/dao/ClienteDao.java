/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.dew.controlventas.model.Cliente;

/**
 *
 * @author u814296
 */
public class ClienteDao {

    List<Cliente> clientes = new ArrayList<Cliente>();

    public ClienteDao(){

//        Cliente cli1 = new Cliente();
//        cli1.setNombre("Martin");
//        cli1.setApellidoPaterno("Oshiro");
//        cli1.setApellidoMaterno("...");
//        cli1.setEmail("moshiro@mail.com");
//        cli1.setFechaNacimiento("12/02/86");
//        cli1.setLineaCredito((new LineaCreditoDao()).buscarLineaCredito(200));
//        cli1.getLineaCredito().setCreditoReal(500);
//        clientes.add(cli1);
//
//        Cliente cli2 = new Cliente();
//        cli2.setNombre("Luis");
//        cli2.setApellidoPaterno("Davila");
//        cli2.setApellidoMaterno("Quispe");
//        cli2.setEmail("ldavila@mail.com");
//        cli2.setFechaNacimiento("22/07/80");
//        cli2.setLineaCredito((new LineaCreditoDao()).buscarLineaCredito(1000));
//        cli2.getLineaCredito().setCreditoReal(1200);
//
//        clientes.add(cli2);

    }

    /**
     * Obtiene un Usuario por username de la BD
     * @param username
     * @return Usuario
     */
    public List<Cliente> getClientes() {

        List<Cliente> clientes = new ArrayList<Cliente>();

        try{
            //Cargar clase de controlador de base de datos
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Establecer conexion a la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:odbc:CONTROLVENTA;user=sa;password=sa");
            //Crear objeto Statement para realizar queries a la base de datos
            java.sql.Statement instruccion = conexion.createStatement();
            //Consultar a la base de datos
            ResultSet conjuntoResultados = instruccion.executeQuery("SELECT * FROM CLIENTE");
            //Procesar los resultados de la consulta
            //StringBuffer resultados = new StringBuffer();
            ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
            //int numeroDeColumnas = metaDatos.getColumnCount();
            //for(int i = 1; i <= numeroDeColumnas; i++)
            //    resultados.append(metaDatos.getColumnName(i)+"\t");
            //resultados.append("\n");
            while(conjuntoResultados.next()) {
                Cliente _cliente = new Cliente();
                _cliente.setIdUsuario(conjuntoResultados.getInt("idCliente"));
                _cliente.setUsername(conjuntoResultados.getString("userName"));
                //usuario.setPassword(conjuntoResultados.getNString("password"));
                _cliente.setNombre(conjuntoResultados.getString("nombre"));
                _cliente.setApellidoPaterno(conjuntoResultados.getString("apePaterno"));
                _cliente.setApellidoMaterno(conjuntoResultados.getString("apeMaterno"));
                _cliente.setLineaCredito((new LineaCreditoDao()).buscarLineaCredito(conjuntoResultados.getDouble("credito")));
                _cliente.getLineaCredito().setCreditoReal(conjuntoResultados.getDouble("credito"));
                //for(int i = 1; i <= numeroDeColumnas; i++)
                //    resultados.append(conjuntoResultados.getObject(i) + "\t");
                //resultados.append("\n");
                clientes.add(_cliente);
            }
            //System.out.println(resultados.toString());
        }
        catch(ClassNotFoundException e){ System.out.println(e); }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e.getMessage()); }



        return clientes;
    }

    /**
     * Obtiene un Usuario por username de la BD
     * @param username
     * @return Usuario
     */
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

}
