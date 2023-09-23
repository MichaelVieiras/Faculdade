package mExames;

abstract class Paciente {
    private String nome;
    private String tipoSanguineo;
    private int anoNascimento;

    public Paciente(String nome, String tipoSanguineo, int anoNascimento) {
        this.nome = nome;
        this.tipoSanguineo = tipoSanguineo;
        this.anoNascimento = anoNascimento;
    }

    public int calcularIdade(int anoAtual) {
        return anoAtual - anoNascimento;
    }

    public abstract void classificarResultado();
    public abstract void mostrarResultado();
    public abstract void cadastrarExame(double valorExame);
}
