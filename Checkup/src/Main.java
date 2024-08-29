import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        String[] salasNeutras = {
                "Consulta de clínica médica", "Consulta de Dermatologia", "Consulta de Fisioterapia",
                "Consulta de Oftalmologia", "Consulta de Cardiologia", "Exames laboratóriais1",
                "Exames laboratóriais2", "Exames laboratóriais3", "Ultrossonografia", "Consulta com Urologista",
                "Consulta com Ginecologista"
        };

        Pessoa[] clientes = new Pessoa[10];

        clientes[0] = new Pessoa("Ana", 39, Pessoa.Genero.Feminino, false, false, false, false, new String[0]);
        clientes[1] = new Pessoa("Beatriz", 39, Pessoa.Genero.Feminino, false, false, false, false, new String[0]);
        clientes[2] = new Pessoa("Yasmin", 39, Pessoa.Genero.Feminino, false, false, false, false, new String[0]);
        clientes[3] = new Pessoa("Yana", 39, Pessoa.Genero.Feminino, false, false, false, false, new String[0]);
        clientes[4] = new Pessoa("Julia", 42, Pessoa.Genero.Feminino, false, false, false, false, new String[0]);
        clientes[5] = new Pessoa("Lane", 43, Pessoa.Genero.Feminino, false, false, false, false, new String[0]);
        clientes[6] = new Pessoa("Torvalds", 35, Pessoa.Genero.Masculino, false, false, false, false, new String[0]);
        clientes[7] = new Pessoa("Julio Hamano", 33, Pessoa.Genero.Masculino, false, false, false, false, new String[0]);
        clientes[8] = new Pessoa("Bill Gates", 43, Pessoa.Genero.Masculino, false, false, false, false, new String[0]);
        clientes[9] = new Pessoa("Steve Jobs", 44, Pessoa.Genero.Masculino, false, false, false, false, new String[0]);

        int numPessoas = clientes.length;
        int numSalas = salasNeutras.length;

        for (int i = 0; i < numSalas; i++) {
            System.out.println("------------------- Rodada " + (i + 1) + " --------------------------");
            Set<String> usados = new HashSet<>(); // Conjunto para rastrear valores usados

            for (int j = 0; j < numPessoas; j++) {
                for (int k = 0; k < numSalas; k++) {
                    String sala = salasNeutras[k];
                    if (!clientes[j].jaRealizou(sala) && !usados.contains(sala)) {
                        clientes[j].adicionarProcedimento(sala);
                        System.out.println("Cliente: " + clientes[j].nome + " - Sala: " + sala);
                        usados.add(sala); // Marcar o valor como utilizado
                        break; // Sair do loop mais interno
                    }
                }
            }
        }
    }
}