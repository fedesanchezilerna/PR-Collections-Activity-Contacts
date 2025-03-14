package contacts;

import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contact pep = new Contact("11111A", "Pep", TypePhone.M, "11111111");
        initContacts(pep);

        while (true) {
            menu();

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("LIST CONTACTS");
                    System.out.println(pep.listContacts());
                    break;
                case 2:
                    System.out.println("ADD CONTACT");
                    System.out.print("ENTER NAME: ");
                    System.out.print("ENTER DNI: ");
                    System.out.print("ENTER TYPE OF PHONE: ");
                    System.out.print("ENTER PHONE: ");
                    break;
                case 3:
                    System.out.println("REMOVE CONTACT BY NAME, DNI, TYPE PHONE AND PHONE");
                    System.out.print("ENTER NAME: ");
                    System.out.print("ENTER DNI: ");
                    System.out.print("ENTER TYPE OF PHONE H, M, O, F: ");
                    System.out.print("ENTER PHONE: ");
                    break;
                case 4:
                    System.out.println("REMOVE ALL CONTACTS");
                    pep.removeAllContacts();
                    System.out.println("ALL CONTACTS HAVE BEEN REMOVED");
                    break;
                case 5:
                    System.out.println("SEARCH CONTACT BY DNI");
                    System.out.print("ENTER DNI TO SEARCH: ");
                    String dni = sc.nextLine();
                    Contact contact = pep.searchContactByDni(dni);
                    if (contact != null) System.out.println(contact);
                    else System.out.println("CONTACT NOT FOUND!");
                    break;
                case 7:
                    System.out.println("EXITING...");
                    sc.close();
                    return;
                default:
                    System.out.println("INVALID OPTION. TRY AGAIN.");
            }
        }
    }

    private static void menu() {
        System.out.println("\nMENU");
        System.out.println("1. LIST CONTACTS");
        System.out.println("2. ADD CONTACT");
        System.out.println("3. REMOVE FIRST CONTACT BY NAME, DNI, TYPEPHONE AND PHONE");
        System.out.println("4. REMOVE ALL CONTACTS");
        System.out.println("5. SEARCH CONTACT BY DNI");
        System.out.println("6. SEARCH ALL CONTACTS BY TEXT");
        System.out.println("7. QUIT");
        System.out.print("CHOOSE MENU OPTION: ");
    }

    private static void initContacts(Contact contact) {
        contact.addContact(new Contact("12345L", "Lis", TypePhone.O, "90000003"));
        contact.addContact(new Contact("66666F", "Dan", TypePhone.M, "66666666"));
        contact.addContact(new Contact("22222B", "Mar", TypePhone.O, "22222222"));
        contact.addContact(new Contact("33333C", "Pol", TypePhone.H, "33333333"));
        contact.addContact(new Contact("99999J", "Mel", TypePhone.M, "99999999"));
        contact.addContact(new Contact("44444D", "Roc", TypePhone.O, "44444444"));
        contact.addContact(new Contact("12345L", "Lis", TypePhone.F, "90000004"));
        contact.addContact(new Contact("12345L", "Lis", TypePhone.H, "90000002"));
        contact.addContact(new Contact("77777G", "Eva", TypePhone.M, "77777777"));
        contact.addContact(new Contact("55555E", "Isa", TypePhone.H, "55555555"));
        contact.addContact(new Contact("88888H", "Max", TypePhone.M, "88888888"));
        contact.addContact(new Contact("12345L", "Lis", TypePhone.M, "90000001"));
    }

    public static byte dataEntryByte(String data) {
        return Byte.parseByte(data);
    }

    public static int dataEntryInt(String data) {
        return Integer.parseInt(data);
    }

    public static int dataEntryShort(String data) {
        return Short.parseShort(data);
    }

    public static String dataEntryString(String data) {
        return data;
    }

    public static String dataEntryStringTypePhone(String data) {
        return data;
    }
}
