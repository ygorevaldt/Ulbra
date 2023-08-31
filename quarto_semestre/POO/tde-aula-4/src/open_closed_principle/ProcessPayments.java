package open_closed_principle;

// ERRADO
public class ProcessPayments {
    public void process(Card card) {
        if (!card.getNumber()) {
            return;
        }
        if (!card.isValid()) {
            return;
        }
        return card.pay();
    }
}

// CORRETO
public class ProcessPayments {
    public void process(Instrument instrument) {
        intrument.validate();
        instrument.pay();
    }
}