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
     /**
      * Constructor vacio de la Clase
      */
    public Servicio() {
    }

    /**
     * Contructor que permite ingresar un 
     
     * @param nombres
     * @param descripcion
     * @param valor
     
     */
    public Servicio(String nombre, String descripcion, double valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
    }
    /**
     *   * Metodo que permite obtener el id de un servicio
     * @return id
     */
    public Integer getId() {
        return this.id;
    }
    /**
     * Metodo que permite ingresar el id del servicio
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Metodo que permite obtener el nombre de un servicio
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Metodo que permite ingresar el nombre del servicio
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo que permite obtener la descripcion de un servicio
     * @return descripcion
     */
    public String getDescripcion() {
        return this.descripcion;
    }
    /**
     * Metodo que permite ingresar la descripcion del servicio
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Metodo que permite obtener el valor de un servicio
     * @return
     */
    public double getValor() {
        return this.valor;
    }
    /**
     * Metodo que permite ingresar el valor del servicio
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
}


