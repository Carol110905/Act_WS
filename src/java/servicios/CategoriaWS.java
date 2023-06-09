package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Categoria;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;

@Path("categoria")
public class CategoriaWS {

    @Context
    private UriInfo context;

    public CategoriaWS() {
    }

    @POST
    @Path("registrarCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarCategoria(
            @FormParam("idCatalogo") Integer idCatalogo,
            @FormParam("nombre") String nombre,
            @FormParam("activo") String activo,
            @FormParam("orden") Integer orden){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String,Object> param = new HashMap<String, Object>();
            param.put("idCatalogo", idCatalogo);
            param.put("nombre", nombre);
            param.put("activo", activo);
            param.put("orden", orden);
            
            conn.insert("Categoria.registrarCategoria", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("La categoria ha sido registrado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo crear la categoria...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @PUT
    @Path("actualizarCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarCategoria(
            @FormParam("idCatalogo") Integer idCatalogo,
            @FormParam("nombre") String nombre,
            @FormParam("activo") String activo,
            @FormParam("orden") Integer orden){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCatalogo", idCatalogo);
            param.put("nombre", nombre);
            param.put("activo", activo);
            param.put("orden", orden);
            
            conn.update("Categoria.actualizarCategoria", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("La categoria ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar la categoria...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @PUT
    @Path("actualizarEstatusCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusCategoria(
            @FormParam("idCatalogo") Integer idCatalogo,
            @FormParam("activo") String activo){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCatalogo", idCatalogo);
            param.put("activo", activo);
            
            conn.update("Categoria.actualizarEstatusCategoria", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus de categoria ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus de categoria...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @GET
    @Path("getAllCategorias")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria>getAllCatalogo(){
        List<Categoria> list = new ArrayList<Categoria>();
        SqlSession conn=null;
        try{
            conn=MyBatisUtil.getSession();
            list=conn.selectList("Categoria.getAllCategorias");
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
