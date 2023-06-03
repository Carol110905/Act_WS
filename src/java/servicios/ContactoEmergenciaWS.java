package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.ContactoEmergencia;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;


@Path("contactoEmergencia")
public class ContactoEmergenciaWS {
    
        @Context
    private UriInfo context;
public ContactoEmergenciaWS(){

}
    @POST
    @Path("registroContactoEmergencia")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarContactoEmergencia(
            @FormParam("idPersonal") String idPersonal,
            @FormParam("nombre") String nombre,
            @FormParam("nombreCompleto") String nombreCompleto,
            @FormParam("telefono1") String telefono1,
            @FormParam("telefono2") String telefono2,
            @FormParam("parentesco") String parentesco){
                 Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String,Object> param = new HashMap<String, Object>();
            param.put("idPersonal",idPersonal);
            param.put("nombre", nombre);
            param.put("nombreCompleto", nombreCompleto);
            param.put("telefono1", telefono1);
            param.put("telefono2", telefono2);
            param.put("parentesco", parentesco);
            
            conn.insert("ContactoEmergencia.registrarContactoEmergencia", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El ContactoEmergencia ha sido registrado");
            
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo crear el ContactoEmergencia...");
        }finally{
            conn.close();
        }
        return res;
    }
    
 @PUT
    @Path("actualizarContactoEmergencia")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarContactoEmergencia(
            @FormParam("idContacto") String idContacto,
            @FormParam("idPersonal") String idPersonal,
            @FormParam("nombre") String nombre,
            @FormParam("nombreCompleto") String nombreCompleto,
            @FormParam("telefono1") String telefono1,
            @FormParam("telefono2") String telefono2,
            @FormParam("parentesco") String parentesco){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idContacto", idContacto);
            param.put("idPersonal",idPersonal);
            param.put("nombre", nombre);
            param.put("nombreCompleto", nombreCompleto);
            param.put("telefono1", telefono1);
            param.put("telefono2", telefono2);
            param.put("parentesco", parentesco);
            
            conn.update("ContactoEmergencia.actualizarContactoEmergencia", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El ContactoEmergencia ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el ContactoEmergencia...");
        }finally{
            conn.close();
        }
        return res;
    }
    
   @GET
    @Path("getEmergenciaByIdPersonal/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactoEmergencia> getEmergenciaByIdPersonal(@PathParam("id") Integer id){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        List<ContactoEmergencia> personal = null;
        
        try{
            personal = conn.selectList("ContactoEmergencia.getEmergenciaByIdPersonal", id);
            System.out.println(personal.size());
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo obtener los personal...");
        }finally{
            conn.close();
        }
        return personal;
    }   

    @GET
    @Path("getAllContactoEmergencia")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactoEmergencia>getAllCatalogo(){
        List<ContactoEmergencia> list = new ArrayList<ContactoEmergencia>();
        SqlSession conn=null;
        try{
            conn=MyBatisUtil.getSession();
            list=conn.selectList("ContactoEmergencia.getAllContactoEmergencia");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return list;
    }  
    
}
