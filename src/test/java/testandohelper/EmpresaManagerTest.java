package testandohelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class EmpresaManagerTest {

    private EmpresaManager empresaManager;
    private Empresa empresa;

    @BeforeEach
    public void setUp() {
        empresaManager = new EmpresaManager();
        // Crear una empresa de prueba
        List<String> serviceDays = Arrays.asList("Lunes", "Martes");
        List<String> serviceType = Arrays.asList("Consultoría", "Soporte");
        empresa = new Empresa("Banner1", "12345678000195", 1, "Empresa A", "Empresa A Ltda.", 
                              "empresa@a.com", "40.7128", "-74.0060", "Manhattan", "100", "555-1234", 
                              serviceDays, serviceType, "facebook.com/empresaA", "instagram.com/empresaA", "Calle 1");
    }

    @Test
    public void testAddEmpresa() {
        empresaManager.addEmpresa(empresa);
        assertEquals(1, empresaManager.getTotalEmpresas(), "La empresa debería ser añadida.");
    }

    @Test
    public void testAddEmpresaWithDuplicateCNPJ() {
        empresaManager.addEmpresa(empresa);
        Empresa duplicateEmpresa = new Empresa("Banner2", "12345678000195", 2, "Empresa B", "Empresa B Ltda.", 
                                               "empresaB@a.com", "40.7128", "-74.0060", "Manhattan", "200", "555-5678", 
                                               Arrays.asList("Miércoles", "Jueves"), Arrays.asList("Ventas"), 
                                               "facebook.com/empresaB", "instagram.com/empresaB", "Calle 2");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresaManager.addEmpresa(duplicateEmpresa));
        assertEquals("Ya existe una empresa con este CNPJ.", thrown.getMessage(), "Debería lanzar excepción por CNPJ duplicado.");
    }

    @Test
    public void testFindEmpresaByCNPJ() {
        empresaManager.addEmpresa(empresa);
        Empresa foundEmpresa = empresaManager.findEmpresaByCNPJ("12345678000195");
        assertNotNull(foundEmpresa, "La empresa debería ser encontrada por CNPJ.");
        assertEquals("Empresa A", foundEmpresa.getCompanyName(), "El nombre de la empresa no coincide.");
    }

    @Test
    public void testFindEmpresaByName() {
        empresaManager.addEmpresa(empresa);
        Empresa foundEmpresa = empresaManager.findEmpresaByName("Empresa A");
        assertNotNull(foundEmpresa, "La empresa debería ser encontrada por nombre.");
        assertEquals("12345678000195", foundEmpresa.getCnpj(), "El CNPJ de la empresa no coincide.");
    }

    @Test
    public void testUpdateEmpresa() {
        empresaManager.addEmpresa(empresa);
        empresaManager.updateEmpresa("12345678000195", "Empresa A Actualizada", "Empresa A Ltda. Actualizada", 
                                     "empresa_actualizada@a.com", "555-9999", Arrays.asList("Lunes", "Viernes"), 
                                     Arrays.asList("Consultoría", "Capacitación"), "facebook.com/empresaA_actualizada", 
                                     "instagram.com/empresaA_actualizada");
        Empresa updatedEmpresa = empresaManager.findEmpresaByCNPJ("12345678000195");
        assertEquals("Empresa A Actualizada", updatedEmpresa.getCompanyName(), "El nombre de la empresa no se actualizó correctamente.");
    }

    @Test
    public void testDeleteEmpresa() {
        empresaManager.addEmpresa(empresa);
        empresaManager.deleteEmpresa("12345678000195");
        assertNull(empresaManager.findEmpresaByCNPJ("12345678000195"), "La empresa debería ser eliminada.");
    }

    @Test
    public void testDeleteEmpresaNotFound() {
        empresaManager.addEmpresa(empresa);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresaManager.deleteEmpresa("12345678000196"));
        assertEquals("Empresa no encontrada.", thrown.getMessage(), "Debería lanzar excepción cuando no se encuentra la empresa.");
    }


    @Test
    public void testGetEmpresasByServiceType() {
        empresaManager.addEmpresa(empresa);
        List<Empresa> result = empresaManager.getEmpresasByServiceType("Consultoría");
        assertFalse(result.isEmpty(), "Debería encontrar empresas que ofrezcan Consultoría.");
    }

    @Test
    public void testGetEmpresasByServiceDay() {
        empresaManager.addEmpresa(empresa);
        List<Empresa> result = empresaManager.getEmpresasByServiceDay("Lunes");
        assertFalse(result.isEmpty(), "Debería encontrar empresas que ofrezcan servicio el Lunes.");
    }

    @Test
    public void testClearAllEmpresas() {
        empresaManager.addEmpresa(empresa);
        empresaManager.clearAllEmpresas();
        assertEquals(0, empresaManager.getTotalEmpresas(), "Todas las empresas deberían haber sido eliminadas.");
    }

    @Test
    public void testIsCNPJTaken() {
        empresaManager.addEmpresa(empresa);
        assertTrue(empresaManager.isCNPJTaken("12345678000195"), "El CNPJ debería estar registrado.");
        assertFalse(empresaManager.isCNPJTaken("99999999000100"), "El CNPJ no debería estar registrado.");
    }
}

