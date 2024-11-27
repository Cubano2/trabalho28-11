    package Races.Personagems;

    import HablidadesG.Absorver;
    import Races.PersonagemBase;

    public class Cell extends PersonagemBase {
        public int ki;

        public Cell(String nome, int vida, int velocidade, int forca, int ki) {
            super(nome, vida, velocidade, forca);
            this.ki = getKi();
        }



        @Override
        protected void adicionarHabilidades() {
            habilidades.add(new Absorver()); // Adiciona o ataque Absorver
        }
    }