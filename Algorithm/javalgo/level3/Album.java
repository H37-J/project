import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class Album {

    public static void main(String... args) {
        String[] genres = { "pop","pop","pop","rap","rap" };
        int[] plays = { 50,55,40,60,70};
        solution(genres, plays);
    }

    public static Integer[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> albums = new HashMap<>();
        HashMap<String, HashMap<Integer,Integer>> songs = new HashMap<>();
        HashMap<Integer,Integer> song=new HashMap<>();
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            if (!albums.containsKey(genres[i])) albums.put(genres[i], plays[i]);
            else albums.put(genres[i], albums.get(genres[i]) + plays[i]);
            if(songs.containsKey(genres[i])) song= songs.get(genres[i]);
            else song = new HashMap<>();
            song.put(i,plays[i]);
            songs.put(genres[i],song);
        }

        albums = albums.entrySet().stream()
        .sorted(Entry.comparingByValue((e1,e2)->e2.compareTo(e1))).limit(2)
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        albums.forEach((k,v)-> System.out.println(k+","+v));

        for(Map.Entry<String,Integer> a : albums.entrySet()){
            song=songs.get(a.getKey());
            song = song.entrySet().stream().sorted(Entry.comparingByValue((e1,e2)->e2.compareTo(e1))).limit(2)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
            song.forEach((k,v)->System.out.println(k+","+v));
            for(Map.Entry<Integer,Integer> s : song.entrySet()) answers.add(s.getKey());
        }

        answers.stream().forEach(System.out::println);

        return answers.stream().toArray(Integer[]::new);
    }
}

// genres plays return
// ["classic", "pop", "classic", "classic", "pop"] [500, 600, 150, 800, 2500]
// [4, 1, 3, 0]