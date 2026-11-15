import java.util.Scanner;

public class UsingScannerForInput
{
    public static void main(String[] args)
    {
        double gpa;
        double grade;
        double totalGradePoints = 0;
        String favoriteSubject;
        int classes;
        double currentCredits;
        int count = 1;

        // Declare a scanner object for the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Prompt the user for their favorite subject
        System.out.println("\n\nWhat is your favorite subject?");
        favoriteSubject = keyboard.nextLine();

        // Prompt the user for the amount of classes they are taking
        System.out.println("How many classes are you taking?");
        classes = keyboard.nextInt();

        // Stop early if there are no classes, to avoid dividing by zero
        if (classes <= 0)
        {
            System.out.println("You need at least one class to estimate a GPA.");
            keyboard.close();
            return;
        }

        // Prompt the user for their current GPA
        System.out.println("What is your current GPA?");
        gpa = keyboard.nextDouble();

        // Prompt the user for their current amount of credits
        System.out.println("How many credits do you currently have?");
        currentCredits = keyboard.nextDouble();

        // Prompt the user for the numerical grade in each class
        while (count <= classes)
        {
            System.out.println("Enter your numerical grade for class " + count + ":");
            grade = keyboard.nextDouble();

            // Convert the numerical grade to grade points (below 60 adds nothing)
            if (grade >= 90)
            {
                totalGradePoints = totalGradePoints + 4;
            }
            else if (grade >= 80)
            {
                totalGradePoints = totalGradePoints + 3;
            }
            else if (grade >= 70)
            {
                totalGradePoints = totalGradePoints + 2;
            }
            else if (grade >= 60)
            {
                totalGradePoints = totalGradePoints + 1;
            }

            count++;
        }

        // Close the scanner now that all input has been read
        keyboard.close();

        // Calculate the estimated GPA for the current classes
        double estimatedClassGpa = totalGradePoints / classes;

        // Calculate earned credits assuming each class is worth one credit
        int earnedCredits = classes * 1;

        // Add earned credits to the student's current credits
        double totalCredits = currentCredits + earnedCredits;

        // Calculate current and newly earned quality points
        double currentQualityPoints = gpa * currentCredits;
        double earnedQualityPoints = estimatedClassGpa * earnedCredits;

        // Calculate the estimated new cumulative GPA
        double estimatedCumulativeGpa =
                (currentQualityPoints + earnedQualityPoints) / totalCredits;

        // Display all of the information entered and calculated
        System.out.println("\n Favorite Subject: " + favoriteSubject
                + "\n Classes: " + classes
                + "\n Current GPA: " + String.format("%.2f", gpa)
                + "\n Current Credits: " + currentCredits
                + "\n Estimated GPA for Current Classes: " + String.format("%.2f", estimatedClassGpa)
                + "\n Credits Earned: " + earnedCredits
                + "\n Total Credits: " + totalCredits
                + "\n Estimated Cumulative GPA: " + String.format("%.2f", estimatedCumulativeGpa));
    }
}
