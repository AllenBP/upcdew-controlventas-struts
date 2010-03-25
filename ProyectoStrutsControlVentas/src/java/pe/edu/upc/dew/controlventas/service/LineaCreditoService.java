/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.controlventas.service;

import pe.edu.upc.dew.controlventas.dao.LineaCreditoDao;
import pe.edu.upc.dew.controlventas.model.LineaCredito;
import pe.edu.upc.dew.controlventas.model.ParamRecomendacion;

/**
 *
 * @author u814296
 */
public class LineaCreditoService {
    private LineaCreditoDao lineaCreditoDao;


    public LineaCreditoService(){
        lineaCreditoDao = new LineaCreditoDao();
    }

    public LineaCredito buscarLineaCredito(double sueldo){
        return lineaCreditoDao.buscarLineaCredito(sueldo);
    }

    public LineaCredito asignarLineaCredito(ParamRecomendacion recom){

        double valorCredito = 0;

        //Se podra sacar credito de un promedio del 25% de su sueldo;
        valorCredito = recom.getSueldo() * 0.25;

        //Si tiene mas de una tarjeta se podra aumentar en 250 soles mas al credito
        if(recom.getNroTarjeta()>1){
            valorCredito += 250;
        }

        //Si tiene casa se podra aumentar en 150 soles mas al credito
        if(recom.getIsCasa().equals("S")){
            valorCredito += 150;
        }

        //Si tiene aulto se podra aumentar en 100 soles mas al credito
        if(recom.getIsAuto().equals("S")){
            valorCredito += 100;
        }

        return lineaCreditoDao.buscarLineaCredito(valorCredito);
    }

}
