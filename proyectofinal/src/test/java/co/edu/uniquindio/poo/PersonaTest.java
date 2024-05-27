package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PersonaTest {
    private static Logger LOG = Logger.getLogger(PersonaTest.class.getName());

    /*
     * Prueba para verificar que un usuario no tenga datos nulos
     */
    @Test
    public void datosNulos() {
        LOG.info("Inicio test datosNulos");
        Persona persona = new Persona("Juan", "Carmona");
        assertThrows(Throwable.class, () -> new Persona(null, null));
        LOG.info("Finalización test datosNulos");
    }

    /*
     * Test para verificar que los datos no esten vacios
     */
    @Test
    public void datosVacios() {
        LOG.info("Iniciando test datosVacios");

        assertThrows(Throwable.class, () -> new Persona(" ", " "));
        LOG.info("Finalizando test datosVacios");
    }

}
