package org.practice.collection;

import java.util.HashMap;
import java.util.HashSet;
// custom hashmap using hash methods
public class HashMaps {
    private Entity[] entities;
    public HashMaps(){
        entities=new Entity[100];

    }
    public class Entity{
        String key;
        String value;
        public Entity(String key,String value){
            this.key=key;
            this.value=value;
        }
    }
        public void put(String key, String value){
            int hash=Math.abs(key.hashCode()%entities.length);
            entities[hash]=new Entity(key,value);
        }
        public String get(String key){
            int hash=Math.abs(key.hashCode()%entities.length);
            if(entities[hash]!=null&&entities[hash].key.equals(key)){
                return entities[hash].value;
            }
            return null;
        }
        public void remove(String key){
            int hash=Math.abs(key.hashCode()%entities.length);
            if(entities[hash]!=null&&entities[hash].key.equals(key)) {
                entities[hash] = null;
            }
        }
    //-------------------------------------------------------------
    //RabinKarp String Matching
    //-------------------------------------------------------------
    private final int PRIME=101;
    public long calculateHash(String s){
        long hash=0;
        for (int i = 0; i < s.length(); i++) {
            hash= (long) (hash+s.charAt(i)*Math.pow(PRIME,i));
        }
        return hash;
    }
    public long updateHash(long prevHash,char oldC,char newC,int patternLength){
        long newHash=(prevHash-oldC)/PRIME;
        newHash=newHash+newC*(long)Math.pow(PRIME,patternLength-1);
        return newHash;
    }
    public void search(String text,String pattern){
        int patternLength=pattern.length();
        long patternHash=calculateHash(pattern);
        long textHash=calculateHash(text.substring(0,patternLength));
        for (int i = 0; i < text.length()-patternLength; i++) {
            if(textHash==patternHash){
                if(text.substring(i,i+patternLength).equals(pattern)){
                    System.out.println("Pattern found at index: "+i);
                }
            }
            if(i<text.length()-patternLength){
                textHash=updateHash(textHash,text.charAt(i),text.charAt(i+patternLength),patternLength);
            }
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        HashMaps maps=new HashMaps();
        maps.put("apl","ios");
        maps.put("sams","and");
        maps.put("moto","and");
        maps.put("mcrst","windows");
        System.out.println(maps.get("moto"));
        System.out.println("--------------------------------");
        map.put("kunafa",67);
        map.put("kuna",617);
        map.put("kua",670);
      //  System.out.println(map.get("kunafa").hashCode());
        System.out.println(map.entrySet());
        HashSet<Integer> set=new HashSet<>();
        set.add(56);
        set.add(56);
        set.add(42);
        set.add(9);
        System.out.println(set);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        maps.search("fwnshuirgsfubj","fub");
        System.out.println("--------------------------------");
    }
}
