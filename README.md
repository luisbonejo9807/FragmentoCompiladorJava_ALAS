FragmentoCompiladorJava_ALAS
============================

Analizador Léxico y Analizador Sintáctico programados en Java hecho para la cátedra Compiladores

new commit/1° commit (hecho por JLCG17) añade:
* Proyecto Java vacío

2° commit (hecho por JLCG17) añade:
* AnalizadorLexico.java (vacío)
* AnalizadorSintactico.java (vacío)

3° commit (hecho por JLCG17) añade:
* Token.java
* Tokens.java (es un enum con los Tokens terminales a manejar por los analizadores)
* codigofuente.fjl (archivo donde está el código a analizar)
* código en AnalizadorLexico.java (la funcionalidad indispensable)
* código en el main para probar el AnalizadorLexico
* CodigoFuente.java (para abrir el archivo codigofuente.fjl)

4° commit (hecho por JLCG17) añade:
* funcionalidad para mostrar solo los errores que verá el usuario final por consola o ver también todos los tokens
* AnalizadorLexico ahora muestra una palabra errónea entera y no letra por letra por consola de usuario final

5° commit (hecho por JLCG17) añade:
* corrección del nombre de uno o más tokens del enum Tokens
* corrección a la prueba del analizador léxico en el main
* prueba aún no 100% funcional del analizador sintáctico en el main
* código nuevo en AnalizadorSintactico.java
* NodoSintactico.java para armar el árbol sintáctico que devolverá el analizador sintáctico
* sintaxis.txt como ayuda-memoria de la sintaxis que se desea evaluar con el analizador sintáctico

6° commit (hecho por JLCG17) añade:
* AutomataPilaSintaxis.java aún no funcional, pero con pila, matriz lógica y contador de estado actual.
* PilaDeCaracteres.java que sirve como pila para la clase AutomataPilaSintaxis.java

7° commit (hecho por JLCG17) añade:
* Documentación para los métodos de PilaDeCaracteres.java.
* Código funcional de AutomataPilaSintaxis.java (aún no terminado, pero incluye matriz para cambios de estado del autómata y validación sintáctica de un token por vez con algunos mensajes de error incluidos).

8° commit (hecho por JLCG17) añade:
* La clase AutomataPilaSintaxis.java ahora se llama AutomataPilaSintactico.java.
* Documentación de métodos en las clases modificadas en este commit.
* AutomataPilaSintactico.java ahora es funcional, aunque puede que se agreguen funcionalidades en el futuro.
* Como AutomataPilaSintactico.java es funcional, también lo es el análisis sintáctico para ponerlo a prueba.
* Se agregó la instrucción vacía a la sintáxis válida en sintaxis.txt (el analizador sintáctico lanza advertencia).
* Se simplificó el autómata: los estados 12, 16, 17, 25 y 27, que eran redundantes con los estados 3, 6, 14 y 15, ahora están comentados y no funcionales (se deja sus llaves al menos de momento para no cambiar la numeración).
* El autómata aparentemente permite anidamiento de if y else a capricho del programador, con y sin llaves.
* Queda pendiente lograr el anidamiento de while sin llaves y el código para armar el árbol sintáctico que devolverá el analizador sintáctico.

9° commit (hecho por JLCG17) añade:
* Ahora la sintáxis permite anidación de while sin llaves.
* El analizador sintáctico ahora no corta el análisis si se vacía la pila del autómata antes de lo debido por un error en el código fuente, intenta continuarlo.
* Nuevos mensajes de error del analizador sintáctico.
* Aparentemente el analizador sintáctico valida perfectamente cualquier capricho de while, if y else anidados, incluyendo las primitivas break y continue.
* Se añadió a sintaxis.txt la SECUENCIA vacía, de manera que AnalizadorSintactico.java toma por válido un código fuente vacío.
* Queda pendiente código para armar el árbol sintáctico que devolverá el analizador sintáctico.

10° commit (hecho por JLCG17) añade:
* Se simplifica el código de AutomataPilaSintactico.java.
* Se corrigen algunos defectos que había con el análisis de anidamiento de ifs, elses y whiles.
* Ahora el autómata no solo pasa al estado 3 cuando hay un error, también regresa el caracter usado con una palabra errónea a la pila para reducir la frecuencia de los efectos bola de nieve.
* Ahora los textos de consola de los analizadores tienen color: verde (manzana) para éxito y magenta (rosadito varonil) para advertencia, además del rojo para error que había.
* Las advertencias ahora usan el flujo de salida en vez del flujo de errores.
* Queda aún pendiente el código para armar el árbol sintáctico que devolverá el analizador sintáctico.

11° commit (hecho por JLCG17) añade:
* Se agregó documentación a los métodos de Token.java.
* ArbolSintactico.java para la gestión del conjunto de objetos NodoSintactico.
* Correcciones a NodoSintactico.java, de manera que un objeto NodoSintactico será de por vida terminal o no terminal.
* El método analizarSintaxis() de la clase AnalizadorSintactico ahora devuelve un objeto ArbolSintactico en vez de uno NodoSintactico.
* Se agregó la advertencia llaves vacías.
* Se corrigió un bug con llaves del else.
* Se simplificó la sintaxis de CONDICION en sintaxis.txt.
* Se completó el código que prueba el analizador sintáctico en la clase principal del proyecto.
* Se agregaron saltos de línea a la documentación de algunos métodos para hacerla más legible.
* BLOQUEBUCLE, en sintaxis.txt, admite derivación a lambda, al igual que SECUENCIA.
* Simplificación de SECUENCIA y BLOQUEBUCLE en sintaxis.txt.
* Se corrigieron defectos de AutomataPilaSintactico.java.
* Quedan defectos del analizador sintáctico pendientes para corregir tanto en AutomataPilaSintactico.java como en ArbolSintactico.java (siempre queda alguno o aparece uno nuevo).
* AnalizadorSemantico.java con constructor y su método principal: analizarSemantica().
* GeneradorDeCodigoIntermedio.java vacío.

