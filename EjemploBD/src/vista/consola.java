
package vista;

import controlador.enlace;
import modelo.datos;
import java.sql.SQLException;

public class consola {
    public static void main(String[] args)throws SQLException {
        
        enlace c=new enlace();
        datos d=new datos("Alex","3050092331","willanjadan@gmail.com","0960652566");
        
        c.insertarData(d);
        for(int i=0;i<c.getData().size();i++){
            System.out.printf("%s",c.getData().get(i));
        }
        
        
    }

}
