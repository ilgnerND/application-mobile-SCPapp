package br.edu.unipampa.scpapp.View;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by JonerMello on 15/03/2017.
 */

public abstract class MascaraEntrada {

    /**
     * O Metodo recebe uma string formatada de acordo com a máscara que lhe foi atribuída
     * e retorna ela em sua forma original, sem a mesma.
     *
     * @param s
     * @return
     */
    public static String desmascarar(String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "")
                .replaceAll("[/]", "").replaceAll("[(]", "")
                .replaceAll("[)]", "");
    }

    /**
     * Método que associa a máscara a um campo EditText (segundo argumento passado)
     * TextWatcher Quando um objeto de um tipo está ligado a um editável, seus métodos será chamado quando o texto é alterado
     *
     * @param mask
     * @param ediTxt
     * @return
     */
    public static TextWatcher insert(final String mask, final EditText ediTxt) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = MascaraEntrada.desmascarar(s.toString());
                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if (m != '#' && str.length() > old.length()) {
                        mascara += m;
                        continue;
                    }
                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                ediTxt.setText(mascara);
                ediTxt.setSelection(mascara.length());
            }

            /**
             * Este método é chamado para notificar que s está prestes a ser substituído por um novo texto
             * @param s
             * @param start
             * @param count
             * @param after
             */
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }


            /**
             *  Este método é chamado para informar que em algum lugar dentro s, o texto foi alterado.
             * @param s
             */
            public void afterTextChanged(Editable s) {
            }
        };
    }
}
