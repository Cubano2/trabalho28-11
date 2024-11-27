package Races;

import HablidadesG.*;

public class Androids extends PersonagemBase {
    public Androids(String nome, int vida, int velocidade, int forca) {
        super(nome, vida, velocidade, forca);
    }

    public void fastRegen() {
        this.vida = Math.min(this.vida * 1.2, 1000); // Regenera até o máximo permitido (exemplo: 1000)
        System.out.println(nome + " usou Fast Regen e regenerou sua vida! Nova vida: " + this.vida);
    }

    @Override
    protected void adicionarHabilidades() {
        super.adicionarHabilidades();
        habilidades.add(new Nonstop());
    }
}