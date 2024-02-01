package phoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    private final Scanner input = new Scanner(System.in);
    private ArrayList<String> contactNames = new ArrayList<>();
    private ArrayList<String> phoneNumbers = new ArrayList<>();

    public int searchByName(String name) {
        int returnValue;
        for (int count = 0; count < contactNames.size(); count++) {
            if (name.equalsIgnoreCase(contactNames.get(count))) {
                returnValue = count;
                return returnValue;
            }
        }
        return -1;
    }

    public int searchByNumber(String number) {
        int returnValue;
        for (int count = 0; count < phoneNumbers.size(); count++) {
            if (number.equalsIgnoreCase(phoneNumbers.get(count))) {
                returnValue = count;
                return returnValue;
            }
        }
        System.out.println("name not found in contact list.");
        return -1;
    }

    public boolean saveNumber(String name, String number) {
        if (isNumberValid(number)) {
            contactNames.add(name);
            phoneNumbers.add(number);
            System.out.println("<<<<<saved successFully👌👌😘>>>>>>\n");
        } else {
            System.out.println("<<<<<invalid phone number🤦‍♂️🤦‍♂️>>>>>>\n");
            return false;
        }

        return true;
    }

    public boolean isNumberValid(String number) {
        for (int count = 0; count < number.length(); count++) {
            if (!(number.charAt(count) >= '0' && number.charAt(count) <= '9') || number.isBlank())
                return false;
        }
        return true;
    }

    public void sortNames() {
        String temp;
        String temp2;
        for (int counter = 0; counter < phoneNumbers.size(); counter++) {
            for (int innerLoop = counter + 1; innerLoop < phoneNumbers.size(); innerLoop++) {
                if ((contactNames.get(counter)).compareToIgnoreCase((contactNames.get(innerLoop))) > 0) {
                    temp = contactNames.get(counter);
                    contactNames.set(counter, contactNames.get(innerLoop));
                    contactNames.set(innerLoop, temp);
                    temp2 = phoneNumbers.get(counter);
                    phoneNumbers.set(counter, phoneNumbers.get(innerLoop));
                    phoneNumbers.set(innerLoop, temp2);
                }

            }

        }
    }

    public String deleteNumber(String numberToBeDeleted) {
        int index = searchByName(numberToBeDeleted);
        if (index == -1) {
            return "no match to the name entered\uD83D\uDE12\uD83D\uDE12";
        } else {
            phoneNumbers.remove(index);
            contactNames.remove(index);
        }
        return "Number deleted successfully..👌👌👌👌";
    }

    public String[] getContact() {
        System.out.println("Enter name 😁😁😁: ");
        String name = input.next();
        System.out.println("Enter a valid number😒😒😒!!!!: ");
        String number = input.next();
        String[] returnValue = {name, number};
        return returnValue;
    }

    public void displayNumbers() {
        boolean condition = false;
        while (!condition) {
            String values = """
                    \n----------PhoneBook Menu---------
                    1. Create new contact
                    2. Display numbers
                    3. Delete number
                    4. Exit
                    ------->>Enter your option:------->>>""";
            System.out.println(values);
            int optionChoice = input.nextInt();
            switch (optionChoice) {
                case 1:
                    String[] contactDetails = getContact();
                    saveNumber(contactDetails[0], contactDetails[1]);
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    String numberToBeDeleted = input.next();
                    System.out.println(deleteNumber(numberToBeDeleted));
                case 4:
                    System.out.println("Exiting..........");
                    condition = true;
                    break;
                default:
                    System.out.println("you entered a wrong input");
            }

        }

    }

    public void displayContacts() {
        sortNames();
        for (int iterator = 0; iterator < contactNames.size(); iterator++) {
            System.out.printf("\nname:   %s\n", contactNames.get(iterator));
            System.out.printf("telephone: %s", phoneNumbers.get(iterator));
        }
    }
}