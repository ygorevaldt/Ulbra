package interface_segregation_principle;

public class Robot implements Move {
    private String body = "corpo";
    private String arm = "braço";
    private String antenna = "Antenna";

    @Override;
    public void moveBody () {
        System.out.println("Mexendo"  + this.body);
    }

    @Override;
    public void moveArm () {
        System.out.println("Mexendo " + this.arm);
    }

    @Override;
    public void moveAntenna () {
        System.out.println("Mexendo " + this.antenna);
    }
}

public class NoAntennasRobot implements Move{
    private String body = "corpo";
    private String arm = "braço";

    @Override;
    public void moveBody () {
        System.out.println("Mexendo"  + this.body);
    }

    @Override;
    public void moveArm () {
        System.out.println("Mexendo " + this.arm);
    }

    @Override;
    public void moveAntenna () {
        System.out.println("Não tem antena");
    }
}

public class Robot implements Body, Arm, Antenna {
    private String body = "corpo";
    private String arm = "braço";
    private String antenna = "Antenna";

    @Override;
    public void moveBody () {
        System.out.println("Mexendo"  + this.body);
    }

    @Override;
    public void moveArm () {
        System.out.println("Mexendo " + this.arm);
    }

    @Override;
    public void moveAntenna () {
        System.out.println("Mexendo " + this.antenna);
    }
}

public class NoAntennasRobot implements Body, Arm {
    private String body = "corpo";
    private String arm = "braço";

    @Override;
    public void moveBody () {
        System.out.println("Mexendo"  + this.body);
    }

    @Override;
    public void moveArm () {
        System.out.println("Mexendo " + this.arm);
    }

}
