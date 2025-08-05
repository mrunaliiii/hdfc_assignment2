import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;
    TrainingModule module;


    public Employee() {
        this(0, "Default", "DefaultDept");
        System.out.println("Default constructor called");
    }


    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void showDetails() {
        System.out.println("\nEmployee Info:");
        System.out.println("Name: " + name + " | ID: " + id + " | Department: " + department);
    }

    public int calculateBonus(int base) {
        return base / 10;
    }

    public int calculateBonus(int base, int rating) {
        return base * rating / 10;
    }

    public void setTrainingModule(String title, int duration) {
        this.module = new TrainingModule(title, duration);
    }

    public void showTrainingModule() {
        if (module != null) {
            System.out.println("\nTraining Module: " + module.title + " | Duration: " + module.durationInHrs + " hrs");
        }
    }
}

class TrainingModule {
    String title;
    int durationInHrs;

    public TrainingModule(String title, int durationInHrs) {
        this.title = title;
        this.durationInHrs = durationInHrs;
    }
}

class EmployeeUtils {
    public static boolean validateID(String idStr) {
        return idStr.matches("\\d{5}");
    }
}

class StringAnalyzer {
    public static void analyzeStrings(String input) {
        StringBuilder sb = new StringBuilder(input);
        System.out.println("\nOriginal: " + input);
        System.out.println("Reversed: " + sb.reverse());


        System.out.println("\nString is immutable, StringBuilder and StringBuffer are mutable.");


        String str1 = "HDFC";
        String str2 = "hdfc";
        System.out.println("\nString Comparison: HDFC equals hdfc → " + str1.equals(str2));
        System.out.println("String Comparison: HDFC compareTo HDFC → " + str1.compareTo("HDFC"));


        System.out.println("charAt(2): " + str1.charAt(2));
        System.out.println("substring(1,3): " + str1.substring(1, 3));
        System.out.println("indexOf('D'): " + str1.indexOf('D'));
    }
}

public class HDFCTrainingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        String idStr = sc.nextLine();
        boolean validID = EmployeeUtils.validateID(idStr);

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        int id = validID ? Integer.parseInt(idStr) : 0;
        Employee emp = new Employee(id, name, dept);
        emp.showDetails();
        System.out.println("Valid ID: " + validID);


        emp.setTrainingModule("Java Basics", 10);
        emp.showTrainingModule();


        int base = 5000;
        System.out.println("\nBonus (base " + base + "): " + emp.calculateBonus(base));
        System.out.println("Bonus (base " + base + ", rating 5): " + emp.calculateBonus(base, 5));


        System.out.print("\nEnter a sentence to reverse: ");
        String sentence = sc.nextLine();
        StringAnalyzer.analyzeStrings(sentence);


        System.out.print("\nEnter number of training scores: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            sum += scores[i];
            if (scores[i] > max) max = scores[i];
            if (scores[i] < min) min = scores[i];
        }

        System.out.print("Scores: ");
        for (int score : scores) System.out.print(score + " ");
        System.out.printf("\nAverage: %.2f | Max: %d | Min: %d\n", (float) sum / n, max, min);


        System.out.println("\nMultiplication Table:");
        int[][] table = new int[3][3];
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                table[i - 1][j - 1] = i * j;
                System.out.print(table[i - 1][j - 1] + " ");
            }
            System.out.println();
        }


        if (args.length >= 3) {
            int sumArgs = 0;
            for (int i = 0; i < 3; i++) {
                sumArgs += Integer.parseInt(args[i]);
            }
            System.out.println("\nSum from args: " + sumArgs);
        } else {
            System.out.println("\nPass 3 integers as command-line args to see sum.");
        }

        sc.close();
    }
}
