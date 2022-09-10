import java.util.HashMap;
import java.util.Map;

public class Main {
    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = generateMap(text);
        System.out.println(map);
        findMinMax(map);
    }
    static public Map<Character,Integer> generateMap(String text){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            char a = Character.toLowerCase(text.charAt(i));
            if(!Character.isLetter(a)){
                continue;
            }
            if(!map.containsKey(a)){
                map.put(a,1);
                continue;
            }
            map.replace (a,(map.get(a) + 1));
        }
        return map;
    }
    static public void findMinMax(Map<Character,Integer> map){
        Character maxKey = null;
        Character minKey = null;
        for(Character character : map.keySet()){
            map.get(character);
            if(maxKey == null || minKey == null){
                maxKey = character;
                minKey = character;
                continue;
            }
            if (map.get(maxKey)< map.get(character)){
                maxKey = character;
            }
            if (map.get(minKey)> map.get(character)){
                minKey = character;
            }
        }
        System.out.println("Самое повторяемая буква - " + maxKey + " - " + map.get(maxKey));
        System.out.println("Самое менее повторяемая буква - " + minKey + " - " + map.get(minKey));

    }

}