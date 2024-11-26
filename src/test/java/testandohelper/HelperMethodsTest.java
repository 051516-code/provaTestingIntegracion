package testandohelper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class HelperMethodsTest {

	@Test
	public void testCadastrarMotoboyDuplicado() {
	    metodosHelper hr = new metodosHelper();
	    hr.cadastrarMotoboy("Carlos");
	    hr.cadastrarMotoboy("Carlos");
	    List<String> motoboys = hr.listarMotoboys();
	    assertEquals(2, motoboys.size());
	}

	@Test
	public void testAdicionarOficinaDuplicada() {
		metodosHelper hr = new metodosHelper();
	    hr.adicionarOficina("Oficina X");
	    hr.adicionarOficina("Oficina X");
	    List<String> oficinas = hr.listarOficinas();
	    assertEquals(2, oficinas.size());
	}

	@Test
	public void testCadastrarMotoboyEntradaVazia() {
		metodosHelper hr = new metodosHelper();
	    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	        hr.cadastrarMotoboy("");
	    });
	    assertEquals("Nome do motoboy não pode ser vazio.", exception.getMessage());
	}

	@Test
	public void testAdicionarOficinaEntradaVazia() {
		metodosHelper hr = new metodosHelper();
	    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	        hr.adicionarOficina("");
	    });
	    assertEquals("Nome da oficina não pode ser vazio.", exception.getMessage());
	}

	@Test
	public void testInteracaoMotoboyComOficina() {
		metodosHelper hr = new metodosHelper();
	    hr.cadastrarMotoboy("José");
	    hr.adicionarOficina("Oficina Z");
	    String resultado = hr.selecionarOficina("Oficina Z");
	    assertEquals("Oficina selecionada: Oficina Z", resultado);
	    assertTrue(hr.listarMotoboys().contains("José"));
	}

}
