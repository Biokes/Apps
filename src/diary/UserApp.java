package diary;

import javax.swing.*;

public class UserApp {
    private static boolean validate(String name){

        return name.isBlank();
    }
    private static String[] prompt(){
        String name = input("welcome\nEnter your name ");
        String password= input("enter preferred password");
        String [] returnValue = new String[2];
        returnValue[0] = name;
        returnValue[1] = password;
        return returnValue;
    }
    private static Diaries diaries = new Diaries();
    private static Diary diary;
    private static void print(String output){

        JOptionPane.showMessageDialog(null,output);
    }
    private static String input(String output){

        return JOptionPane.showInputDialog(null,output);
    }
    private static void createNewDiary(){
        String [] nameAndPassword = prompt();
        if(validate(nameAndPassword[0]) || validate(nameAndPassword[1])){
            print("Name or password cannot be blank.");
            createNewDiary();
        }
        diary = new Diary(nameAndPassword[0],nameAndPassword[1]);
        diaries.add(nameAndPassword[0],nameAndPassword[1]);
        print(String.format("%s Entry(s) created successfully.",diary.toString()));
        diaryMenu();
    }

    public static void main(String[] args) {

        homePage();
    }
    private static void homePage(){
        String choice = input("Welcome\n1. Create new Diary.\n2. Exit.");
        switch(choice){
            case "1":
                createNewDiary();
            case "2":
                print("GoodBye.");
                System.exit(0);
        }

    }
    private static int askToLock(){

        return JOptionPane.showInternalConfirmDialog(null,"Lock Diary");
    }
    private static void createEntry(){
        String title;
        String body;
        try {
            title = input("Enter Entry Title");
            body = input("write what you want to keep in your diary");
            diary.createEntry(title,body);
            print(String.format("Entry id: %s is successfully created"   ,diary.entrySize()));
            int choice = askToLock();
            if(choice == 0){
                diary.lockDiary();
            }
            diaryMenu();
        } catch (IllegalArgumentException e) {
            print("SomeThing went wrong....");
            createEntry();
        }
    }
    private static void updateEntry(){
        try {
            if (diary.isLocked()) {
                String password = input("enter password");
                diary.unlockDiary(password);
                int id = Integer.parseInt(input("Enter Entry id"));
                String title = input("update  Entry Title");
                String body = input("write what you want to keep in your diary");
                diary.updateEntry(id, title, body);
                diary.lockDiary();
                diaryMenu();
            }
            int id = Integer.parseInt(input("Enter Entry id"));
            String title = input("update  Entry Title");
            String body = input("write what you want to keep in your diary");
            diary.updateEntry(id, title, body);
            int choice = JOptionPane.showInternalConfirmDialog(null,"lock diary?");
            if(choice ==0)
                diary.lockDiary();
            diaryMenu();


        } catch (IllegalArgumentException illegalArgumentException) {
            print("you entered a wrong command");
            diaryMenu();
        } catch (InvalidUserException invalidUserException) {
            print("Entry does not exist");
            diaryMenu();
        } catch (IncorrectPasswordException incorrectPasswordException) {
            print(incorrectPasswordException.getMessage());
            diaryMenu();
        }
    }
    private static void deleteEntry()
    {
        try {
            int id = Integer.parseInt(input("Enter id of Entry to delete"));
            if(diary.isLocked()){
                String password = input("Enter password to delete");
                diary.unlockDiary(password);
                diary.deleteEntry(id);
                diary.lockDiary();
                diaryMenu();
            }
            diary.deleteEntry(id);
            diary.lockDiary();
            diaryMenu();
        }catch(Exception exception){
            print(exception.getMessage());
        }
    }
    private static void diaryMenu(){
        String option = input("1. create Entry\n2. Update Entry\n3. Delete Entry\n4. Main menu\n5. Exit");
        switch(option){
            case "1":
                createEntry();
            case "2":
                updateEntry();
            case "3":
                deleteEntry();
            case "4":
                homePage();
            case "5":
                System.exit(0);
            default:
                diaryMenu();
        }

    }
}