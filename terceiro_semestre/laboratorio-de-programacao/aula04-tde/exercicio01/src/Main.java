public class Main {
    public static void main(String[] args) {
        Relogio clock = new Relogio();
        System.out.println(clock.setClock(3, 5, 10));
        System.out.println(clock.readHour());
        System.out.println(clock.readMinute());
        System.out.println(clock.readSecond());
    }
}
  