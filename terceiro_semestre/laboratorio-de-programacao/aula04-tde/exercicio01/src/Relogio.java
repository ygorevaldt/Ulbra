public class Relogio {
    Ponteiro pointerHour = new Ponteiro();
    Ponteiro pointerMinute = new Ponteiro();
    Ponteiro pointerSecond = new Ponteiro();

    public String setClock(int hour, int minute, int second) {
        if (hour > 12) {
            return "Hora inválida";
        }
        if (minute > 12) {
            return "Minuto inválido";
        }
        if (second > 12) {
            return "segundo inválido";
        }

        if (minute == 12 || second == 12) {
            minute = 00;
            second = 00;

            this.pointerMinute.position = minute;
            this.pointerSecond.position = second;
        }

        this.pointerHour.position = hour;
        this.pointerMinute.position = minute * 5;
        this.pointerSecond.position = second * 5;

        return this.pointerHour.position + ":" + this.pointerMinute.position + ":" + this.pointerSecond.position;
    }

    public String readHour() {
        return this.pointerHour.position + " horas";
    }

    public String readMinute() {
        return this.pointerMinute.position + " minutos";
    }

    public String readSecond() {
        return this.pointerSecond.position + " segundos";
    }

}
