/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fragmentocompiladorjava_alas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
        probarAnalizadorLéxico("src/fragmentocompiladorjava_alas/codigofuente.fjl",true);
    }
    public static void probarAnalizadorLéxico(String directorio,boolean mostrarSoloErrores)
    {
        try{
            CodigoFuente cf = new CodigoFuente(directorio);
            AnalizadorLexico al = new AnalizadorLexico(cf.getLineas());
            Tokens t;
            while((t=al.siguienteToken())!=Tokens.EOT)
                if(!mostrarSoloErrores)
                    System.out.println("\""+al.getTokenActual()+"\" es "+t);
        }catch(FileNotFoundException exc){
            System.err.println("No se encontró el archivo con el código fuente.");
        }catch(IOException exc){
            System.err.println("Hubo un error durante la lectura del archivo con el código fuente.");
        }
    }
}
