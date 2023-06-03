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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Catalogo;
import modelo.pojos.Categoria;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import utils.JavaUtils;

@Path("catalogo")
public class CatalogoWS {

    @Context
    private UriInfo context;

    public CatalogoWS() {
    }
    
    @POST
    @Path("registrarCatalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarCatalogo(
            @FormParam("idCatalogo") Integer idCatalogo,
            @FormParam("idCategoria") Integer idCategoria,
            @FormParam("nombre") String nombre,
            @FormParam("activo") String activo,
            @FormParam("orden") Integer orden){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String,Object> param = new HashMap<String, Object>();
            param.put("idCatalogo", idCatalogo);
            param.put("idCategoria", idCategoria);
            param.put("nombre", nombre);
            param.put("activo", activo);
            param.put("orden", orden);
            
            conn.insert("Catalogo.registrarCatalogo", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El catalogo ha sido registrado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo crear el catalogo...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @PUT
    @Path("actualizarCatalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarCatalogo(
            @FormParam("idCatalogo") Integer idCatalogo,
            @FormParam("idCategoria") Integer idCategoria,
            @FormParam("nombre") String nombre,
            @FormParam("activo") String activo,
            @FormParam("orden") Integer orden){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCatalogo", idCatalogo);
            param.put("idCategoria", idCategoria);
            param.put("nombre", nombre);
            param.put("activo", activo);
            param.put("orden", orden);
            
            conn.update("Catalogo.actualizarCatalogo", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El catalogo ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el catalogo...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @PUT
    @Path("actualizarEstatusCatalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusCatalogo(
            @FormParam("idCatalogo") Integer idCatalogo,
            @FormParam("activo") String activo){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCatalogo", idCatalogo);
            param.put("activo", activo);
            
            conn.update("Catalogo.actualizarEstatusCatalogo", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus de catalogo ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus de catalogo...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    // get catalogo por idCategoria
    @GET
    @Path("getCatalogosByCategoria/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogo> getCatalogosByCategoria(@PathParam("id") Integer id){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        List<Catalogo> catalogos = null;
        
        try{
            catalogos = conn.selectList("Catalogo.getCatalogosByCategoria", id);
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo obtener los catalogos...");
        }finally{
            conn.close();
        }
        return catalogos;
    }
    
    @GET
    @Path("getAllCategorias")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogo>getAllCatalogo(){
        List<Catalogo> list = new ArrayList<Catalogo>();
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
