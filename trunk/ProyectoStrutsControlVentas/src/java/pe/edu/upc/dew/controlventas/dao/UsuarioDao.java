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
import pe.edu.upc.dew.controlventas.model.Rol;
import pe.edu.upc.dew.controlventas.model.Usuario;

/**
 *
 * @author u814296
 */
public class UsuarioDao {

    public UsuarioDao(){

    }

    /**
     * Obtiene un Usuario por username de la BD
     * @param username
     * @return Usuario
     */
    public Usuario getUsuarioPorUsername(String username) {

        Usuario usuario = new Usuario();

        try{
            //Cargar clase de controlador de base de datos
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Establecer conexion a la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:odbc:CONTROLVENTA;user=sa;password=sa");
            //Crear objeto Statement para realizar queries a la base de datos
            java.sql.Statement instruccion = conexion.createStatement();
            //Consultar a la base de datos
            ResultSet conjuntoResultados = instruccion.executeQuery("SELECT * FROM CLIENTE where userName='" + username +"'");
            //Procesar los resultados de la consulta
            //StringBuffer resultados = new StringBuffer();
            ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
            //int numeroDeColumnas = metaDatos.getColumnCount();
            //for(int i = 1; i <= numeroDeColumnas; i++)
            //    resultados.append(metaDatos.getColumnName(i)+"\t");
            //resultados.append("\n");
            while(conjuntoResultados.next()) {

                usuario.setIdUsuario(conjuntoResultados.getInt("idCliente"));
                usuario.setUsername(conjuntoResultados.getString("userName"));
                usuario.setPassword(conjuntoResultados.getString("password"));
                usuario.setNombre(conjuntoResultados.getString("nombre"));
                usuario.setApellidoPaterno(conjuntoResultados.getString("apePaterno"));
                usuario.setApellidoMaterno(conjuntoResultados.getString("apeMaterno"));
                usuario.setRoles(this.getRoles(conjuntoResultados.getInt("idRol")));
                //for(int i = 1; i <= numeroDeColumnas; i++)
                //    resultados.append(conjuntoResultados.getObject(i) + "\t");
                //resultados.append("\n");
            }
            //System.out.println(resultados.toString());
        }
        catch(ClassNotFoundException e){ System.out.println(e); }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e.getMessage()); }
        

        //Usuario usuario = new Usuario();

//         Rol _rol1 = new Rol();
//        _rol1.setIdRol(1);
//        _rol1.setNombre("Administración de clientes");
//        _rol1.setUrl("ClientServlet");
//
//
//        Rol _rol2 = new Rol();
//        _rol2.setIdRol(2);
//        _rol2.setNombre("Carro de compras");
//        _rol2.setUrl("carroCompra.jsp");
//
//
//        Rol _rol3 = new Rol();
//        _rol3.setIdRol(3);
//        _rol3.setNombre("Estado de cuenta");
//        _rol3.setUrl("estadoCuenta.jsp");
//
//
//
//        if(username.equals("admin")){
//
//            usuario.setIdUsuario(1);
//            usuario.setUsername("jucamayo");
//            usuario.setPassword("admin");
//            usuario.setNombre("Juan Carlos");
//            usuario.setApellidoPaterno("Camayo");
//            usuario.setApellidoMaterno("Espinoza");
//
//            usuario.agregarRol(_rol1);
//            usuario.agregarRol(_rol2);
//            usuario.agregarRol(_rol3);
//
//        }else{
//
//            usuario.setIdUsuario(1);
//            usuario.setUsername("luis");
//            usuario.setPassword("luis");
//            usuario.setNombre("Luis");
//            usuario.setApellidoPaterno("Davila");
//            usuario.setApellidoMaterno("Quispe");
//
//            usuario.agregarRol(_rol2);
//            usuario.agregarRol(_rol3);
//
//        }

        return usuario;
    }


    public List<Rol> getRoles(int idRol) {

        List<Rol> roles = new ArrayList<Rol>();

        try{
            //Cargar clase de controlador de base de datos
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Establecer conexion a la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:odbc:CONTROLVENTA;user=sa;password=sa");
            //Crear objeto Statement para realizar queries a la base de datos
            java.sql.Statement instruccion = conexion.createStatement();
            //Consultar a la base de datos
            ResultSet conjuntoResultados = instruccion.executeQuery("SELECT P.idPAGINA, p.nombre, p.url  FROM ROL_PAGINA RP, PAGINA P WHERE RP.IDROL=P.IDROL");
            //Procesar los resultados de la consulta
            //StringBuffer resultados = new StringBuffer();
            ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
            //int numeroDeColumnas = metaDatos.getColumnCount();
            //for(int i = 1; i <= numeroDeColumnas; i++)
            //    resultados.append(metaDatos.getColumnName(i)+"\t");
            //resultados.append("\n");
            while(conjuntoResultados.next()) {
                Rol _rol = new Rol();
                _rol.setIdRol(conjuntoResultados.getInt("idPAGINA"));
                _rol.setNombre(conjuntoResultados.getString("NOMBRE"));
                _rol.setUrl(conjuntoResultados.getString("URL"));
            }
            //System.out.println(resultados.toString());
        }
        catch(ClassNotFoundException e){ System.out.println(e); }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e.getMessage()); }
        

        return roles;
    }
}
