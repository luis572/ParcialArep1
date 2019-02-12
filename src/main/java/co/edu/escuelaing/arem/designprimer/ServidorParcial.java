/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.designprimer;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author 2137497
 */
public class ServidorParcial {
    public static void main(String[] args) { 
        setPort(4567);
        port(getPort());
        get("/", (req, res) -> lectura(req, res));
        get("/lectura", (req, res) -> lectura(req, res));
        get("/results", (req, res) -> respuesta(req,res));
    }
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
    public static String  lectura(Request req, Response res){
         String pagina = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "   \n" +
            "   <head>\n" +
            "      <title>Calculos Estadisticos</title>\n" +
            "   </head>\n" +
            "	\n" +
            "   <body>\n" +
            "      <h2>Bienvenido A Características de Arreglos :</h2>\n" +
            "      <p>Esta App le calculara las siguientes características: el máximo, el mínimo, la sumatoria y la multiplicatoria.</p>\n" +
            "      <p>Por favor digite los Numeros de su arreglo en el formulario de la parte inferior (Se debe de  ingresar los numeros separados por espacios y con \".\" puntos decimales en caso de requerirlo.)</p>\n" +
            "       <form action=\"/results\">\n" +
            "           Ingrese los datos:<br>\n" +
            "           <input type=\"text\" placeholder=\"Separar por estacios\" name=\"datos1\" ><br>\n" +
            "           <input type=\"submit\" value=\"Generar Caracteristicas\">\n" +
            "       </form>" +     
            //"      <a href = \"http://localhost:9999/results\" target = \"_self\">Ver Resultados</a>\n" +  
            "   </body>\n" +
            "	\n" +
            "</html>";
        return pagina;
    }
    public static String  respuesta(Request req, Response res) throws Exception{
        String numeros = req.queryParams("datos1");
        String[] datosIngresados=numeros.split(" ");
        numeros="Lista Digitada: "+numeros;
        Operaciones operacion=new Operaciones();
        LinkedList<Double> datos=new LinkedList();
        for(String n:datosIngresados) {
                datos.add(Double.parseDouble(n));
        }
        String maximo="El Maximo Numero es: "+String.valueOf(operacion.Maximo(datos));
        String minimo="El Minimo Numero es: "+String.valueOf(operacion.Minimo(datos));
        String sumatoria="La Sumatoria del Arreglo Es: "+String.valueOf(operacion.Sumatoria(datos));
        String multiplicatoria="La multiplicatoria del Arreglo Es: "+String.valueOf(operacion.Multiplicatoria(datos));
        String paginaResultados="<!doctype html>\n" +
				"<html lang=\"en\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>Document</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"<div id=\"contenedor\">\n" +
                                "        </div>\n" +
                                "<div id=\"contenedor2\">\n" +
                                "        </div>\n" +
                                "<div id=\"contenedor3\">\n" +
                                "        </div>\n" +
                                "<div id=\"contenedor4\">\n" +
                                "        </div>\n" +
                                "<div id=\"contenedor5\">\n" +
                                "        </div>\n" +
                                "        <script type=\"text/javascript\">\n" +
                                "            var objetoJSON;\n" +
                                "            objetoJSON={\"lista\":'"+numeros+"',\"Maximo\":'"+maximo+"',\"Minimo\":'"+minimo+"',\"Sumatoria\":'"+sumatoria+"',\"Multiplicatoria\":'"+multiplicatoria+"'};\n" +
                                "            document.getElementById('contenedor').innerHTML=objetoJSON.lista;\n" +
                                "            document.getElementById('contenedor2').innerHTML=objetoJSON.Maximo;\n" +
                                "            document.getElementById('contenedor3').innerHTML=objetoJSON.Minimo;\n" +
                                "            document.getElementById('contenedor4').innerHTML=objetoJSON.Sumatoria;\n" +
                                "            document.getElementById('contenedor5').innerHTML=objetoJSON.Multiplicatoria;\n" +
                                "        </script>"+
				"</body>\n" +
				"</html>";
		return paginaResultados;        
    }
}
