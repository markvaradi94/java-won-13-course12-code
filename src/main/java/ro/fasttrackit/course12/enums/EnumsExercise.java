package ro.fasttrackit.course12.enums;

import java.util.Scanner;

import static java.lang.Math.round;
import static ro.fasttrackit.course12.enums.CardinalPoints.*;
import static ro.fasttrackit.course12.homework.classroom.Classroom.saySomething;

public class EnumsExercise {
    public static void main(String[] args) {
        CardinalPoints east = EAST;
        CardinalPoints north = NORTH;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a cardinal point: ");
        String line = scanner.nextLine();

        CardinalPoints point = CardinalPoints.fromName(line);
        if (point != null) {
            System.out.println(point);
            System.out.printf("Direction is: %s", point.toDirection());
            System.out.println("Hello");
        }

        System.out.print("Enter a symbol: ");
        line = scanner.nextLine();

        CardinalPoints pointFromSymbol = fromSymbol(line);
        if (pointFromSymbol != null) {
            System.out.println(pointFromSymbol);
            System.out.printf("Direction is: %s", pointFromSymbol.toDirection());
        }

        saySomething();

        round(231.4);
    }
}
