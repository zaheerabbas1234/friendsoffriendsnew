package com.friends;

import java.util.*;

public class FriendsOfFriends {
    
    // Method to find Friends of Friends
    public static Set<String> findFoF(Map<String, Set<String>> network, String person) {
        Set<String> friendsOfFriends = new HashSet<>();
        
        // Get the direct friends of the person
        Set<String> directFriends = network.get(person);
        
        // Loop through each direct friend
        for (String friend : directFriends) {
            Set<String> friendFriends = network.get(friend);
            
            // Loop through the friends of each direct friend
            for (String friendOfFriend : friendFriends) {
                // Avoid adding the person and their direct friends
                if (!friendOfFriend.equals(person) && !directFriends.contains(friendOfFriend)) {
                    friendsOfFriends.add(friendOfFriend);
                }
            }
        }
        
        return friendsOfFriends;
    }
    
    public static void main(String[] args) {
        
        // Create a network (Map where key is person and value is their friends set)
        Map<String, Set<String>> network = new HashMap<>();
        
        // Adding friends to the network
        network.put("A", new HashSet<>(Arrays.asList("B", "C")));
        network.put("B", new HashSet<>(Arrays.asList("A", "D", "E")));
        network.put("C", new HashSet<>(Arrays.asList("A", "D")));
        network.put("D", new HashSet<>(Arrays.asList("B", "C", "F")));
        network.put("E", new HashSet<>(Arrays.asList("B", "F")));
        network.put("F", new HashSet<>(Arrays.asList("D", "E")));
        
        // For each person, print their Friends of Friends
        for (String person : network.keySet()) {
            Set<String> friendsOfFriends = findFoF(network, person);
            System.out.println(person + "'s Friends of Friends: " + friendsOfFriends);
        }
    }
}

