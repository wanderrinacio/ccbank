package utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UtilMensagens {
    
    public static void mensagemSucesso(String titulo, String mensagem){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem));
        context.getExternalContext().getFlash().setKeepMessages(true);
    }
    
    public static void mensagemErro(String titulo, String mensagem){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensagem));
        context.getExternalContext().getFlash().setKeepMessages(true);
    }
}
