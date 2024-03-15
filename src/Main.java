import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();

        boolean flag = true;
        while(flag){

            showOptions();
            switch (Integer.parseInt(s.nextLine().trim())){
                case 1 -> {
                    System.out.println("You choose to add items, enter one or more comma separated items");
                    addItems(groceryList);
                }
                case 2 -> {
                    System.out.println("You choose to remove items, enter items to remove:");
                    removeItems(groceryList);
                }
                case 3 ->{
                    showList(groceryList);
                }
                default -> {
                    System.out.println("You choose to quit");
                    flag = false;
                }
            }
        }
    }

    public static void removeItems(ArrayList<String> list){
        String[] enteredItems = s.nextLine().toUpperCase().split(",");
        ArrayList<String> itemsToRemove = new ArrayList<>();
        ArrayList<String> itemsNotFound = new ArrayList<>();
        for(String el : enteredItems){
            String trimmed = el.trim();
            if(list.contains(trimmed)){
                itemsToRemove.add(trimmed);
            } else {
                itemsNotFound.add(trimmed);
            }
        }
        list.removeAll(itemsToRemove);
        String textIfAllItemsFound = "item(s) " + itemsToRemove + " removed";
        String textIfSomeItemsNotFound = "item(s)" + itemsNotFound + " not found";
        checkEmpty(itemsNotFound,itemsToRemove ,textIfAllItemsFound,textIfSomeItemsNotFound);
    }

    public static void addItems(ArrayList<String> list){
        String[] itemsToAdd = s.nextLine().toUpperCase().split(",");
        for(String item : itemsToAdd){
            list.add(item.trim());
        }
    }

    public static void showOptions(){

        System.out.printf("Available actions: %n" +
                "1 - to add item(s) %n" +
                "2 - to remove any items %n"+
                "3 - show grocery list %n" +
                "any button - to quit %n"
        );
    }
    public static void checkEmpty(ArrayList<String> list){
        String text;
        if(!list.isEmpty()){
            text = String.valueOf(list);
        } else {
            text = "no elements";
        }
        System.out.printf("your grocery list contains %s%n",text);
    }

    public static void checkEmpty(ArrayList<String> notFoundItems, ArrayList<String> toRemoveItems , String isEmpty, String isNotEmpty){
        String text;
        if(!notFoundItems.isEmpty() && !toRemoveItems.isEmpty()){
            text = String.format("%s, %s",isEmpty,isNotEmpty);
        } else if(!toRemoveItems.isEmpty()){
            text = isEmpty;
        } else {
            text = isNotEmpty;
        }
        System.out.println(text);
    }

    public static void showList(ArrayList<String> list){
        checkEmpty(list);
    }

}