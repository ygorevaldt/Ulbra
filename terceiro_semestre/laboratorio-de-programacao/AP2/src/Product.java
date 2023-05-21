public abstract class Product {
    String Title;
    boolean Status;

    public String getTitle() {
        return this.Title;
    }

    public String getStatus() {
        if (Status == true) {
            return "Disponível";
        }
        return "Indisponível";
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public void setStatus(boolean status) {
        this.Status = status;
    }

    public abstract String productDetails();
}