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
public class PilaDeCaracteres {
    private ArrayList<Character> pila;
    private int tope;
    public PilaDeCaracteres()
    {
        pila = new ArrayList<Character>();
        pila.add(new Character('z'));
        tope=-1;
        tope++;
    }
    public boolean vacia()
    {
        return tope==-1;
    }
    public int getIndiceDeTope()
    {
        return tope;
    }
    public void agregarCaracter(char c)
    {
        pila.add(new Character(c));
        tope++;
    }
    public char getCaracterDeTope() throws NullPointerException
    {
        if(vacia()) throw new NullPointerException("La pila está vacía.");
        tope--;
        return pila.remove(tope).charValue();
    }
}
