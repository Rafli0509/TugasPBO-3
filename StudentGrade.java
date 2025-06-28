import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        while (true) {
            System.out.println("\n=== Input Data Mahasiswa ===");
            System.out.print("Masukkan NIM (atau 'exit' untuk selesai): ");
            String nim = scanner.nextLine();
            
            if (nim.equalsIgnoreCase("exit")) {
                break;
            }
            
            System.out.print("Masukkan Nama: ");
            String name = scanner.nextLine();
            
            System.out.print("Masukkan Nilai: ");
            double score;
            try {
                score = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input nilai anda salah! Harus berupa angka.");
                continue;
            }
            
            Student student = new Student(nim, name, score);
            students.add(student);
        }
        
        // Menampilkan data dan menghitung rata-rata
        if (students.isEmpty()) {
            System.out.println("\nTidak ada data mahasiswa yang dimasukkan.");
            return;
        }
        
        System.out.println("\n=== Data Nilai Mahasiswa ===");
        System.out.println("---------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-5s | %-5s | %-10s |\n", 
                         "NIM", "Nama", "Nilai", "Grade", "Status");
        System.out.println("---------------------------------------------------");
        
        double totalScore = 0;
        int validCount = 0;
        
        for (Student student : students) {
            if (student.getScore() < 0 || student.getScore() > 100) {
                System.out.printf("| %-10s | %-20s | %-5.1f | %-5s | %-10s |\n",
                    student.getNim(), student.getName(), student.getScore(), 
                    "Invalid", "Input Salah");
                continue;
            }
            
            totalScore += student.getScore();
            validCount++;
            
            System.out.printf("| %-10s | %-20s | %-5.1f | %-5s | %-10s |\n",
                student.getNim(), student.getName(), student.getScore(), 
                student.getGrade(), student.isPass() ? "Lulus" : "Tidak Lulus");
        }
        System.out.println("---------------------------------------------------");
        
        if (validCount > 0) {
            double average = totalScore / validCount;
            System.out.printf("\nRata-rata nilai: %.2f\n", average);
        } else {
            System.out.println("\nTidak ada nilai valid untuk menghitung rata-rata.");
        }
        
        scanner.close();
    }
}