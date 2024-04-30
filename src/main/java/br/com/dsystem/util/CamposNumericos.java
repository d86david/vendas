/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dsystem.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author david
 */
public class CamposNumericos extends PlainDocument {

    private int tamanhoMax = 4;

    public CamposNumericos(int tamMax) {
        tamanhoMax = tamMax;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        if (str == null) {
            return;
        }

        String stringAntiga = getText(0, getLength());
        int tamanhoNovo = stringAntiga.length() + str.length();

        if (tamanhoNovo <= tamanhoMax) {
            super.insertString(offs, str.replaceAll("[^0-9]", ""), a); // Para alterar o corpo dos métodos gerados, escolha Ferramentas/Modelos
        } else {
            super.insertString(offs, "", a); // Para alterar o corpo dos métodos gerados, escolha Ferramentas/Modelos
        }

    }
    
     public String completaCamposNumericos (String str){
        
        switch (str.length()){
            case 1 ->{
                return "000"+str;
            }
            case 2 ->{
                return "00"+str;
            }
            case 3 ->{
                return "0"+str;
            }
            case 4 ->{
                return str;
            }
            default->{
                return str.substring(0, 3);
            }
        }
    }
     

}
