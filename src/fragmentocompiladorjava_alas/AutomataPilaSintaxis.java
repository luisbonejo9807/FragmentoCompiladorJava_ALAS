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
    private final boolean[][] transitable;
    private PilaDeCaracteres pila;
    private int estadoActual;
    private final int[][] transitaAEstado;
    private String instruccionReconocida;
    private boolean ignorarPila;
    public AutomataPilaSintaxis()
    {
        transitable = new boolean[][]{
            //TIPO  ID    COMA   =     ;   ++/--  :=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL  {     }
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true,false,false,false,false},//q0
            {false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q1
            {false,false, true, true, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q2
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true, true, true,false, true},//q3
            {false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q4
            {false,false,false, true,false, true, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q5
            {false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q6
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q7
            {false,false,false,false, true,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false},//q8
            {false, true,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false},//q9
            {false,false,false,false, true,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false},//q10
            {false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q11
            {false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q12
            {false,false,false,false,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false},//q13
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q14
            {false,false,false,false,false,false,false,false, true,false, true,false,false,false, true,false,false,false,false,false,false},//q15
            {false, true,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false},//q16
            {false,false,false,false,false,false,false,false, true,false,false,false,false,false, true,false,false,false,false,false,false},//q17
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q18
            {false, true,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false},//q19
            {false,false,false,false,false,false,false,false, true,false, true,false,false,false,false, true,false,false,false,false,false},//q20
            //TIPO  ID    COMA   =     ;   ++/--  :=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL  {     }
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q21
            {false,false,false,false,false,false,false,false,false,false, true,false,false,false,false, true,false,false,false,false,false},//q22
            {false,false,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q23
            { true, true,false,false,false,false,false,false,false,false,false, true, true,false,false,false, true,false,false, true,false},//q24
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true,false,false,false, true},//q25
            {false,false,false,false,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false},//q26
            {false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q27
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true,false,false, true,false}//q28
        };
        pila = new PilaDeCaracteres();
        estadoActual = 0;
        transitaAEstado = new int[][]{
            //TIPO  ID    COMA   =     ;   ++/--  :=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL  {     }
            { 1,    5,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  11,  7,      13, -1,   -1,   26,   -1,  -1,      -1,   -1},//q0
            { -1,   2,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q1
            { -1,   -1,   4,     7,    3,  -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q2
            { 1,    5,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  11,  7,      13, -1,   -1,   26,   28,  27,      -1,   3},//q3
            { -1,   2,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q4
            { -1,   -1,   -1,    7,    -1, 6,     7,  -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q5
            { -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q6
            { -1,   8,    -1,    -1,   -1, -1,    -1,  8,     -1,    9,    -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q7
            { -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     7,     -1,   10,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q8
            { -1,   8,    -1,    -1,   -1, -1,    -1,  8,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q9
            { -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     7,     -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q10
            { -1,   12,   -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q11
            { -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q12
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     -1,    14,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q13
            { -1,   15,   -1,    -1,   -1, -1,    -1, 15,     -1,    16,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q14
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     14,    -1,   17,  -1,  -1,     -1, 18,   -1,   -1,   -1,  -1,      -1,   -1},//q15
            { -1,   15,   -1,    -1,   -1, -1,    -1, 15,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q16
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     14,    -1,   -1,  -1,  -1,     -1, 18,   -1,   -1,   -1,  -1,      -1,   -1},//q17
            { -1,   20,   -1,    -1,   -1, -1,    -1, 20,     -1,    19,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q18
            { -1,   20,   -1,    -1,   -1, -1,    -1, 20,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q19
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     21,    -1,   24,  -1,  -1,     -1, -1,   23,   -1,   -1,  -1,      -1,   -1},//q20
            //TIPO  ID    COMA   =     ;   ++/--  :=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL  {     }
            { -1,   20,   -1,    -1,   -1, -1,    -1, 20,     -1,    19,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q21
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   24,  -1,  -1,     -1, -1,   23,   -1,   -1,  -1,      -1,   -1},//q22
            { -1,   -1,   -1,    -1,   -1, -1,    -1, 15,     -1,    16,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q23
            { 1,    5,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  11,  7,      -1, -1,   -1,   26,   -1,  27,      25,   -1},//q24
            { 1,    5,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  11,  7,      13, -1,   -1,   26,   -1,  -1,      -1,   3},//q25
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     -1,    14,   -1,  -1,  -1,     -1, -1,   -1,   26,   -1,  -1,      -1,   -1},//q26
            { -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q27
            { 1,    5,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  11,  7,      13, -1,   -1,   26,   -1,  -1,      25,   -1}//q28
        };
        ignorarPila = false;
    }
    public boolean tokenValidoSintacticamente(Token token)
    {
        boolean valido = false;
        boolean pilaVacia = false;
        String palabra = token.getToken();
        String mensaje = " la palabra \""+palabra+"\" está fuera de lugar dentro de la instrucción ";
        char caracterDePila = 0;
        int i = -1;
        if(pila.vacia()&&estadoActual!=3)
        {
            pilaVacia = true;
            mensaje = "la palabra \""+palabra+"\" está de más.";
        }
        if(ignorarPila)
        {
            pila.agregarCaracter('z'); //Todas las transiciones que omiten la lectura de pila añaden un z0.
            ignorarPila = false;
        }
        caracterDePila = pila.getCaracterDeTope();
        if(!pilaVacia)
        {
            switch(palabra){
                case "AND": if(caracterDePila=='a') valido = transitable[estadoActual][i=15];
                            if(valido) pila.agregarCaracter('a');
                            break;
                case "ASIGNADOR": if(caracterDePila=='z') valido = transitable[estadoActual][i=3]||transitable[estadoActual][6];
                                  if(valido) pila.agregarCaracter('z');
                                  break;
                case "BREAK": if(caracterDePila=='c') valido = transitable[estadoActual][i=18];
                              if(valido) {pila.agregarCaracter('c');pila.agregarCaracter('z');}
                              break;
                case "COMA": if(caracterDePila=='z') valido = transitable[estadoActual][i=2];
                             if(valido) pila.agregarCaracter('z');
                             break;
                case "CONTINUE": if(caracterDePila=='c') valido = transitable[estadoActual][i=18];
                                 if(valido) {pila.agregarCaracter('c');pila.agregarCaracter('z');}
                                 break;
                case "DISTINTO": if(caracterDePila=='a') valido = transitable[estadoActual][i=14];
                                 if(valido) pila.agregarCaracter('a');
                                 break;
                case "DIVISION": if(estadoActual==8||estadoActual==10){if(caracterDePila=='a'||caracterDePila=='z') valido = transitable[estadoActual][i=8];}
                                 else if(caracterDePila=='a') valido = transitable[estadoActual][8];
                                 break;
                case "DIVIDIDONUMERO": if(caracterDePila=='z') valido = transitable[estadoActual][i=6];
                                       if(valido) pila.agregarCaracter('z');
                                       break;
                case "DOUBLE": if(estadoActual==3&&caracterDePila=='e') valido = transitable[estadoActual][i=0];
                               if(caracterDePila=='z') valido = transitable[estadoActual][0];
                               if(valido) pila.agregarCaracter('z');
                               break;
                case "IDENTIFICADOR": if(estadoActual==3&&caracterDePila=='e')valido=transitable[estadoActual][i=1];
                                      if(estadoActual==7||estadoActual==9){if(caracterDePila=='a'||caracterDePila=='z')valido=transitable[estadoActual][1];}
                                      else{
                                        if(estadoActual==14||estadoActual==16||estadoActual==18||estadoActual==20||estadoActual==21||estadoActual==23){if(caracterDePila=='a'||caracterDePila=='b')valido=transitable[estadoActual][1];}
                                        else if(caracterDePila=='z')valido=transitable[estadoActual][1];
                                      }
                                      if(valido&&(caracterDePila=='e'||caracterDePila=='z')) pila.agregarCaracter('z');
                                      if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                      break;
                case "IF": if(estadoActual==3&&caracterDePila=='e') valido = transitable[estadoActual][i=13];
                           if(caracterDePila=='z') valido = transitable[estadoActual][13];
                           if(valido)pila.agregarCaracter('z');
                           break;
                case "IGUAL": if(caracterDePila=='a') valido = transitable[estadoActual][i=14];
                              if(valido) pila.agregarCaracter('a');
                              break;
                case "ELSE": if(caracterDePila=='e') valido = transitable[estadoActual][i=17];
                             if(valido) pila.agregarCaracter('z');
                             break;
                case "LLAVEDER": if(caracterDePila=='c'||caracterDePila=='d') valido = transitable[estadoActual][i=20];
                                 break;
                case "LLAVEIZQ": if(caracterDePila=='c'||caracterDePila=='e') valido = transitable[estadoActual][i=19];
                                 if(valido&&caracterDePila=='c') pila.agregarCaracter('c');
                                 if(valido&&caracterDePila=='e') {pila.agregarCaracter('e');pila.agregarCaracter('d');}
                                 break;
                case "LONG": if(estadoActual==3&&caracterDePila=='e') valido = transitable[estadoActual][i=0];
                             if(caracterDePila=='z') valido = transitable[estadoActual][0];
                             if(valido) pila.agregarCaracter('z');
                             break;
                case "MAS": if(estadoActual==8||estadoActual==10){if(caracterDePila=='a'||caracterDePila=='z') valido = transitable[estadoActual][i=8];}
                            else if(caracterDePila=='a') valido = transitable[estadoActual][8];
                            break;
                case "MASUNO": if(caracterDePila=='z') valido = transitable[estadoActual][i=5];
                               if(valido) pila.agregarCaracter('z');
                               break;
                case "MASNUMERO": if(caracterDePila=='z') valido = transitable[estadoActual][i=6];
                                  if(valido) pila.agregarCaracter('z');
                                  break;
                case "MAYOR": if(caracterDePila=='a') valido = transitable[estadoActual][i=14];
                              if(valido) pila.agregarCaracter('a');
                              break;
                case "MAYORIGUAL": if(caracterDePila=='a') valido = transitable[estadoActual][i=14];
                                   if(valido) pila.agregarCaracter('a');
                                   break;
                case "MENOR": if(caracterDePila=='a') valido = transitable[estadoActual][i=14];
                              if(valido) pila.agregarCaracter('a');
                              break;
                case "MENORIGUAL": if(caracterDePila=='a') valido = transitable[estadoActual][i=14];
                                   if(valido) pila.agregarCaracter('a');
                                   break;
                case "MENOS": if(estadoActual==8||estadoActual==10){if(caracterDePila=='a'||caracterDePila=='z') valido = transitable[estadoActual][i=8];}
                              else if(caracterDePila=='a') valido = transitable[estadoActual][8];
                              break;
                case "MENOSUNO": if(caracterDePila=='z') valido = transitable[estadoActual][i=5];
                                 if(valido) pila.agregarCaracter('z');
                                 break;
                case "MENOSNUMERO": if(caracterDePila=='z') valido = transitable[estadoActual][i=6];
                                    if(valido) pila.agregarCaracter('z');
                                    break;
                case "NUMERO_DOUBLE": if(estadoActual==7||estadoActual==9){if(caracterDePila=='a'||caracterDePila=='z')valido=transitable[estadoActual][i=7];}
                                      else{
                                        if(estadoActual==14||estadoActual==16||estadoActual==18||estadoActual==20||estadoActual==21||estadoActual==23){if(caracterDePila=='a'||caracterDePila=='b')valido=transitable[estadoActual][7];}
                                      }
                                      break;
                case "NUMERO_LONG": if(estadoActual==7||estadoActual==9){if(caracterDePila=='a'||caracterDePila=='z')valido=transitable[estadoActual][i=7];}
                                    else{
                                      if(estadoActual==14||estadoActual==16||estadoActual==18||estadoActual==20||estadoActual==21||estadoActual==23){if(caracterDePila=='a'||caracterDePila=='b')valido=transitable[estadoActual][7];}
                                    }
                                    break;
                case "PARDER": if(estadoActual==8||estadoActual==20||estadoActual==22)
                               {
                                   if(caracterDePila=='a') valido=transitable[estadoActual][i=10];
                                   if(estadoActual==20&&caracterDePila=='b') valido=transitable[estadoActual][10];
                               }else{
                                   if(caracterDePila=='b') valido=transitable[estadoActual][10];
                               }
                               break;
                case "PARIZQ": if(estadoActual==7){
                                    if(caracterDePila=='z'){
                                        if(valido=transitable[estadoActual][i=9]){pila.agregarCaracter('z');pila.agregarCaracter('a');}
                                    }
                                    if(caracterDePila=='a'){
                                        if(valido=transitable[estadoActual][9]){pila.agregarCaracter('a');pila.agregarCaracter('a');}
                                    }
                               }else{
                                    if(caracterDePila=='z'&&estadoActual==13){
                                        if(valido=transitable[estadoActual][9]){pila.agregarCaracter('e');pila.agregarCaracter('a');}
                                    }
                                    if(caracterDePila=='z'&&estadoActual==26){
                                        if(valido=transitable[estadoActual][9]){pila.agregarCaracter('c');pila.agregarCaracter('a');}
                                    }
                                    if(caracterDePila=='a'){
                                        if(valido=transitable[estadoActual][9]){pila.agregarCaracter('a');pila.agregarCaracter('b');}
                                    }
                                    if(caracterDePila=='b'){
                                        if(valido=transitable[estadoActual][9]){pila.agregarCaracter('b');pila.agregarCaracter('b');}
                                    }
                                }
                               break;
                case "POR": if(estadoActual==8||estadoActual==10){if(caracterDePila=='a'||caracterDePila=='z') valido = transitable[estadoActual][8];}
                            else if(caracterDePila=='a') valido = transitable[estadoActual][i=8];
                            break;
                case "PORNUMERO": if(caracterDePila=='z') valido = transitable[estadoActual][i=6];
                                  if(valido) pila.agregarCaracter('z');
                                  break;
                case "PYCOMA": if(caracterDePila=='z') valido = transitable[estadoActual][i=4];
                               break;
                case "READ": if(estadoActual==3&&caracterDePila=='e') valido = transitable[estadoActual][i=11];
                             if(caracterDePila=='z') valido = transitable[estadoActual][11];
                             if(valido) pila.agregarCaracter('z');
                             break;
                case "OR": if(caracterDePila=='a') valido = transitable[estadoActual][i=15];
                           if(valido) pila.agregarCaracter('a');
                           break;
                case "WHILE": if(estadoActual==3&&caracterDePila=='e') valido = transitable[estadoActual][i=16];
                              if(caracterDePila=='z') valido = transitable[estadoActual][16];
                              if(valido) pila.agregarCaracter('z');
                              break;
                case "WRITE": if(estadoActual==3&&caracterDePila=='e') valido = transitable[estadoActual][i=12];
                              if(caracterDePila=='z') valido = transitable[estadoActual][12];
                              if(valido) pila.agregarCaracter('z');
                              break;
            }
            if(estadoActual==1) instruccionReconocida="declaración";
            if(estadoActual==5) instruccionReconocida="asignación";
            if(estadoActual==11) instruccionReconocida="read";
            if((estadoActual==7||estadoActual==3||estadoActual==25||estadoActual==28)&&palabra.equals("WRITE")) instruccionReconocida="write";
            if(estadoActual==13) instruccionReconocida = "if";
            if((estadoActual==0||estadoActual==3||estadoActual==25||estadoActual==28)&&palabra.equals("WHILE")) instruccionReconocida = "while";
            if(estadoActual==3&&palabra.equals("ELSE")) instruccionReconocida = "else";
            mensaje+=instruccionReconocida+".";
            if(!valido)
            {
                switch(estadoActual)
                {
                    case 1: mensaje+="\nSe esperaba un identificador."; break;
                    case 4: mensaje+="\nSe esperaba un identificador."; break;
                    case 6: mensaje+="\nSe esperaba un fin de oración (un punto y coma)."; break;
                    case 9: mensaje+="\nSe esperaba un número o una variable numérica."; break;
                    case 11: mensaje+="\nSe esperaba un identificador."; break;
                    case 12: mensaje+="\nSe esperaba un fin de oración (un punto y coma)."; break;
                    case 13: mensaje+="\nSe esperaba una apertura de condición (una apertura de paréntesis)."; break;
                    case 16: mensaje+="\nSe esperaba un número o una variable numérica."; break;
                    case 19: mensaje+="\nSe esperaba un número o una variable numérica."; break;
                    case 26: mensaje+="\nSe esperaba una apertura de condición (una apertura de paréntesis)."; break;
                    case 27: mensaje+="\nSe esperaba un fin de oración (un punto y coma)."; break;
                }
            }
            if(valido) estadoActual = transitaAEstado[estadoActual][i];
            if(estadoActual==20&&caracterDePila=='b') estadoActual-=2;
            if(estadoActual==3&&pila.verTope()!='e') ignorarPila = true;
            if(estadoActual==25&&pila.verTope()!='c'&&pila.verTope()!='d') ignorarPila = true;
        }
        if(!valido)
            System.err.println("Error sintáctico en línea "+token.getIndiceFila()+1+", caracter "+token.getIndiceComienzo()+1+": "+mensaje);
        return valido;
    }
}
