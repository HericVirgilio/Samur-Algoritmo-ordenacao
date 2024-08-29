import java.util.Arrays;

public class Pessoa {
    String nome;
    int idade;
    Genero genero;
    boolean passouPorGinecologista;
    boolean passouPorUrologista;
    boolean passouPorCardiologista;
    boolean lanchou;
    String[] procedimentosRealizados;

    public Pessoa(String nome, int idade, Genero genero, boolean passouPorGinecologista, boolean passouPorUrologista,
                  boolean passouPorCardiologista, boolean lanchou, String[] procedimentosRealizados) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.passouPorGinecologista = passouPorGinecologista;
        this.passouPorUrologista = passouPorUrologista;
        this.passouPorCardiologista = passouPorCardiologista;
        this.lanchou = lanchou;
        this.procedimentosRealizados = procedimentosRealizados;
    }

    public enum Genero {
        Feminino, Masculino
    }

    // Verifica se o procedimento já foi realizado
    public boolean jaRealizou(String procedimento) {
        for (String p : procedimentosRealizados) {
            if (procedimento.equals(p)) {
                return true;
            }
        }
        return false;
    }

    // Adiciona um novo procedimento
    public void adicionarProcedimento(String procedimento) {
        if (!jaRealizou(procedimento)) {
            procedimentosRealizados = adicionarAoFinal(procedimentosRealizados, procedimento);
        }
    }

    // Adiciona um elemento ao final de um array
    private String[] adicionarAoFinal(String[] array, String elemento) {
        String[] novoArray = Arrays.copyOf(array, array.length + 1);
        novoArray[novoArray.length - 1] = elemento;
        return novoArray;
    }
}