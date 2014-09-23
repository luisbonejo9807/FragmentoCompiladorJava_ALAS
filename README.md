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