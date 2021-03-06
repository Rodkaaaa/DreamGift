
package Clases;

import Objetos.Cnn;
import Objetos.OComuna;
import Objetos.OError;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CComuna {
    
    private final Connection cnn;
    private final String TagCodigoClase = "CUSUARIO - %s";
    
    public CComuna(){
        
        cnn = Cnn.getConnection();
    }
    public OError Insertar(String COM_NOMBRE,String COM_ESTADO){
        CMysqlHelp con = new CMysqlHelp();
        OError Error = con.Conectar();
       
        if (Error.isConfirma()){ 
            int r = 0;
            String consulta= "INSERT INTO `dreamgifts`.`comuna` (`COM_NOMBRE`, `COM_ESTADO`) VALUES ('"+COM_NOMBRE+"', b'"+COM_ESTADO+"');";
            try{
               Statement  stm = (Statement) con.getCon().createStatement();
               r = stm.executeUpdate(consulta);
               Error = new OError("Clase Comuna","Comuna Agregada Correctamente",null,true);
            }catch(SQLException e){
                Error = new OError("Clase Comuna","Error"+ e,null,false);
                System.out.println(e);
            }finally{
                con.Desconectar();
            }
        }
        return Error;
    }
         
    public int Eliminar(String COM_ID){
        int r = 0;
        String consulta= "delete from dreamgifts.comuna where COM_ID = '"+COM_ID+"';";
       try{
          Statement  stm = (Statement) cnn.createStatement();
          r = stm.executeUpdate(consulta);
       }catch(SQLException e){
           System.out.println(e);
       }finally{
           return r;
       }
        
    }
     public int Editar(String COM_ID,String COM_NOMBRE,String COM_ESTADO){
        int r = 0;
        String consulta= "UPDATE `dreamgifts`.`comuna` SET `COM_NOMBRE` = '"+COM_NOMBRE+"', `COM_ESTADO` = '"+COM_ESTADO+"' WHERE (`COM_ID` = '"+COM_ID+"');";
       try{
          Statement  stm = (Statement) cnn.createStatement();
          r = stm.executeUpdate(consulta);
       }catch(SQLException e){
           System.out.println(e);
       }finally{
           return r;
       }
        
    }
    
    public ResultSet getConsulta() {
       ResultSet rs =null;
       try{
           Statement  stm = (Statement) cnn.createStatement();
           rs = stm.executeQuery("SELECT * FROM `comuna` ");
       }catch(SQLException e){
           System.out.print(e);
       }
       
       return rs;
        
    }
    
    public List<OComuna> Listar(){
        PreparedStatement Preparando = null;
        ResultSet Resultado = null;
        List<OComuna> Listado = new ArrayList();
        CMysqlHelp Sql = new CMysqlHelp();
        OError Error = Sql.Conectar();
        if(Error.isConfirma()){
            try {
                Preparando = Sql.getCon().prepareStatement("SELECT * FROM comuna");
                Resultado = Preparando.executeQuery();
                
                while(Resultado.next()){
                    Listado.add(new OComuna(Resultado.getInt(1), Resultado.getString(2), Resultado.getBoolean(3)));
                }
                Error = new OError(String.format(TagCodigoClase, 10), "Consulta Realizada Corectamente", null, true);
                
                Resultado.close();
                Preparando.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                Error = new OError(String.format(TagCodigoClase, 11), String.format("<html>%s (Codigo %s)</html>", ex, String.format(TagCodigoClase, 11)), null, false);
            }
            finally{
                Sql.Desconectar();
            }
        }
        return Listado;
    }
           
    
}
