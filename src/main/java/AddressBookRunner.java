import java.util.*;

public class AddressBookRunner {
  public static final String ADD_CONTACT = "Add a contact";
  public static final String LOOKUP_CONTACT = "Look up a contact";
  public static final String DISTRIBUTION_LIST = "Generate a distribution list";
  public static final String QUIT_TEXT = "Quit";

  public static void main(String[] args) {
    List<String> options = new ArrayList<>();
    options.add(ADD_CONTACT);
    options.add(LOOKUP_CONTACT);
    options.add(DISTRIBUTION_LIST);
    options.add(QUIT_TEXT);
    Map<String, String> contactInformation = new HashMap<>();

    Scanner inputScanner = new Scanner(System.in);
    String menuChoice = "";

    while(menuChoice != QUIT_TEXT) {
      int menuIndex = 1;
      for(String option : options) {
        System.out.println(menuIndex + ". " + option);
        menuIndex++;
      }

      System.out.println("\nWhat would you like to do? Select a number.");
      try {
        int selectedOption = inputScanner.nextInt();

        inputScanner.nextLine();
        menuChoice = options.get(selectedOption - 1);

        if (menuChoice == ADD_CONTACT) {
          System.out.println("Please type a name to add.");
          String name = inputScanner.nextLine();
          while (name.isBlank()) {
           System.out.println("Sorry, you didn't type a valid name. Please try it again");
           name = inputScanner.nextLine();
          }
          System.out.println("Please type an email to add.");
          String email = inputScanner.nextLine();
          while (email.isBlank()) {
            System.out.println("Sorry, you didn't type a valid email. Please try it again");
            email = inputScanner.nextLine();
          }
          contactInformation.put(name, email);

        } else if (menuChoice == LOOKUP_CONTACT) {
          System.out.println("Please type a name to find.");
          String name = inputScanner.nextLine();
          while (name.isBlank()) {
            System.out.println("Sorry, you dind't type a valid name. Please try it again.");
            name = inputScanner.nextLine();
          }
          if (contactInformation.containsKey(name)) {
            System.out.println(name + ": " + contactInformation.get(name) + "\n");
          } else {
            System.out.println("Sorry, the contact you typed was not found. \n");
          }

        } else if (menuChoice == DISTRIBUTION_LIST) {
          Set<String> names = contactInformation.keySet();
          for(String distName : names){
          System.out.println("\"" + distName + "\" <" + contactInformation.get(distName) + ">, ");
          }
        } System.out.println("\n");

      } catch(IndexOutOfBoundsException err) {
        System.out.println("Please make a valid selection!");
      }
    }
  }
}
