
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;



@ManagedBean //sirve para que sobreentienda lo de login (usuario)
@RequestScoped
public class login {
    private String usuario;
    private String contraseña;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public void ingresar(){
         FacesContext context = FacesContext.getCurrentInstance();
       
        if (usuario.equals("admin")&&contraseña.equals("2")) {
        context.addMessage(null, new FacesMessage("usuario","Correcto"));
        }else{
        context.addMessage(null, new FacesMessage("usuario","Incorrecto"));

        }
    }
   //*
    
}
