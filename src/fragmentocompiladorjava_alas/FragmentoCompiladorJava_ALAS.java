/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fragmentocompiladorjava_alas;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author JLCG17
 */
public class FragmentoCompiladorJava_ALAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //probarAnalizadorLexico("src/fragmentocompiladorjava_alas/codigofuente.fjl",true);
        probarAnalizadorSintactico("src/fragmentocompiladorjava_alas/codigofuente.fjl",true);
    }
    public static void probarAnalizadorLexico(String directorio,boolean mostrarSoloErrores)
    {
        try{
            CodigoFuente cf = new CodigoFuente(directorio);
            AnalizadorLexico al = new AnalizadorLexico(cf.getLineas());
            String bufferError = "";
            Tokens t;
            while((t=al.siguienteToken())!=Tokens.EOT)
                if(!mostrarSoloErrores)
                    if(t==Tokens.ERROR&&al.getTokenActual().getToken().length()==1)
                        bufferError+=al.getTokenActual().getToken();
                    else
                    {
                        if(bufferError.length()>0)
                        {
                            System.out.println("\""+bufferError+"\" es ERROR");
                            bufferError = "";
                        }
                        System.out.println("\""+al.getTokenActual().getToken()+"\" es "+t);
                    }
        }catch(FileNotFoundException exc){
            System.err.println("No se encontró el archivo con el código fuente.");
        }catch(IOException exc){
            System.err.println("Hubo un error durante la lectura del archivo con el código fuente.");
        }
    }
    public static void probarAnalizadorSintactico(String directorio,boolean mostrarArbol)
    {
        try{
            CodigoFuente cf = new CodigoFuente(directorio);
            AnalizadorLexico al = new AnalizadorLexico(cf.getLineas());
            AnalizadorSintactico as = new AnalizadorSintactico(al);
            ArbolSintactico arsi = as.analizarSintaxis();
            if(mostrarArbol)
                System.out.println("\033[34m"+arsi.toString()+"\033[30m");
        }catch(FileNotFoundException exc){
            System.err.println("No se encontró el archivo con el código fuente.");
        }catch(IOException exc){
            System.err.println("Hubo un error durante la lectura del archivo con el código fuente.");
        }
    }
}
