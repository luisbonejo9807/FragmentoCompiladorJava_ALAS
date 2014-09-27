/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fragmentocompiladorjava_alas;

import java.util.ArrayList;

/**
 *
 * @author JLCG17
 */
public class AnalizadorSintactico {
    private AnalizadorLexico al;
    private ArrayList<Token> tokensValidadosPorAL;
    private AutomataPilaSintactico aps;
    public AnalizadorSintactico(AnalizadorLexico analizadorLexico)
    {
        al = analizadorLexico;
        tokensValidadosPorAL = new ArrayList<Token>();
        aps = new AutomataPilaSintactico();
    }
    /**
     * Hace que el analizador léxico escanee todo el archivo y guarda todo objeto Token que no sea error o espacio.
     */
    private void ejecutarAnalizadorLexico()
    {
        Tokens t;
        boolean sin_errores = true;
        while((t = al.siguienteToken())!=Tokens.EOT)
        {
            if(t != Tokens.ERROR && t != Tokens.ESPACIO) //Ignorar espacios además de errores.
                tokensValidadosPorAL.add(al.getTokenActual());
            if(t==Tokens.ERROR) sin_errores = false;
        }
        if(sin_errores) System.out.println("Análisis léxico sin errores.");
    }
    /**
     * Arma y retorna un árbol sintáctico del código fuente.
     * Imprime los errores sintácticos que encuentre por el camino.
     * 
     * @return NodoSintactico que es la raíz del árbol sintáctico del código fuente.
     */
    public NodoSintactico analizarSintaxis()
    {
        boolean sin_errores = true;
        ejecutarAnalizadorLexico();
        try{
            for(int i=0;i<tokensValidadosPorAL.size();i++)
                if(!aps.tokenValidoSintacticamente(tokensValidadosPorAL.get(i))) sin_errores=false;
            if(sin_errores)
                sin_errores = aps.declararFinDeEntrada();
            else
                aps.declararFinDeEntrada();
            if(sin_errores) System.out.println("Análisis sintáctico sin errores.");
            
        }catch(NullPointerException exc){
            System.err.println("Error sintáctico fatal: el analizador no puede llegar al final del código fuente, así que busque y corrija el o los errores.");
            //exc.printStackTrace();
        }
        return null;
    }
}
