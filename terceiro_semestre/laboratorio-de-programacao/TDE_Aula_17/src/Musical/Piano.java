package Musical;

public class Piano implements Musical {
    @Override
    public void play() {
        System.out.println("Tocar piano");
    }

    @Override
    public void stop() {
        System.out.println("Parar de tocar piano");
    }

    @Override
    public void pause() {
        System.out.println("Fazer pausa da piano");
    }
}
