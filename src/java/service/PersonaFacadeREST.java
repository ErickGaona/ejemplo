/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Modelo.Persona;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Usuario
 */
@Stateless
@Path("modelo.persona")
public class PersonaFacadeREST extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "Ejemplo_prime_lojaPU")
    private EntityManager em;

    public PersonaFacadeREST() {
        super(Persona.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Persona entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Persona entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Persona find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> findAll() {
        return super.findAll();
    }
    @POST
    @Path("hola")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String holamundo(){
        return "Hola mundo";
    }
    @POST
    @Path("obtener")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona>datos(){
    return super.findAll();
    }
    @GET
    @Path("holanombre")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String holanombre(@QueryParam("nombre")String nombre){
        return "bienevenid"+nombre;
    }
    
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idCedula") String idCedula, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("ciudad") String ciudad,@FormParam("materia") String materia, @FormParam("carrera") String carrera){
       Persona ob = super.find(idCedula);
       ob.setNombre(nombre);
       ob.setApellido(apellido);
       ob.setCiudad(ciudad);
//       ob.setFechaNacimiento(fechaNacimiento);
       ob.setMateria(materia);
       ob.setCarrera(carrera);
      super.edit(ob);
     return "Se actualizo los datos";   
    }
    @POST
    @Path("eliminar")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String eliminarn(@FormParam("idCedula") String idCedula){
     Persona ob = super.find(idCedula);
     super.remove(ob);
     return "Se elimino con exito";
    }
    
    
    
    
     @GET
    @Path("suma")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public String sumaa (@QueryParam("num1")int num1,@QueryParam("num2")int num2){
    int res = num1+num2;
    return "El resultado es"+res;
    } 
    @POST
    @Path("sumass")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String sumaP (@FormParam("num1") int num1, @FormParam("num2") int num2){
      int resulta = num1+num2; 
      return "El resultado es"+resulta;
    }
    @POST
    @Path("sumasss")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String NumeroMayor (@FormParam("num1") int num1, @FormParam("num2") int num2){
        if (num1>num2) {
           return num1+"es mayor" ;
        }else{
                return num2+"es menor";
                }
    }
    
     @POST
     @Path("obtener_nombres")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona>leer_nombre(@FormParam("nombre")String nombre){
        TypedQuery consulta=getEntityManager().createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre",Persona.class);
        consulta.setParameter("nombre", nombre);
        return consulta.getResultList();
    }
    
    @POST
     @Path("CREAR")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String crear (@FormParam("idCedula") String id_Cedula, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido, @FormParam("ciudad") String ciudad, @FormParam("fechaNacimiento") Date fechaNacimiento, @FormParam("materia") String materia, @FormParam("carrera") String carrera){
    
        Persona per = new Persona(id_Cedula,nombre,apellido,ciudad,fechaNacimiento,materia, carrera);
//        per.setIdCedula(id_Cedula);
//        per.setNombre(nombre);
//        per.setApellido(apellido);
//        per.setCiudad(ciudad);
//        per.setFechaNacimiento(fecha_nacimiento);
//        per.setMateria(materia);
//        per.setCarrera(carrera);
        super.create(per);
        return "el obketo se inserto";
        
    }
  
    
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
  
    
    

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
