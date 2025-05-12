// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[][] rooms = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Enter the item :");
        int target =in.nextInt();
        System.out.println("Enter the room number :");
        int targetDistance=in.nextInt();
        //int target;
        RoomSearch roomSearch = new RoomSearch();
        int i=0;
        int j=rooms.length -1;
        System.out.println("Iterative Search: " + roomSearch.searchItemIterative(rooms, target));
        System.out.println("Recursive Search: " + roomSearch.searchItemRecursive(rooms, target, i,j));
        roomSearch.determineRoomNumbers(rooms,i,j);
        System.out.println("Iterative Search With Distance: " + roomSearch.searchRoomIterative(rooms,targetDistance));
        System.out.println("Recursive Search With Distance: " + roomSearch.searchRoomRecursive(rooms,targetDistance,i,j));
    }
}