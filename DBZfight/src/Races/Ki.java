package Races;

import HablidadesG.*;

public class Ki extends PersonagemBase {
    public int ki;
    public int max_ki;

    public Ki(String nome, int vida, int velocidade, int forca, int ki) {
        super(nome, vida, velocidade, forca);
        this.ki = ki;
        this.max_ki = ki; // Corrigido para que max_ki receba o valor inicial de ki
    }

    public void carregarKi() {
        if (this.ki < this.max_ki) {
            this.ki += 0.33 * this.max_ki; // Usando this para referenciar a variável de instância
            if (this.ki > this.max_ki) {
                this.ki = this.max_ki;
            }
        }
    }

    @Override
    public int getKi() {
        return this.ki;
    }

    @Override
    public  int setKi(int newKi){
        this.ki = newKi;
        return this.ki;
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new Kamehameha(this.ki, 60)); // Adiciona Kamehameha com o valor de ki atual
    }
}
