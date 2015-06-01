package co.edu.udea.ingenieriaweb.xsoftbackend.seguridad;

/**
*
* @author Joaquin Hernandez
* En esta clase se especifican los algoritmos de cigrado que se podran utilizar para 
* generar los token de la aplicación
*/   
   public enum AlgoritmoCifradoJWT {
   HS256("HmacSHA256"),
   HS384("HmacSHA384"),
   HS512("HmacSHA512");
   private String value;
   private AlgoritmoCifradoJWT(String value) {
       this.value = value;
   }
   
   public String getValue() {
       return value;
   }
}