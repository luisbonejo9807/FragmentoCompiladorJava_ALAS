/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fragmentocompiladorjava_alas;

/**
 *
 * @author JLCG17
 */
public class AnalizadorSemantico {
    private AnalizadorSintactico ansi;
    private ArbolSintactico arsi;
    public AnalizadorSemantico(AnalizadorSintactico as)
    {
        ansi=as;
    }
    public Object analizarSemantica()
    {
        Object retorno = null;
        arsi = ansi.analizarSintaxis();
        
        return retorno;
    }
}
