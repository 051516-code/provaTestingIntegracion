package testandohelper;

import java.util.ArrayList;
import java.util.List;

public class metodosHelper {
    private List<String> motoboys = new ArrayList<>();
    private List<String> oficinas = new ArrayList<>();


    public List<String> listarMotoboys() {
        return motoboys;
    }

    public List<String> listarOficinas() {
        return oficinas;
    }

    public String selecionarOficina(String nome) {
        if (oficinas.contains(nome)) {
            return "Oficina selecionada: " + nome;
        } else {
            throw new IllegalArgumentException("Oficina não encontrada.");
        }
    }
    
    public void cadastrarMotoboy(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do motoboy não pode ser vazio.");
        }
        motoboys.add(nome);
    }

    public void adicionarOficina(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da oficina não pode ser vazio.");
        }
        oficinas.add(nome);
    }

}
