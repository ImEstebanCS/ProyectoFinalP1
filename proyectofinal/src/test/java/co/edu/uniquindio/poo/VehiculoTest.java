package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
public class  VehiculoTest {
    private static final Logger LOG = Logger.getLogger(VehiculoTest.class.getName());

   /**
     * Prueba para verificar que los datos de un vehiculos no esten nulos
     */
    @Test
    public void datosNulos(){
        LOG.info("Inicio prueba datosNulos");
        assertThrows(Throwable.class, ()-> new Vehiculo(null, null, null));
        LOG.info("Finalizacion datosNulos");
    }
  
}