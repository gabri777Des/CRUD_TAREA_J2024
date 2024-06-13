package Logica_Negocios;
import Acceso_Datos.ProyectoDAO;
import Entidades.Proyecto;
import java.util.ArrayList;

public class ProyectoBL {
    private static ProyectoDAO proDAO = new ProyectoDAO();

    public ArrayList<Proyecto> mostrar(){
        return proDAO.mostrar();
    }

    public int guardar(Proyecto pProyecto){
        return proDAO.guardar(pProyecto);
    }

    public  int eliminar(int pId){
        return proDAO.eliminar(pId);
    }

}
