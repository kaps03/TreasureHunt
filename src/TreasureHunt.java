import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreasureHunt {

    static int a[] = {2, 1, 2, 0, 2, -1};
    static int b[] = {2, 4, 3, 0, -1, -1};
    static int c[] = {2, 10, 1, -1, 1, -2,};

    public static void main(String[] args) {
        List<Object> treasurePathA =  getTreasure(a);
        List<Object> treasurePathB = getTreasure(b);
        List<Object> treasurePathC = getTreasure(c);
        if (treasurePathA.size() > 1){
            System.out.println("Treasure path :  "+treasurePathA);
        }else {
            String value = treasurePathA.size() == 1 && treasurePathA.get(0).equals(0) ? "Becomes Zombie" : "caught in infinite loop";
            System.out.println("Treasure "+value+ " : "+ treasurePathC);
        }
        if (treasurePathB.size() > 1){
            System.out.println("Treasure path  "+treasurePathB);
        }else {
            String value = treasurePathB.size() == 1 && treasurePathB.get(0).equals(0) ? "Becomes Zombie" : "caught in infinite loop";
            System.out.println("Treasure "+value+ " : "+ treasurePathB);
        }
        if (treasurePathC.size() > 1){
            System.out.println("Treasure path  "+treasurePathA);
        }else {
            String value = treasurePathC.size() == 1 && treasurePathC.get(0).equals(0) ? "Becomes Zombie" : "caught in infinite loop";
            System.out.println("Treasure "+value+ " : "+ treasurePathC);
        }
    }

    /**
     * Kapil Soni
     * @since 14/04/2021
     * @param array
     * @return arraylist
     */
    public static List<Object> getTreasure(int[] array) {
        int previousIndex = -1;
        int index = 0;
        List<Object> treasurePath = new ArrayList<>();
        try{
            treasurePath.add(array[0]);
            for ( index = 0; index <= array.length;){
                if (index != 0)
                    previousIndex  = array[index-1]+array[index];
                if(0 == array[index] ||  previousIndex == 0) {
                    break;
                }
                index += array[index];
                treasurePath.add(array[index]);
            }
        } catch(ArrayIndexOutOfBoundsException exception ){
            treasurePath.add( "Treasure");
        }
        return treasurePath.contains("Treasure")
                     ? treasurePath
                     : new ArrayList(Collections.singletonList(treasurePath.get(treasurePath.size() - 1)));

    }
}
