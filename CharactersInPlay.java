
import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay(){
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update(String person){
        
        //If person is not already in names, add person as a new names object and 1 to the arrayList as a new object:
        if (names.indexOf(person)== -1){
                names.add(person);
                counts.add(1);
            }
        /*If person is already in names, change counts adding 1 everytime we find a person.
         * This is so intelligent. By playing with the index of the Sting arrayList, you can 
         * manipulate the counts without modifying the names ArrayList
         */
        else{
            int indexCounts = counts.get(names.indexOf(person))+1;
            counts.set(names.indexOf(person), indexCounts);
        }
        
    }
    
    public void findAllCharacters(){
        FileResource f = new FileResource();
        String firstOccur = "";
        for(String line : f.lines()){
            if (line.indexOf(".") != -1){
               firstOccur = line.substring(0, line.indexOf("."));
               update(firstOccur);
            }
            
        }
    }
    
    public void tester(){
        counts.clear();
        names.clear();
        findAllCharacters();
        for (int i=0; i < names.size(); i++){
            if (counts.get(i) > 1){
                System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
        charactersWithNumParts(10,15);
    }
    
    public void charactersWithNumParts(int num1, int num2){
        System.out.println("Characters that have between "+ num1 + " and " + num2+ " lines:");
        for (int i=0; i < names.size(); i++){
            if (counts.get(i) >= num1 && counts.get(i)<= num2){
               System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
    }
    
}
