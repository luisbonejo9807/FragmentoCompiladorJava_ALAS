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

