package Acceso_Datos;
import Entidades.Proyecto;
import java.sql.*;
import java.util.ArrayList;

public class ProyectoDAO {
    PreparedStatement ps;
    ResultSet rs;
    Proyecto pro;
    Conexion cn = new Conexion();

    public Connection getConexion() throws ClassNotFoundException,
            SQLException{
        Class.forName(cn.getDriver());
        return DriverManager.getConnection(cn.getUrl(), cn.getUser(), cn.getPass());
    }

    public  ArrayList<Proyecto> mostrar(){
        ArrayList<Proyecto> ListPro = new ArrayList<>();

        try{
            ps = getConexion().prepareStatement( "SELECT * FROM proyecto ");
            rs = ps.executeQuery();
            while (rs.next()){
                pro = new Proyecto(rs.getInt( 1),
                        rs.getString(2),
                        rs.getString(3));
                ListPro.add(pro);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ListPro;
    }

    public int guardar(Proyecto pProyecto){
        int result = 0;

        try{
            ps = getConexion().prepareStatement( "INSERT INTO " +
                    "proyecto(nombre, descripcion) values (?, ?)");
            ps.setString( 1,pProyecto.getNombre());
            ps.setString( 2,pProyecto.getDescripcion());

            result = ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public int eliminar(int pId){
        int result = 0;

        try{
            ps = getConexion().prepareStatement( "Delete from proyecto " +
                    "where id = ?");

            ps.setInt(1, pId);
            result = ps.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }



}
