package mExames;

class ExameColesterol extends Paciente {
    private double quantidadeLDL;
    private double quantidadeHDL;
    private char risco;

    public ExameColesterol(String nome, String tipoSanguineo, int anoNascimento, double quantidadeLDL, double quantidadeHDL) {
        super(nome, tipoSanguineo, anoNascimento);
        this.quantidadeLDL = quantidadeLDL;
        this.quantidadeHDL = quantidadeHDL;
    }

    @Override
    public void classificarResultado() {
        if (risco == 'B') {
            System.out.println("Risco Baixo");
        } else if (risco == 'M') {
            System.out.println("Risco Médio");
        } else {
            System.out.println("Risco Alto");
        }
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Resultado do exame de colesterol: LDL: " + quantidadeLDL + " mg/dL, HDL: " + quantidadeHDL + " mg/dL");
    }

    @Override
    public void cadastrarExame(double valorExame) {
        quantidadeLDL = valorExame * 0.8;  
        quantidadeHDL = valorExame * 0.6; 
        // Cálculo do risco com base nas quantidades de LDL e HDL
        if (quantidadeLDL < 50) {
            risco = 'A';
        } else if (quantidadeLDL < 70) {
            risco = 'M';
        } else {
            risco = 'B';
        }
    }
}

