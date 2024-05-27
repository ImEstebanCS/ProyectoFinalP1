package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
public class  PropietarioTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    /**
     * Caso de prueba para validar a un propietario 
     */
    @Test
    public void datosCompletos() {
        LOG.info("Iniciado test datosCompletos");
        
        Propietario propietario = new Propietario("Pepito", "Perez");

        assertEquals("Pepito", propietario.getNombre());
        assertEquals("Perez", propietario.getApellido());
        assertEquals("10057898", propietario.getDocumento());
      
        LOG.info("Finalizando test datosCompletos");
    }
    /**
     * Prueba para verificar que los datos de un propietario no esten nulos
     */
    @Test
    public void datosNulos(){
        LOG.info("Inicio prueba datosNulos");
        assertThrows(Throwable.class, ()-> new Propietario(null, null));
        LOG.info("Finalizacion datosNulos");
    }
    /*prueba que verifica que no existan datos vacios */
    @Test
    public void datosVacios(){
        LOG.info("Inicio prueba datosVacios");
        assertThrows(Throwable.class, ()-> new Propietario("", ""));
        LOG.info("Finalizacion datosVacios");
    }


}