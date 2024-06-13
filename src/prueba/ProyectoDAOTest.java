package prueba;
import java.util.ArrayList;
import Entidades.Proyecto;
import Logica_Negocios.ProyectoBL;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;
class ProyectoDAOTest {
    @org.junit.jupiter.api.Test
    @Order(2)
    void mostrar() {
        ProyectoBL proyectoBL = new ProyectoBL();
        ArrayList<Proyecto> proyecto = proyectoBL.mostrar();
        assertNotNull(proyecto,"La lista de estudiantes no debe ser nula" );
        assertFalse(proyecto.isEmpty(), "Lista no debe estar vacia");
    }
    @org.junit.jupiter.api.Test
    @Order(1)
    void guardar() {
        ProyectoBL proyectoBL = new ProyectoBL();
        Proyecto proyecto = new Proyecto("Rule 34", "╰(*°▽°*)╯");
        int result = proyectoBL.guardar(proyecto);
        assertEquals(1,result, "Debe devolver 1");
    }
    @org.junit.jupiter.api.Test
    @Order(3)
    void eliminar() {
        ProyectoBL proyectoBL = new ProyectoBL();
        int result = proyectoBL.eliminar(3);
        assertEquals(1, result, "Debería voler 1");
    }
}