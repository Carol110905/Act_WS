/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojos;


public class Personal {
    private Integer idPersonal;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String curp;
    private String rfc;
    private String fechaNacimiento;
    private String sexo;
    private String calle;
    private String colonia;
    private String numExt;
    private String numInt;
    private String cp;
    private String pais;
    private Integer idPais;
    private String entidadFederativa;
    private Integer idEntidadFederativa;
    private String municipio;
    private Integer idMunicipio;
    private String email;
    private String celular;
    private String estadoCivil;
    private String ultimoGradoEstudio;
    private String profecion;
    private String status;
    private Integer idEstatus;
    private String tiempoCreacion;
    private String tiempoActualizacion;

    public Personal(Integer idPersonal, String nombre, String apellidoPaterno, String apellidoMaterno, String curp, String rfc, String fechaNacimiento, String sexo, String calle, String colonia, String numExt, String numInt, String cp, String pais, Integer idPais, String entidadFederativa, Integer idEntidadFederativa, String municipio, Integer idMunicipio, String email, String celular, String estadoCivil, String ultimoGradoEstudio, String profecion, String status, Integer idEstatus, String tiempoCreacion, String tiempoActualizacion) {
        this.idPersonal = idPersonal;//este
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.curp = curp;
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.calle = calle;
        this.colonia = colonia;
        this.numExt = numExt;
        this.numInt = numInt;
        this.cp = cp;
        this.pais = pais;//este
        this.idPais = idPais;
        this.entidadFederativa = entidadFederativa;//este
        this.idEntidadFederativa = idEntidadFederativa;
        this.municipio = municipio;//este
        this.idMunicipio = idMunicipio;
        this.email = email;
        this.celular = celular;
        this.estadoCivil = estadoCivil;//este
        this.ultimoGradoEstudio = ultimoGradoEstudio;
        this.profecion = profecion;
        this.status = status;//este
        this.idEstatus = idEstatus;
        this.tiempoCreacion = tiempoCreacion;//este
        this.tiempoActualizacion = tiempoActualizacion;//este
    }

    public Personal() {
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public String getNumInt() {
        return numInt;
    }

    public void setNumInt(String numInt) {
        this.numInt = numInt;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public Integer getIdEntidadFederativa() {
        return idEntidadFederativa;
    }

    public void setIdEntidadFederativa(Integer idEntidadFederativa) {
        this.idEntidadFederativa = idEntidadFederativa;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getUltimoGradoEstudio() {
        return ultimoGradoEstudio;
    }

    public void setUltimoGradoEstudio(String ultimoGradoEstudio) {
        this.ultimoGradoEstudio = ultimoGradoEstudio;
    }

    public String getProfecion() {
        return profecion;
    }

    public void setProfecion(String profecion) {
        this.profecion = profecion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getTiempoCreacion() {
        return tiempoCreacion;
    }

    public void setTiempoCreacion(String tiempoCreacion) {
        this.tiempoCreacion = tiempoCreacion;
    }

    public String getTiempoActualizacion() {
        return tiempoActualizacion;
    }

    public void setTiempoActualizacion(String tiempoActualizacion) {
        this.tiempoActualizacion = tiempoActualizacion;
    }
    
    
}
