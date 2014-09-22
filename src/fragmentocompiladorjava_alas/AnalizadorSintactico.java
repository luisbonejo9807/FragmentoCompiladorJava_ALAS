/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fragmentocompiladorjava_alas;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author JLCG17
 */
public class AnalizadorSintactico {
    private AnalizadorLexico al;
    private ArrayList<Token> tokensValidadosPorAL;
    public AnalizadorSintactico(AnalizadorLexico analizadorLexico)
    {
        al = analizadorLexico;
        tokensValidadosPorAL = new ArrayList<Token>();
    }
    /**
     * Hace que el analizador léxico escanee todo el archivo y guarda todo objeto Token que no sea error o espacio.
     */
    private void ejecutarAnalizadorLexico()
    {
        Tokens t;
        while((t = al.siguienteToken())!=Tokens.EOT)
            if(t != Tokens.ERROR && t != Tokens.ESPACIO) //Ignorar espacios además de errores.
                tokensValidadosPorAL.add(al.getTokenActual());
    }
    /**
     * Arma y retorna un árbol sintáctico del código fuente.
     * Imprime los errores sintácticos que encuentre por el camino.
     * 
     * @return NodoSintactico que es la raíz del árbol sintáctico del código fuente.
     */
    public NodoSintactico analizarSintaxis()
    {
        ejecutarAnalizadorLexico();
        
        return null;
    }
}
