package mExames;

class ExameTriglicerideos extends Paciente {
    private double quantidadeTriglicerideos;

    public ExameTriglicerideos(String nome, String tipoSanguineo, int anoNascimento, double quantidadeTriglicerideos) {
        super(nome, tipoSanguineo, anoNascimento);
        this.quantidadeTriglicerideos = quantidadeTriglicerideos;
    }

    @Override
    public void classificarResultado() {
        int idade = calcularIdade(2023);
        if (idade <= 9 && quantidadeTriglicerideos < 75) {
            System.out.println("Triglicerídeos abaixo de 75 mg/dL");
        } else if (idade <= 19 && quantidadeTriglicerideos < 90) {
            System.out.println("Triglicerídeos abaixo de 90 mg/dL");
        } else if (quantidadeTriglicerideos < 150) {
            System.out.println("Triglicerídeos abaixo de 150 mg/dL");
        }
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Resultado do exame de triglicerídeos: " + quantidadeTriglicerideos);
    }

    @Override
    public void cadastrarExame(double valorExame) {
        quantidadeTriglicerideos = valorExame;
    }
}
