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
public class NodoSintactico {
    private String nombre;
    private ArrayList<NodoSintactico> derivados;
    public NodoSintactico(String token)
    {
        nombre=token;
    }
    public void setDerivados(ArrayList<NodoSintactico> derivados)
    {
        this.derivados=derivados;
    }
    public void agregarDerivado(NodoSintactico derivado)
    {
        derivados.add(derivado);
    }
    public ArrayList<NodoSintactico> getDerivados()
    {
        return derivados;
    }
    public NodoSintactico getDerivado(int index)
    {
        return derivados.get(index);
    }
    public ArrayList<NodoSintactico> getDerivado(String nombre)
    {
        ArrayList<NodoSintactico> d = new ArrayList<NodoSintactico>();
        for(int i=0;i<derivados.size();i++)
            if(derivados.get(i).getNombre().equals(nombre))
                d.add(derivados.get(i));
        return d;
    }
    public String getNombre()
    {
        return nombre;
    }
}
