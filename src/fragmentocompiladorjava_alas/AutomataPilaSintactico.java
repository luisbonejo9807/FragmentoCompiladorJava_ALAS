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
public class AutomataPilaSintactico {
    private final boolean[][] transitable;
    private PilaDeCaracteres pila;
    private int estadoActual;
    private final int[][] transitaAEstado;
    private String instruccionReconocida;
    private int buclesAbiertos;
    public AutomataPilaSintactico()
    {
        transitable = new boolean[][]{
            //TIPO  ID    COMA   =     ;   ++/--  :=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL  {     }
            { true, true,false,false,false,false,false,false,false,false,false, true, true, true,false,false, true,false,false,false,false},//q0
            {false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q1
            {false,false, true, true, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q2
            { true, true,false,false,true,false,false,false,false,false,false, true, true, true,false,false, true, true, true,false, true},//q3
            {false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q4
            {false,false,false, true,false, true, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q5
            {false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q6
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q7
            {false,false,false,false, true,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false},//q8
            {false, true,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false},//q9
            {false,false,false,false, true,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false},//q10
            {false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},//q11
            {/*false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false*/},//q12
            {false,false,false,false,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false},//q13
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q14
            {false,false,false,false,false,false,false,false, true,false, true,false,false,false, true,false,false,false,false,false,false},//q15
            {/*false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false*/},//q16
            {/*false,false,false,false,false,false,false,false, true,false, true,false,false,false, true,false,false,false,false,false,false*/},//q17
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q18
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q19
            {false,false,false,false,false,false,false,false, true,false, true,false,false,false,false, true,false,false,false,false,false},//q20
            //TIPO  ID    COMA   =     ;   ++/--  :=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL  {     }
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q21
            {false,false,false,false,false,false,false,false,false,false, true,false,false,false,false, true,false,false,false,false,false},//q22
            {false, true,false,false,false,false,false, true,false, true,false,false,false,false,false,false,false,false,false,false,false},//q23
            { true, true,false,false, true,false,false,false,false,false,false, true, true, true,false,false, true,false, true, true,false},//q24
            {/* true, true,false,false, true,false,false,false,false,false,false, true, true, true,false,false, true,false,false,false, true*/},//q25
            {false,false,false,false,false,false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false},//q26
            {/*false,false,false,false, true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false*/},//q27
            { true, true,false,false, true,false,false,false,false,false,false, true, true, true,false,false, true,false, true, true,false}//q28
        };
        pila = new PilaDeCaracteres();
        estadoActual = 0;
        transitaAEstado = new int[][]{
            //TIPO  ID    COMA   =     ;   ++/--  :=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL  {     }
            { 1,    5,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  11,  7,      13, -1,   -1,   26,   -1,  -1,      -1,   -1},//q0
            { -1,   2,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q1
            { -1,   -1,   4,     7,    3,  -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q2
            { 1,    5,    -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  11,  7,      13, -1,   -1,   26,   28,  6,       -1,   3},//q3
            { -1,   2,    -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q4
            { -1,   -1,   -1,    7,    -1, 6,     7,  -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q5
            { -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q6
            { -1,   8,    -1,    -1,   -1, -1,    -1,  8,     -1,    9,    -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q7
            { -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     7,     -1,   10,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q8
            { -1,   8,    -1,    -1,   -1, -1,    -1,  8,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q9
            { -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     7,     -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q10
            { -1,   6,   -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q11
            {/* -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1*/},//q12
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     -1,    14,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q13
            { -1,   15,   -1,    -1,   -1, -1,    -1, 15,     -1,    14,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q14
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     14,    -1,   15,  -1,  -1,     -1, 18,   -1,   -1,   -1,  -1,      -1,   -1},//q15
            {/* -1,   15,   -1,    -1,   -1, -1,    -1, 15,     -1,    16,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1*/},//q16
            {/* -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     14,    -1,   17,  -1,  -1,     -1, 18,   -1,   -1,   -1,  -1,      -1,   -1*/},//q17
            { -1,   20,   -1,    -1,   -1, -1,    -1, 20,     -1,    19,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q18
            { -1,   20,   -1,    -1,   -1, -1,    -1, 20,     -1,    19,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q19
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     21,    -1,   24,  -1,  -1,     -1, -1,   23,   -1,   -1,  -1,      -1,   -1},//q20
            //TIPO  ID    COMA   =     ;   ++/--  :=  0..9|ID +-*/   (     )    READ WRITE   IF  COMP  &&||  WHILE ELSE CONTROL  {     }
            { -1,   20,   -1,    -1,   -1, -1,    -1, 20,     -1,    19,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q21
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     -1,    -1,   24,  -1,  -1,     -1, -1,   23,   -1,   -1,  -1,      -1,   -1},//q22
            { -1,   15,   -1,    -1,   -1, -1,    -1, 15,     -1,    14,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1},//q23
            { 1,    5,    -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  11,  7,      13, -1,   -1,   26,   -1,  6,       3,    -1},//q24
            {/* 1,    5,    -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  11,  7,      13, -1,   -1,   26,   -1,  -1,      -1,   3*/},//q25
            { -1,   -1,   -1,    -1,   -1, -1,    -1, -1,     -1,    14,   -1,  -1,  -1,     -1, -1,   -1,   26,   -1,  -1,      -1,   -1},//q26
            {/* -1,   -1,   -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  -1,  -1,     -1, -1,   -1,   -1,   -1,  -1,      -1,   -1*/},//q27
            { 1,    5,    -1,    -1,   3,  -1,    -1, -1,     -1,    -1,   -1,  11,  7,      13, -1,   -1,   26,   -1,  6,      3,   -1}//q28
        };
        buclesAbiertos = 0;
    }
    /**
     * Valida el siguiente token ya validado por el analizador léxico.
     * 
     * @param token Token
     * @return boolean (true si es válido sintácticamente, falso caso contrario)
     */
    public boolean tokenValidoSintacticamente(Token token)
    {
        boolean valido = false;
        boolean advertencia = false;
        boolean pilaVacia = false;
        String palabra = token.getToken();
        String mensaje = "la palabra \""+palabra+"\" está fuera de lugar dentro de la instrucción ";
        char caracterDePila;
        int i = -1;
        if(pila.vacia()&&estadoActual!=3)
        {
            pilaVacia = true;
            mensaje = "la pila del analizador se vació antes de lo esperado.";
        }
        if(pila.vacia())
        {
            switch(token.getTipo()){
                case "DOUBLE": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
                case "IDENTIFICADOR": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
                case "IF": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
                case "LONG": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
                case "NUMERO_DOUBLE": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
                case "NUMERO_LONG": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
                case "PYCOMA": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
                case "READ": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
                case "WHILE": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
                case "WRITE": if(estadoActual==3||estadoActual==24||estadoActual==28){pila.agregarCaracter('z');} break;
            }
        }else{
            if(pila.verTope()!='z')
            {
                switch(token.getTipo()){
                    case "DOUBLE": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                                   if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS")){pila.getCaracterDeTope();buclesAbiertos--;}
                                   if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                                   break;
                    case "IDENTIFICADOR": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                                          if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS"))pila.getCaracterDeTope();
                                          if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                                          break;
                    case "IF": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                               if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS")){pila.getCaracterDeTope();buclesAbiertos--;}
                               if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                               break;
                    case "LONG": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                                 if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS")){pila.getCaracterDeTope();buclesAbiertos--;}
                                 if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                                 break;
                    case "NUMERO_DOUBLE": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                                          if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS")){pila.getCaracterDeTope();buclesAbiertos--;}
                                          if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                                          break;
                    case "NUMERO_LONG": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                                        if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS")){pila.getCaracterDeTope();buclesAbiertos--;}
                                        if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                                        break;
                    case "PYCOMA": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                                   if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS")){pila.getCaracterDeTope();buclesAbiertos--;}
                                   if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                                   break;
                    case "READ": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                                 if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS")){pila.getCaracterDeTope();buclesAbiertos--;}
                                 if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                                 break;
                    case "WHILE": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                                  if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS")){pila.getCaracterDeTope();buclesAbiertos--;}
                                  if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                                  break;
                    case "WRITE": if(pila.verTope()=='e'&&(instruccionReconocida.equals("ENTONCESSI")||instruccionReconocida.equals("LLAVEDERSI")))pila.getCaracterDeTope();
                                  if(pila.verTope()=='c'&&instruccionReconocida.equals("ENTONCESMIENTRAS")){pila.getCaracterDeTope();buclesAbiertos--;}
                                  if(pila.verTope()!='z'&&(estadoActual==3||estadoActual==24||estadoActual==28)){pila.agregarCaracter('z');}
                                  break;
                }
                while(instruccionReconocida.equals("LLAVEDERWHILE")&&pila.verTope()=='e')pila.getCaracterDeTope();
            }
            if(pila.verTope()=='e'&&token.getTipo().equals("LLAVEDER")) pila.getCaracterDeTope();
        }
        try{
            caracterDePila = pila.getCaracterDeTope();
            System.out.println(palabra+" , "+caracterDePila+" (q"+estadoActual+")");
            if(!pilaVacia)
            {
                switch(token.getTipo()){
                    case "AND": if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][15];
                                if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                i=15;
                                break;
                    case "ASIGNADOR": if(caracterDePila=='z'){valido = transitable[estadoActual][3]||transitable[estadoActual][6];}
                                      if(valido) pila.agregarCaracter('z');
                                      i=3;
                                      break;
                    case "BREAK": if(buclesAbiertos>0&&(caracterDePila=='c'||caracterDePila=='d'||caracterDePila=='e'||caracterDePila=='f'||caracterDePila=='z')) valido = transitable[estadoActual][18];
                                  if(caracterDePila=='c')
                                  {
                                    while(!pila.vacia()) {
                                        if(pila.verTope()!='c')
                                            break;
                                        while(pila.verTope()=='c')
                                        {
                                            pila.getCaracterDeTope();
                                            if(pila.vacia()) break;
                                        }
                                    }
                                  }
                                  if(valido&&(caracterDePila=='c'||caracterDePila=='z')) {pila.agregarCaracter('z');}
                                  if(valido&&caracterDePila=='d') {pila.agregarCaracter('d');pila.agregarCaracter('z');}
                                  if(valido&&caracterDePila=='e') {pila.agregarCaracter('e');pila.agregarCaracter('z');}
                                  if(valido&&caracterDePila=='f') {pila.agregarCaracter('f');pila.agregarCaracter('z');}
                                  i=18;
                                  break;
                    case "COMA": if(caracterDePila=='z') valido = transitable[estadoActual][2];
                                 if(valido) pila.agregarCaracter('z');
                                 i=2;
                                 break;
                    case "CONTINUE": if(buclesAbiertos>0&&(caracterDePila=='c'||caracterDePila=='d'||caracterDePila=='f'||caracterDePila=='z')) valido = transitable[estadoActual][18];
                                     if(caracterDePila=='c')
                                     {
                                       while(!pila.vacia()) {
                                           if(pila.verTope()!='c')
                                               break;
                                           while(pila.verTope()=='c')
                                           {
                                               pila.getCaracterDeTope();
                                               if(pila.vacia()) break;
                                           }
                                        }
                                     }
                                     if(valido&&(caracterDePila=='c'||caracterDePila=='z')) {pila.agregarCaracter('z');}
                                     if(valido&&caracterDePila=='d') {pila.agregarCaracter('d');pila.agregarCaracter('z');}
                                     if(valido&&caracterDePila=='e') {pila.agregarCaracter('e');pila.agregarCaracter('z');}
                                     if(valido&&caracterDePila=='f') {pila.agregarCaracter('f');pila.agregarCaracter('z');}
                                     i=18;
                                     break;
                    case "DISTINTO": if(caracterDePila=='a') valido = transitable[estadoActual][14];
                                     if(valido) pila.agregarCaracter('a');
                                     i=14;
                                     break;
                    case "DIVISION": if(estadoActual==8||estadoActual==10){if(caracterDePila=='a'||caracterDePila=='z') valido = transitable[estadoActual][8];}
                                     else if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][8];
                                     if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                     if(valido&&caracterDePila=='b') pila.agregarCaracter('b');                 
                                     if(valido&&caracterDePila=='z') pila.agregarCaracter('z');
                                     i=8;
                                     break;
                    case "DIVIDIDONUMERO": if(caracterDePila=='z') valido = transitable[estadoActual][6];
                                           if(valido) pila.agregarCaracter('z');
                                           i=6;
                                           break;
                    case "DOUBLE": if(caracterDePila=='z') valido = transitable[estadoActual][0];
                                   if(valido) pila.agregarCaracter('z');
                                   i=0;
                                   break;
                    case "IDENTIFICADOR": if(estadoActual==7||estadoActual==9){if(caracterDePila=='a'||caracterDePila=='z')valido=transitable[estadoActual][1];}
                                          else{
                                            if(estadoActual>=14&&estadoActual<=23){if(caracterDePila=='a'||caracterDePila=='b')valido=transitable[estadoActual][1];}
                                            else if(caracterDePila=='z')valido=transitable[estadoActual][1];
                                          }
                                          if(valido&&(caracterDePila=='e'||caracterDePila=='z')) pila.agregarCaracter('z');
                                          if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                          if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                          i=1;
                                          break;
                    case "IF": if(caracterDePila=='z') valido = transitable[estadoActual][13];
                               if(valido)pila.agregarCaracter('z');
                               i=13;
                               break;
                    case "IGUAL": if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][14];
                                  if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                  if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                  i=14;
                                  break;
                    case "ELSE": if(estadoActual==3&&caracterDePila=='e') valido = transitable[estadoActual][17];
                                 if(valido&&caracterDePila=='e') pila.agregarCaracter('z');
                                 i=17;
                                 break;
                    case "LLAVEDER": if(caracterDePila=='d'||caracterDePila=='f') valido = transitable[estadoActual][20];
                                     if(valido&&caracterDePila=='f')buclesAbiertos--;
                                     i=20;
                                     break;
                    case "LLAVEIZQ": if(caracterDePila=='c'||caracterDePila=='e'||caracterDePila=='z') valido = transitable[estadoActual][19];
                                     if(valido&&caracterDePila=='c') pila.agregarCaracter('f');
                                     if(valido&&caracterDePila=='e') {pila.agregarCaracter('e');pila.agregarCaracter('d');}
                                     if(valido&&caracterDePila=='z') pila.agregarCaracter('d');
                                     i=19;
                                     break;
                    case "LONG": if(caracterDePila=='z') valido = transitable[estadoActual][0];
                                 if(valido) pila.agregarCaracter('z');
                                 i=0;
                                 break;
                    case "MAS": if(estadoActual==8||estadoActual==10){if(caracterDePila=='a'||caracterDePila=='z') valido = transitable[estadoActual][8];}
                                else if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][8];
                                if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                if(valido&&caracterDePila=='z') pila.agregarCaracter('z');
                                i=8;
                                break;
                    case "MASUNO": if(caracterDePila=='z') valido = transitable[estadoActual][5];
                                   if(valido) pila.agregarCaracter('z');
                                   i=5;
                                   break;
                    case "MASNUMERO": if(caracterDePila=='z') valido = transitable[estadoActual][6];
                                      if(valido) pila.agregarCaracter('z');
                                      i=6;
                                      break;
                    case "MAYOR": if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][14];
                                  if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                  if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                  i=14;
                                  break;
                    case "MAYORIGUAL": if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][14];
                                       if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                       if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                       i=14;
                                       break;
                    case "MENOR": if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][14];
                                  if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                  if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                  i=14;
                                  break;
                    case "MENORIGUAL": if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][14];
                                       if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                       if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                       i=14;
                                       break;
                    case "MENOS": if(estadoActual==8||estadoActual==10){if(caracterDePila=='a'||caracterDePila=='z') valido = transitable[estadoActual][8];}
                                  else if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][8];
                                  if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                  if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                  if(valido&&caracterDePila=='z') pila.agregarCaracter('z');
                                  i=8;
                                  break;
                    case "MENOSUNO": if(caracterDePila=='z') valido = transitable[estadoActual][5];
                                     if(valido) pila.agregarCaracter('z');
                                     i=5;
                                     break;
                    case "MENOSNUMERO": if(caracterDePila=='z') valido = transitable[estadoActual][6];
                                        if(valido) pila.agregarCaracter('z');
                                        i=6;
                                        break;
                    case "NUMERO_DOUBLE": if(estadoActual==7||estadoActual==9){if(caracterDePila=='a'||caracterDePila=='z')valido=transitable[estadoActual][7];}
                                          else{
                                            if(estadoActual>=14&&estadoActual<=23){if(caracterDePila=='a'||caracterDePila=='b')valido=transitable[estadoActual][7];}
                                          }
                                          if(valido&&caracterDePila=='z') pila.agregarCaracter('z');
                                          if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                          if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                          i=7;
                                          break;
                    case "NUMERO_LONG": if(estadoActual==7||estadoActual==9){if(caracterDePila=='a'||caracterDePila=='z')valido=transitable[estadoActual][7];}
                                        else{
                                          if(estadoActual>=14&&estadoActual<=23){if(caracterDePila=='a'||caracterDePila=='b')valido=transitable[estadoActual][7];}
                                        }
                                        if(valido&&caracterDePila=='z') pila.agregarCaracter('z');
                                        if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                        if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                        i=7;
                                        break;
                    case "PARDER": if(estadoActual==8||estadoActual==20||estadoActual==22)
                                   {
                                       if(caracterDePila=='a') valido=transitable[estadoActual][10];
                                       if((estadoActual==20||estadoActual==22)&&caracterDePila=='b') valido=transitable[estadoActual][10];
                                   }else{
                                       if(caracterDePila=='b') valido=transitable[estadoActual][10];
                                   }
                                   i=10;
                                   break;
                    case "PARIZQ": if(estadoActual==7){
                                        if(caracterDePila=='z'){
                                            if(valido=transitable[estadoActual][9]){pila.agregarCaracter('z');pila.agregarCaracter('a');}
                                        }
                                        if(caracterDePila=='a'){
                                            if(valido=transitable[estadoActual][9]){pila.agregarCaracter('a');pila.agregarCaracter('a');}
                                        }
                                   }else{
                                        if(caracterDePila=='z'&&estadoActual==13){
                                            if(valido=transitable[estadoActual][9]){pila.agregarCaracter('e');pila.agregarCaracter('a');}
                                        }
                                        if(caracterDePila=='z'&&estadoActual==26){
                                            if(valido=transitable[estadoActual][9]){pila.agregarCaracter('c');pila.agregarCaracter('a');buclesAbiertos++;}
                                        }
                                        if(caracterDePila=='a'){
                                            if(valido=transitable[estadoActual][9]){pila.agregarCaracter('a');pila.agregarCaracter('b');}
                                        }
                                        if(caracterDePila=='b'){
                                            if(valido=transitable[estadoActual][9]){pila.agregarCaracter('b');pila.agregarCaracter('b');}
                                        }
                                   }
                                   i=9;
                                   break;
                    case "POR": if(estadoActual==8||estadoActual==10){if(caracterDePila=='a'||caracterDePila=='z') valido = transitable[estadoActual][8];}
                                else if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][8];
                                if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                                if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                                if(valido&&caracterDePila=='z') pila.agregarCaracter('z');
                                i=8;
                                break;
                    case "PORNUMERO": if(caracterDePila=='z') valido = transitable[estadoActual][6];
                                      if(valido) pila.agregarCaracter('z');
                                      i=6;
                                      break;
                    case "PYCOMA": if(caracterDePila=='z') valido = transitable[estadoActual][4];
                                   i=4;
                                   break;
                    case "READ": if(caracterDePila=='z') valido = transitable[estadoActual][11];
                                 if(valido) pila.agregarCaracter('z');
                                 i=11;
                                 break;
                    case "OR": if(caracterDePila=='a'||caracterDePila=='b') valido = transitable[estadoActual][15];
                               if(valido&&caracterDePila=='a') pila.agregarCaracter('a');
                               if(valido&&caracterDePila=='b') pila.agregarCaracter('b');
                               i=15;
                               break;
                    case "WHILE": if(caracterDePila=='z') valido = transitable[estadoActual][16];
                                  if(valido) pila.agregarCaracter('z');
                                  i=16;
                                  break;
                    case "WRITE": if(caracterDePila=='z') valido = transitable[estadoActual][12];
                                  if(valido) pila.agregarCaracter('z');
                                  i=12;
                                  break;
                }
                if(estadoActual==1) instruccionReconocida="DECLARACION";
                if(estadoActual==2&&token.getTipo().equals("ASIGNADOR")) instruccionReconocida="DECLARACION Y ASIGNACIÓN";
                if(estadoActual==2&&token.getTipo().equals("COMA")) instruccionReconocida="DECLARACION LISTADA";
                if(estadoActual==5) instruccionReconocida="ASIGNACION";
                if(estadoActual==11) instruccionReconocida="LECTURA";
                if((estadoActual==7||estadoActual==3||estadoActual==28)&&token.getTipo().equals("WRITE")) instruccionReconocida="ESCRITURA";
                if(estadoActual==13) instruccionReconocida = "SI";
                if(estadoActual==24&&caracterDePila=='c') instruccionReconocida = "ENTONCESMIENTRAS";
                if(estadoActual==24&&caracterDePila=='e') instruccionReconocida = "ENTONCESSI";
                if(estadoActual==24&&token.getTipo().equals("LLAVEIZQ")&&instruccionReconocida.equals("ENTONCESSI")) instruccionReconocida = "LLAVEIZQSI";
                if(token.getTipo().equals("LLAVEDER")&&caracterDePila=='d') instruccionReconocida = "LLAVEDERSI";
                if(estadoActual==24&&token.getTipo().equals("LLAVEIZQ")&&instruccionReconocida.equals("ENTONCESMIENTRAS")) instruccionReconocida = "LLAVEIZQMIENTRAS";
                if(token.getTipo().equals("LLAVEDER")&&caracterDePila=='f') instruccionReconocida = "LLAVEDERMIENTRAS";
                if(estadoActual==28&&token.getTipo().equals("LLAVEIZQ")&&instruccionReconocida.equals("ELSE")) instruccionReconocida = "LLAVEIZQSINO";
                if(estadoActual==3&&token.getTipo().equals("LLAVEDER")&&caracterDePila=='z') instruccionReconocida = "LLAVEDERSINO";
                if((estadoActual==0||estadoActual==3||estadoActual==28)&&token.getTipo().equals("WHILE")) instruccionReconocida = "MIENTRAS";
                if(estadoActual==3&&token.getTipo().equals("ELSE")) instruccionReconocida = "SINO";
                if((estadoActual==3||estadoActual==24)&&token.getTipo().equals("BREAK")) instruccionReconocida = "ROMPER";
                if((estadoActual==3||estadoActual==24)&&token.getTipo().equals("CONTINUE")) instruccionReconocida = "CONTINUAR";
                if((estadoActual==3||estadoActual==24)&&token.getTipo().equals("PYCOMA")){instruccionReconocida = "INSTRUCCIÓN VACÍA";advertencia=true;}
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
                        case 13: mensaje+="\nSe esperaba una apertura de condición (una apertura de paréntesis)."; break;
                        case 14: mensaje+="\nSe esperaba un número o una variable numérica."; break;
                        case 19: mensaje+="\nSe esperaba un número o una variable numérica."; break;
                        case 26: mensaje+="\nSe esperaba una apertura de condición (una apertura de paréntesis)."; break;
                    }
                    if(token.getTipo().equals("BREAK")||token.getTipo().equals("CONTINUE")) mensaje="\""+palabra+"\" fuera de bucle.";
                }
                if(estadoActual==24&&token.getTipo().equals("ELSE")) mensaje="\nSe esperaba una instrucción entre el if y el else.";
                if((estadoActual==20||estadoActual==22)&&token.getTipo().equals("PARDER")&&caracterDePila=='b') mensaje+="\nParéntesis no cerrado.";
                if(valido) estadoActual = transitaAEstado[estadoActual][i];
                if(valido&&estadoActual==24&&caracterDePila=='b') estadoActual-=2;
            }
            if(advertencia)
            {
                mensaje="hay "+instruccionReconocida+".";
                System.err.println("Advertencia sintáctica en línea "+(token.getIndiceFila()+1)+", caracter "+(token.getIndiceComienzo()+1)+": "+mensaje);
            }
            if(!valido)
            {
                System.err.println("Error sintáctico en línea "+(token.getIndiceFila()+1)+", caracter "+(token.getIndiceComienzo()+1)+": "+mensaje);
                estadoActual=3;
            }
        }catch(NullPointerException exc){
            System.err.println("Error sintáctico en línea "+(token.getIndiceFila()+1)+", caracter "+(token.getIndiceComienzo()+1)+": "+mensaje);
        }
        
        return valido;
    }
    /**
     * Usar cuando se hayan terminado los tokens validados por el analizador léxico.
     * 
     * @return boolean (verdadero si la pila del autómata terminó vacía, falso caso contrario)
     */
    public boolean declararFinDeEntrada()
    {
        boolean sin_errores = true;
        if(estadoActual==3)
        {
            while(!pila.vacia())
            {
                if(pila.verTope()=='c'||pila.verTope()=='e')
                {
                    pila.getCaracterDeTope();
                    continue;
                }
                char c = pila.getCaracterDeTope();
                String mensaje="";
                switch(c){
                    case 'd': mensaje="un par de llaves de if no cierra."; sin_errores = false; break;
                    case 'f': mensaje="un par de llaves de while no cierra."; sin_errores = false; break;
                    case 'z': mensaje="un par de llaves de else no cierra."; sin_errores = false; break;
                }
                if(!mensaje.isEmpty())
                {
                    System.err.println("Error sintáctico: "+mensaje);
                    sin_errores = false;
                }
            }
        }else{
            System.err.println("Error sintáctico: el analizador no llegó a su estado final tras analizar el código fuente.\nEsto sugiere que hay al menos una instrucción incompleta o malformada (muy posiblemente al final).");
        }
        pila = new PilaDeCaracteres();
        instruccionReconocida="";
        estadoActual=0;
        return sin_errores;
    }
    /**
     *
     * @return String
     * @throws NullPointerException cuando no hay instrucción reconocida
     */
    public String getInstruccionReconocida() throws NullPointerException
    {
        if(instruccionReconocida.isEmpty()) throw new NullPointerException("No hay instrucción reconocida.");
        return instruccionReconocida;
    }
}
