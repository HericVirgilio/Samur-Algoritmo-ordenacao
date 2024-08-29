import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] salas = {"Clínica Médica", "Nutricionista", "Dermatologia", "Fisioterapia", "Oftalmologia", "Cardiologia", "Ginecologia", "Urologia",
                "Ultrassonografia de tireoide", "Papanicolau", "Ecocardiograma", "Teste Ergométrico", "Mamografia", "Exames Laboratoriais", "Mapeamento de Retina",
                "Tomografia de Tórax", "Ultrassonografia da Próstata", "Ultrassonografia das Mamas + Axilas", "Transvaginal","Ultrossonografia de Abdome Total"};

        Pessoa[] clientes = new Pessoa[10];

        clientes[0] = new Pessoa("Ana", 45, Pessoa.Genero.Feminino, true, true, false, 0, false, false, true, false, false);
        clientes[1] = new Pessoa("Beatriz", 48, Pessoa.Genero.Feminino, true, true, false, 0, false, false, true, false, false);
        clientes[2] = new Pessoa("Angelina", 30, Pessoa.Genero.Feminino, false, false, false, 0, false, false, true, false, false);
        clientes[3] = new Pessoa("Beatriz", 28, Pessoa.Genero.Feminino, false, false, false, 0, false, false, true, false, false);
        clientes[4] = new Pessoa("Adressa", 22, Pessoa.Genero.Feminino, false, false, false, 0, false, false, true, false, false);
        clientes[5] = new Pessoa("Lara", 22, Pessoa.Genero.Feminino, false, false, false, 0, false, false, true, false, false);
        clientes[6] = new Pessoa("Casio", 22, Pessoa.Genero.Masculino, true, true, true, 45, false, false, true, false, false);
        clientes[7] = new Pessoa("Seiko", 22, Pessoa.Genero.Masculino, true, true, false, 0, false, false, true, false, false);
        clientes[8] = new Pessoa("Alexandre", 45, Pessoa.Genero.Masculino, false, false, false, 0, false, false, true, false, false);
        clientes[9] = new Pessoa("Carlos", 35, Pessoa.Genero.Masculino, true, true, false, 0, false, false, true, false, false);


        int numPessoas = clientes.length;
        int numSalas = salas.length;

        // Realizar o agendamento
        for (int i = 0; i < numSalas; i++) {
            System.out.println("Rodada " + (i + 1) + ":");
            for (int j = 0; j < numPessoas; j++) {
                Pessoa cliente = clientes[j];
                String salaAtual = salas[(i + j) % numSalas];

                boolean agendado = false;

                // Tenta agendar o exame atual
                // Tenta agendar o exame ou consulta atual
                if (salaAtual.equals("Papanicolau") || salaAtual.equals("Transvaginal")) {
                    if (cliente.genero == Pessoa.Genero.Feminino && cliente.passouPeloGinecologista) {
                        System.out.println(cliente.nome + " -> " + salaAtual);
                        if (salaAtual.equals("Papanicolau")) cliente.fezPapanicolau = true;
                        if (salaAtual.equals("Transvaginal")) cliente.fezTransvaginal = true;
                        agendado = true;
                    }
                } else if (salaAtual.equals("Consulta com Ginecologista")) {
                    if (cliente.genero == Pessoa.Genero.Feminino) {
                        System.out.println(cliente.nome + " -> " + salaAtual);
                        cliente.passouPeloGinecologista = true;
                        agendado = true;
                    }
                } else if (salaAtual.equals("Ecocardiograma") || salaAtual.equals("Teste Ergométrico")) {
                    if (cliente.passouPeloCardiologista && (salaAtual.equals("Teste Ergométrico") && cliente.feitoJejum || !salaAtual.equals("Teste Ergométrico"))) {
                        System.out.println(cliente.nome + " -> " + salaAtual);
                        if (salaAtual.equals("Ecocardiograma")) cliente.fezEcocardiograma = true;
                        if (salaAtual.equals("Teste Ergométrico")) cliente.fezErgometrico = true;
                        agendado = true;
                    }
                } else if (salaAtual.equals("Consulta com Urologista")) {
                    if (cliente.genero == Pessoa.Genero.Masculino) {
                        System.out.println(cliente.nome + " -> " + salaAtual);
                        cliente.passouPeloUrologista = true;
                        agendado = true;
                    }
                } else if (salaAtual.equals("Ultrassonografia da Próstata")) {
                    if (cliente.genero == Pessoa.Genero.Masculino) {
                        System.out.println(cliente.nome + " -> " + salaAtual);
                        cliente.fezUltrassonografiaProstata = true;
                        agendado = true;
                    }
                } else if (salaAtual.equals("Ultrossonografia de Abdome Total") || salaAtual.equals("Ultrassonografia das Mamas + Axilas") ||
                        salaAtual.equals("Ultrassonografia de tireoide") || salaAtual.equals("Exames Laboratoriais")) {
                    if (cliente.feitoJejum) {
                        System.out.println(cliente.nome + " -> " + salaAtual);
                        agendado = true;
                    }
                } else if (salaAtual.equals("Tomografia de Tórax")) {
                    if (cliente.fumante) {
                        System.out.println(cliente.nome + " -> " + salaAtual);
                        agendado = true;
                    }
                } else if (salaAtual.equals("Mapeamento de Retina")) {
                    if (cliente.idade > 40 && cliente.impertenso && cliente.diabetico) {
                        System.out.println(cliente.nome + " -> " + salaAtual);
                        agendado = true;
                    }
                } else {
                    System.out.println(cliente.nome + " -> " + salaAtual);
                    agendado = true;
                }

// Se não agendado, tenta encontrar uma alternativa
                if (!agendado) {


                }
            System.out.println();
        }
    }
}

static class Pessoa {
    public String nome;
    public int idade;
    public Genero genero;
    public Boolean diabetico;
    public Boolean impertenso;
    public Boolean fumante;
    public int quantidadePorAno;
    boolean passouPeloGinecologista;
    boolean passouPeloCardiologista;
    boolean fezPapanicolau;
    boolean fezTransvaginal;
    boolean fezEcocardiograma;
    boolean fezErgometrico;
    boolean feitoJejum;
    boolean passouPeloUrologista;
    boolean fezUltrassonografiaProstata;

    public Pessoa(String nome, int idade, Genero genero, boolean diabetico, boolean impertenso, boolean fumante,
                  int quantidadePorAno, boolean passouPeloGinecologista, boolean passouPeloCardiologista,
                  boolean feitoJejum, boolean passouPeloUrologista, boolean fezUltrassonografiaProstata) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.diabetico = diabetico;
        this.impertenso = impertenso;
        this.fumante = fumante;
        this.quantidadePorAno = quantidadePorAno;
        this.passouPeloGinecologista = passouPeloGinecologista;
        this.passouPeloCardiologista = passouPeloCardiologista;
        this.fezPapanicolau = false;
        this.fezTransvaginal = false;
        this.fezEcocardiograma = false;
        this.fezErgometrico = false;
        this.feitoJejum = true;
        this.passouPeloUrologista = passouPeloUrologista;
        this.fezUltrassonografiaProstata = fezUltrassonografiaProstata;
    }

    enum Genero {
        Feminino,
        Masculino
    }

    @Override
    public String toString() {
        return nome;
    }
}
}
