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
        tope=-1;
        agregarCaracter('z');
    }
    public boolean vacia()
    {
        return tope==-1;
    }
    public int getIndiceDeTope()
    {
        return tope;
    }
    /**
     * Agrega un caracter al tope de la pila.
     * 
     * @param c char
     */
    public void agregarCaracter(char c)
    {
        pila.add(new Character(c));
        tope++;
    }
    /**
     * ADVERTENCIA: método destructivo.
     * 
     * @return char
     * @throws NullPointerException cuando la pila está vacía
     */
    public char getCaracterDeTope() throws NullPointerException
    {
        if(vacia()) throw new NullPointerException("La pila está vacía.");
        tope--;
        return pila.remove(tope).charValue();
    }
    /**
     * ADVERTENCIA: método no destructivo.
     * 
     * @return char
     * @throws NullPointerException cuando la pila está vacía
     */
    public char verTope() throws NullPointerException
    {
        if(vacia()) throw new NullPointerException("La pila está vacía.");
        tope--;
        return pila.get(tope).charValue();
    }
}
