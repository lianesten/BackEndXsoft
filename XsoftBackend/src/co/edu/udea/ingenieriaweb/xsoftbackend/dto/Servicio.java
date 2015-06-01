package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

import java.util.HashSet;
import java.util.Set;




/**
 * Clase DTO que contiene los atributos de la tabla Servicio
 * @author Joaquin Hernandez, Luis Zambrano
 *
 */
public class Servicio  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String descripcion;
     private double valor;

    public Servicio() {
    }

	
    public Servicio(String nombre, String descripcion, double valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
    }
    
    public Servicio(String nombre, String descripcion, double valor, Set serviciosventas) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.valor = valor;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getValor() {
        return this.valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }




}


