package Races;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import HablidadesG.*;

public abstract class PersonagemBase {
    public String nome;
    public double vida;
    public int velocidade;
    public int forca;
    public List<HabilidadeP> habilidades;

    public PersonagemBase(String nome, int vida, int velocidade, int forca) {
        this.nome = nome;
        this.vida = vida;
        this.velocidade = velocidade;
        this.forca = forca;
        this.habilidades = new ArrayList<>();
        adicionarHabilidades();
    }

    public int getKi() {
        return -1; // Indica que este personagem não possui ki
    }

    public int setKi(int new_ki) {
        return -1;
    }



    protected void adicionarHabilidades() {
        habilidades.add(new Soco(this.forca)); // Não precisa passar a velocidade
        habilidades.add(new Chute(this.forca, 2));
    }

    public void usarHabilidadeAleatoria(PersonagemBase usuario,PersonagemBase inimigo) {
        if (habilidades.isEmpty()) {
            System.out.println(nome + " não possui habilidades para usar.");
            return;
        }

        Random random = new Random();
        int index = random.nextInt(habilidades.size());
        habilidades.get(index).usar(usuario, inimigo); // A velocidade agora é interna no personagem
    }


    public void receberDano(int dano) {
        vida = Math.max(vida - dano, 0);
        if (vida == 0) {
            System.out.println(nome + " foi derrotado!");
        }
    }
}