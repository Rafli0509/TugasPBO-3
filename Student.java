import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String nim;
    private String name;
    private double score;
    private String grade;
    private boolean isPass;

    public Student(String nim, String name, double score) {
        this.nim = nim;
        this.name = name;
        this.score = score;
        setGradeAndStatus();
    }

    private void setGradeAndStatus() {
        if (score < 0 || score > 100) {
            grade = "Invalid";
            isPass = false;
        } else if (score >= 80) {
            grade = "A";
            isPass = true;
        } else if (score >= 70) {
            grade = "B";
            isPass = true;
        } else if (score >= 60) {
            grade = "C";
            isPass = true;
        } else if (score >= 50) {
            grade = "D";
            isPass = false;
        } else {
            grade = "E";
            isPass = false;
        }
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    public boolean isPass() {
        return isPass;
    }
}
