/*  Program: 100 Lockers
*   Programmer: Alex Kaulfuss
*   Date:9/28
*   Purpose: Determine which lockers remain open after all  students have completed their turn */

public class main {

    public static void main(String[] args) {
        boolean[] lockers = simulateLockers(100);
        printOpenLockers(lockers);
    }

    /**
     * Simulates the process of students toggling locker states.
     * <p>
     * Creates an array where each index represents a locker number. 
     * Iterates through each student from 1 to {@code totalLockers}, 
     * toggling every nth locker corresponding to the student's number.
     * </p>
     *
     * @param totalLockers the total number of lockers and students in the simulation
     * @return a boolean array where index {@code i} is {@code true} if locker {@code i} is open,
     *         and {@code false} if it is closed
     */
    public static boolean[] simulateLockers(int totalLockers) {
        boolean[] lockers = new boolean[totalLockers + 1];

        for (int student = 1; student <= totalLockers; student++) {
            for (int locker = student; locker <= totalLockers; locker += student) {
                lockers[locker] = !lockers[locker]; // Toggle state
            }
        }

        return lockers;
    }

    /**
     * Prints the status of all open lockers to the console.
     *
     * @param lockers a boolean array representing the state of each locker,
     *                where {@code true} indicates an open locker
     */
    public static void printOpenLockers(boolean[] lockers) {
        for (int i = 1; i < lockers.length; i++) {
            if (lockers[i]) {
                System.out.println("Locker " + i + " is open");
            }
        }
    }
}