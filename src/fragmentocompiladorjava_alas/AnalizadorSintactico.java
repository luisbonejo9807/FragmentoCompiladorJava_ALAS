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
    private int indiceToken;
    public AnalizadorSintactico(AnalizadorLexico analizadorLexico)
    {
        al = analizadorLexico;
        tokensValidadosPorAL = new ArrayList<Token>();
        aps = new AutomataPilaSintactico();
        indiceToken=-1;
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
        if(sin_errores) System.out.println("\033[32mAnálisis léxico sin errores.\033[30m");
    }
    /**
     * Arma y retorna un árbol sintáctico del código fuente.
     * Imprime los errores sintácticos que encuentre por el camino.
     * Si encuentra un error, intenta seguir analizando, aunque eso signifique errores de arrastre.
     * 
     * @return NodoSintactico que es la raíz del árbol sintáctico del código fuente.
     */
    public NodoSintactico analizarSintaxis()
    {
        boolean sin_errores = true;
        boolean valido;
        NodoSintactico raiz = new NodoSintactico("SECUENCIA");
        ejecutarAnalizadorLexico();
        if(tokensValidadosPorAL.size()>0)
        {
            for(indiceToken=0;indiceToken<tokensValidadosPorAL.size();indiceToken++)
            {
                if(!(valido=aps.tokenValidoSintacticamente(tokensValidadosPorAL.get(indiceToken)))) sin_errores=false;
            }
            if(sin_errores)
                sin_errores = aps.declararFinDeEntrada();
            else
                aps.declararFinDeEntrada();
            if(sin_errores) System.out.println("\033[32mAnálisis sintáctico sin errores.\033[30m");
        }else{
            System.out.println("\033[32mAnálisis sintáctico sin errores.\033[30m");
        }
        return raiz;
    }
}
