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
import pe.edu.upc.dew.controlventas.model.LineaCredito;

/**
 *
 * @author u814296
 */
public class LineaCreditoDao {

    List<LineaCredito> lineasCreditos = new ArrayList<LineaCredito>();

    public LineaCreditoDao(){


        try{
            //Cargar clase de controlador de base de datos
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Establecer conexion a la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:odbc:CONTROLVENTA;user=sa;password=sa");
            //Crear objeto Statement para realizar queries a la base de datos
            java.sql.Statement instruccion = conexion.createStatement();
            //Consultar a la base de datos
            ResultSet conjuntoResultados = instruccion.executeQuery("SELECT * FROM LINEACREDITO");
            //Procesar los resultados de la consulta
            //StringBuffer resultados = new StringBuffer();
            ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
            //int numeroDeColumnas = metaDatos.getColumnCount();
            //for(int i = 1; i <= numeroDeColumnas; i++)
            //    resultados.append(metaDatos.getColumnName(i)+"\t");
            //resultados.append("\n");
            while(conjuntoResultados.next()) {
                LineaCredito _credito = new LineaCredito();
                _credito.setId(conjuntoResultados.getInt("idLineaCredito"));
                _credito.setNombre(conjuntoResultados.getNString("nombre"));
                _credito.setRangoMin(conjuntoResultados.getDouble("minimo"));
                _credito.setRangoMax(conjuntoResultados.getDouble("maximo"));
                lineasCreditos.add(_credito);
            }
            //System.out.println(resultados.toString());
        }
        catch(ClassNotFoundException e){ System.out.println(e); }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e.getMessage()); }

//        LineaCredito lc1 = new LineaCredito();
//        lc1.setId(1);
//        lc1.setNombre("Normal");
//        lc1.setRangoMin(100);
//        lc1.setRangoMax(600);
//
//        lineasCreditos.add(lc1);
//
//        LineaCredito lc2 = new LineaCredito();
//        lc2.setId(2);
//        lc2.setNombre("Silver");
//        lc2.setRangoMin(600);
//        lc2.setRangoMax(2000);
//
//        lineasCreditos.add(lc2);
//
//
//        LineaCredito lc3 = new LineaCredito();
//        lc3.setId(3);
//        lc3.setNombre("Gold");
//        lc3.setRangoMin(2000);
//        lc3.setRangoMax(5000);
//
//        lineasCreditos.add(lc3);
        
        
    }

    public LineaCredito buscarLineaCredito(double sueldo){

        for (int i = 0; i < lineasCreditos.size(); i++) {
            LineaCredito lineaCredito = lineasCreditos.get(i);
            if(lineaCredito.getRangoMin()<= sueldo && lineaCredito.getRangoMax()>=sueldo){
                return lineaCredito;
            }
        }

        return null;

    }


    /**
     * 
     * @param username
     * @return Usuario
     */
    public List<LineaCredito> getLineasCreditos() {
        return lineasCreditos;
    }


}
