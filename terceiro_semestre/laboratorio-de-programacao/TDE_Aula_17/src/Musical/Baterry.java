package Musical;

public class Baterry implements Musical {
    @Override
    public void play() {
        System.out.println("Tocar bateria");
    }

    @Override
    public void stop() {
        System.out.println("Parar de tocar bateria");
    }

    @Override
    public void pause() {
        System.out.println("Fazer pausa da bateria");
    }
}
