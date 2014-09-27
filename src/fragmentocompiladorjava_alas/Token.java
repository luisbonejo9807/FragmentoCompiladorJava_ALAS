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
public class Token {
    private int indiceFila;
    private int indiceComienzo;
    private String token;
    private String tipo;

    public Token(String token, int indiceFila, int indiceComienzo) {
        this.indiceFila = indiceFila;
        this.indiceComienzo = indiceComienzo;
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIndiceFila() {
        return indiceFila;
    }

    public void setIndiceFila(int indiceFila) {
        this.indiceFila = indiceFila;
    }

    public int getIndiceComienzo() {
        return indiceComienzo;
    }

    public void setIndiceComienzo(int indiceComienzo) {
        this.indiceComienzo = indiceComienzo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
