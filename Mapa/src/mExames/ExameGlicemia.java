package mExames;

class ExameGlicemia extends Paciente {
    private double quantidadeGlicose;

    public ExameGlicemia(String nome, String tipoSanguineo, int anoNascimento, double quantidadeGlicose) {
        super(nome, tipoSanguineo, anoNascimento);
        this.quantidadeGlicose = quantidadeGlicose;
    }

    @Override
    public void classificarResultado() {
        if (quantidadeGlicose < 100) {
            System.out.println("Normoglicemia");
        } else if (quantidadeGlicose < 126) {
            System.out.println("Pré-diabetes");
        } else {
            System.out.println("Diabetes estabelecido");
        }
    }

    @Override
    public void mostrarResultado() {
        System.out.println("Resultado do exame de glicemia: " + quantidadeGlicose);
    }

    @Override
    public void cadastrarExame(double valorExame) {
        quantidadeGlicose = valorExame;
    }
}

