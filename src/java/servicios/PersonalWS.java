/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.pojos.Personal;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;


@Path("personal")
public class PersonalWS {
    
    @Context
    private UriInfo context;
    
    public PersonalWS(){
    
    }
    
    @POST
    @Path("/registroPersonal")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarPersonal(
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("curp") String curp,
            @FormParam("rfc") String rfc,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo,
            @FormParam("calle") String calle,
            @FormParam("colonia") String colonia,
            @FormParam("numExt") String numExt,
            @FormParam("numInt") String numInt,
            @FormParam("cp") Integer cp,
            @FormParam("idPais") Integer idPais,
            @FormParam("idEntidadFederativa") Integer idEntidadFederativa,
            @FormParam("idMunicipio") Integer idMunicipio,
            @FormParam("email") String email,
            @FormParam("celular") String celular,
            @FormParam("idEstadoCivil") Integer idEstadoCivil,
            @FormParam("ultimoGradoEstudio") String ultimoGradoEstudio,
            @FormParam("profecion") String profecion,
            @FormParam("idEstatus") Integer idEstatus){

             Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String,Object> param = new HashMap<String, Object>();
            param.put("nombre", nombre);
            param.put("apellidoPaterno",apellidoPaterno);
            param.put("apellidoMaterno", apellidoMaterno);
            param.put("curp", curp);
            param.put("rfc", rfc);
            param.put("fechaNacimiento", fechaNacimiento);
            param.put("sexo", sexo);
            param.put("calle", calle);
            param.put("colonia", colonia);
            param.put("numExt", numExt);
            param.put("numInt", numInt);
            param.put("cp", cp);
            param.put("idPais", idPais);
            param.put("idEntidadFederativa", idEntidadFederativa);
            param.put("idMunicipio", idMunicipio);
            param.put("email", email);
            param.put("celular", celular);
            param.put("idEstadoCivil", idEstadoCivil);
            param.put("ultimoGradoEstudio", ultimoGradoEstudio);
            param.put("profecion", profecion);
            param.put("idEstatus", idEstatus);
            
            conn.insert("Personal.registrar", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El personal ha sido registrado");
            
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo crear el personal...");
        }finally{
            conn.close();
        }
        return res;

    }
    
    
    @PUT
    @Path("/actualizarPersonal")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarPersonal(
            @FormParam("idPersonal") Integer idPersonal,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("curp") String curp,
            @FormParam("rfc") String rfc,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo,
            @FormParam("calle") String calle,
            @FormParam("colonia") String colonia,
            @FormParam("numExt") String numExt,
            @FormParam("numInt") String numInt,
            @FormParam("cp") Integer cp,
            @FormParam("idPais") Integer idPais,
            @FormParam("idEntidadFederativa") Integer idEntidadFederativa,
            @FormParam("idMunicipio") Integer idMunicipio,
            @FormParam("email") String email,
            @FormParam("celular") String celular,
            @FormParam("idEstadoCivil") Integer idEstadoCivil,
            @FormParam("ultimoGradoEstudio") String ultimoGradoEstudio,
            @FormParam("profecion") String profecion,
            @FormParam("idEstatus") Integer idEstatus){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idPersonal", idPersonal);
            param.put("nombre", nombre);
            param.put("apellidoPaterno",apellidoPaterno);
            param.put("apellidoMaterno", apellidoMaterno);
            param.put("curp", curp);
            param.put("rfc", rfc);
            param.put("fechaNacimiento", fechaNacimiento);
            param.put("sexo", sexo);
            param.put("calle", calle);
            param.put("colonia", colonia);
            param.put("numExt", numExt);
            param.put("numInt", numInt);
            param.put("cp", cp);
            param.put("idPais", idPais);
            param.put("idEntidadFederativa", idEntidadFederativa);
            param.put("idMunicipio", idMunicipio);
            param.put("email", email);
            param.put("celular", celular);
            param.put("idEstadoCivil", idEstadoCivil);
            param.put("ultimoGradoEstudio", ultimoGradoEstudio);
            param.put("profecion", profecion);
            param.put("idEstatus", idEstatus);
            
            conn.update("Personal.editar", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El personal ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el personal...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    
    @PUT
    @Path("/actualizarEstatusCatalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusCatalogo(
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("curp") String curp,
            @FormParam("rfc") String rfc,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("sexo") String sexo,
            @FormParam("calle") String calle,
            @FormParam("colonia") String colonia,
            @FormParam("numExt") String numExt,
            @FormParam("numInt") String numInt,
            @FormParam("cp") Integer cp,
            @FormParam("idPais") Integer idPais,
            @FormParam("idEntidadFederativa") Integer idEntidadFederativa,
            @FormParam("idMunicipio") Integer idMunicipio,
            @FormParam("email") String email,
            @FormParam("celular") String celular,
            @FormParam("idEstadoCivil") Integer idEstadoCivil,
            @FormParam("ultimoGradoEstudio") String ultimoGradoEstudio,
            @FormParam("profecion") String profecion,
            @FormParam("idEstatus") Integer idEstatus){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("nombre", nombre);
            param.put("apellidoPaterno",apellidoPaterno);
            param.put("apellidoMaterno", apellidoMaterno);
            param.put("curp", curp);
            param.put("rfc", rfc);
            param.put("fechaNacimiento", fechaNacimiento);
            param.put("sexo", sexo);
            param.put("calle", calle);
            param.put("colonia", colonia);
            param.put("numExt", numExt);
            param.put("numInt", numInt);
            param.put("cp", cp);
            param.put("idPais", idPais);
            param.put("idEntidadFederativa", idEntidadFederativa);
            param.put("idMunicipio", idMunicipio);
            param.put("email", email);
            param.put("celular", celular);
            param.put("idEstadoCivil", idEstadoCivil);
            param.put("ultimoGradoEstudio", ultimoGradoEstudio);
            param.put("profecion", profecion);
            param.put("idEstatus", idEstatus);
            
            conn.update("Personal.actualizarEstatusPersonal", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus de personal ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus de personal...");
        }finally{
            conn.close();
        }
        return res;
    }

    @GET
    @Path("/getPersonalByCategoria/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personal> getCatalogosByCategoria(@PathParam("id") Integer id){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        List<Personal> personal = null;
        
        try{
            personal = conn.selectList("Personal.getPersonalByCategoria", id);
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
    @Path("/getAllPersonal")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personal>getAllPersonal(){
        List<Personal> list = new ArrayList<Personal>();
        SqlSession conn=null;
        try{
            conn=MyBatisUtil.getSession();
            list=conn.selectList("Personal.getAllPersonal");
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
