package Musical;

public class Guitar implements Musical {
    @Override
    public void play() {
        System.out.println("Tocar guitarra");
    }

    @Override
    public void stop() {
        System.out.println("Parar de tocar guitarra");
    }

    @Override
    public void pause() {
        System.out.println("Fazer pausa da guitarra");
    }
}
