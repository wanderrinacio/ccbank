/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author wander
 */
@FacesValidator("UFValidator")
public class UFValidator implements Validator<Object> {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String uf = String.valueOf(value).toUpperCase();
        String[] listaUFs = {"AC", "AL", "MG"};
        boolean achou = false;
        int posicao = 0;
        do {
            achou = uf.equals(listaUFs[posicao]);
            posicao++;
        } while ((!achou) &&(posicao < listaUFs.length));
        if (!achou) {
            UtilMensagens.mensagemErro("UF:", "UF inválida informada");
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
