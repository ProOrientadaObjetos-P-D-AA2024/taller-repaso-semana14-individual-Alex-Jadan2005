
package controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.datos;

public class enlace {
    public Connection conn;
    
    public void setConexion(){
        try{
            String url="jdbc:sqlite:db/data.db";
            conn=DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getConexion(){
        return conn;
    }
    
    //METODO PARA INSERTAR DATOS
    public void insertarData(datos d){
        try{
            setConexion();
            Statement s=getConexion().createStatement();
            String Data=String.format("INSERT INTO data (nombre, cedula, correo,telefono)"+"values('%s','%s','%s','%s')",d.getNombre(),d.getCedula(),d.getCorreo(),d.getTelefono());
            
            s.executeUpdate(Data);
            getConexion().close();
        }catch(SQLException e){
            System.out.println("Exception: insertarData");
            System.out.println(e.getMessage());
        }
    }
    //METODO PARA ELIMINAR DATOS
    public void eliminarData(datos d) {
        try {
            setConexion();
            Statement s = getConexion().createStatement();
            String Data = String.format("DELETE FROM data WHERE nombre = '%s' AND cedula = '%s';", d.getNombre(), d.getCedula());
            s.executeUpdate(Data);
            getConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: eliminarData");
            System.out.println(e.getMessage());
        }
    }
    
    //METODOS PARA ACTUALIZAR DATOS
    
    public void actualizarData(datos d) {
        try {
            setConexion();
            Statement s = getConexion().createStatement();
            String Data = String.format("UPDATE data SET nombre = '%s', correo = '%s', telefono = '%s' WHERE cedula = '%s';", 
                            d.getNombre(), d.getCorreo(), d.getTelefono(), d.getCedula());
            s.executeUpdate(Data);
            getConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: actualizarData");
            System.out.println(e.getMessage());
        }
    }
    
    //METODO PARA SUBIR LOS DATOS A LA BASE DE DATOS SQL
    public ArrayList<datos> getData(){
        ArrayList<datos> lista=new ArrayList<>();
        try{
            setConexion();
            Statement s=getConexion().createStatement();
            String Data="Select * from data;";
            ResultSet rs=s.executeQuery(Data);
            while(rs.next()){
                datos d=new datos(rs.getString("nombre"),rs.getString("cedula"),rs.getString("correo"),rs.getString("telefono"));
                lista.add(d);
            }
            getConexion().close();
        }catch(SQLException e){
            System.out.println("Exception: insertar");
            System.out.println(e.getMessage());
        }
        return lista;                
    }
    
}
