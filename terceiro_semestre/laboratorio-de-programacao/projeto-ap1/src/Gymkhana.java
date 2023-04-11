public class Gymkhana {
    private String GymkhanaName;
    private int TotalStudents = 0;
    private Student WinningStudent;
    private int MaxPoints;

    public void setGymkhanaName(String name) {
        this.GymkhanaName = name;
    }

    public void setTotalStudents(int totalStudents) {
        this.TotalStudents = totalStudents;
    }

    public void setWinningStudent(Student student) {
        this.WinningStudent = student;
        int maxPoints = this.WinningStudent.getPoints();
        this.setMaxPoints(maxPoints);
    }

    public void setMaxPoints(int maxPoints) {
        this.MaxPoints = maxPoints;
    }

    public String getGymkhanaName() {
        return this.GymkhanaName;
    }

    public int getTotalStudents() {
        return this.TotalStudents;
    }

    public Student getWinningStudent() {
        return this.WinningStudent;
    }

    public int getMaxPoints() {
        return this.MaxPoints;
    }

    public void addStudent(Student student) {
        this.TotalStudents += 1;
    }
}
