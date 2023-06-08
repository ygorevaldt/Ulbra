package Printables;

public class Document implements Printable{
    @Override
    public void print() {
        System.out.println("Imprimindo documento.");
    }
}
