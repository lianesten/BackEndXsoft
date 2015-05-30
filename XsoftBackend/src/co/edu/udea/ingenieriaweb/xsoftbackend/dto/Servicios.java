package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

import java.util.HashSet;
import java.util.Set;





public class Servicios  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String descripcion;
     private double valor;
     private Set serviciosventas = new HashSet(0);

    public Servicios() {
    }

	
    public Servicios(String nombre, String descripcion, double valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
    }
    
    public Servicios(String nombre, String descripcion, double valor, Set serviciosventas) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.valor = valor;
       this.serviciosventas = serviciosventas;
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


