/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojos;


public class ContactoEmergencia {
    private Integer idContacto;
    private Integer idPersonal;
    private String nombre;
    private String nombreCompleto;
    private String telefono1;
    private String telefono2;
    private String parentesco;  

    public ContactoEmergencia() {
    }

    public ContactoEmergencia(Integer idContacto, Integer idPersonal, String nombre, String nombreCompleto, String telefono1, String telefono2, String parentesco) {
        this.idContacto = idContacto;
        this.idPersonal = idPersonal;
        this.nombre = nombre;
        this.nombreCompleto = nombreCompleto;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.parentesco = parentesco;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
    

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    
    
    
}
