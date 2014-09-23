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
public class AutomataPilaSintaxis {
    private boolean[][] transitable;
    private PilaDeCaracteres pila;
    private int estadoActual;
    public AutomataPilaSintaxis()
    {
        transitable = new boolean[][]{
            //TIPO  ID    COMA   =     ;   ++/--  #=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true,false,false},//q0
            {false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q1
            {false,false, true, true, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q2
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true, true, true},//q3
            {false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q4
            {false,false,false, true,false, true, true,false,false,false,false,false,false,false,false,false,false,false,false},//q5
            {false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q6
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false},//q7
            {false,false,false,false, true,false,false,false, true,false, true,false,false,false,false,false,false,false,false},//q8
            {false, true,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false},//q9
            {false,false,false,false, true,false,false,false, true,false,false,false,false,false,false,false,false,false,false},//q10
            {false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q11
            {false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q12
            {false,false,false,false,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false},//q13
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false},//q14
            {false,false,false,false,false,false,false,false, true,false, true,false,false,false, true,false,false,false,false},//q15
            {false, true,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false},//q16
            {false,false,false,false,false,false,false,false, true,false,false,false,false,false, true,false,false,false,false},//q17
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false},//q18
            {false, true,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false},//q19
            {false,false,false,false,false,false,false,false, true,false, true,false,false,false,false, true,false,false,false},//q20
            //TIPO  ID    COMA   =     ;   ++/--  #=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false},//q21
            {false,false,false,false,false,false,false,false,false,false, true,false,false,false,false, true,false,false,false},//q22
            {false,false,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false},//q23
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true,false,false},//q24
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true,false,false},//q25
            {false,false,false,false,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false},//q26
            {false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q27
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true,false,false}//q28
        };
        pila = new PilaDeCaracteres();
        estadoActual = 0;
    }
}
