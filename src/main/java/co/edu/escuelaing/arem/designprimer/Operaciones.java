/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.designprimer;

import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author 2137497
 */
public class Operaciones {
    /**
	 * Este metodo permite calcular el Maximo Elemento de una lista
         * @param e// este es de tipo LinkedList
	 * @return double
	 */
     public  Operaciones() throws IOException, Exception{
        
            //leerDatos=new Lectura(prueba);
            //System.out.println(media(leerDatos.getColumna1()));
            //System.out.println(desviacion(leerDatos.getColumna1()));
            //System.out.println(media(leerDatos.getColumna2()));
            //System.out.println(desviacion(leerDatos.getColumna2()));
        
    }
    public Double Maximo(LinkedList<Double> e){
        Double max=e.get(0);
        for(int i=1; i<e.size();i++){
            if(e.get(i)>max){
                max=e.get(i);
            }
        }
        return max;
    }
    /**
	 * Este metodo permite calcular el Minimo Elemento de una lista
         * @param e// este es de tipo LinkedList
	 * @return double
	 */
    public Double Minimo(LinkedList<Double> e){
        Double min=e.get(0);
        for(int i=1; i<e.size();i++){
            if(e.get(i)<min){
                min=e.get(i);
            }
        }
        return min;
    }
    /**
	 * Este metodo permite calcular la Sumatoria  de una lista
         * @param e// este es de tipo LinkedList
	 * @return double
	 */
    public Double Sumatoria(LinkedList<Double> e){
        Double suma=0.0;
        for(int i=0;i<e.size();i++){
            suma+=e.get(i);
        }
        return suma;
    }
    /**
	 * Este metodo permite calcular la Multiplicatoria  de una lista
         * @param e// este es de tipo LinkedList
	 * @return double
	 */
    public Double Multiplicatoria(LinkedList<Double> e){
        Double multiplicar=e.get(0);
        for(int i=1;i<e.size();i++){
            multiplicar=multiplicar*e.get(i);
        }
        return multiplicar;
    }
}
