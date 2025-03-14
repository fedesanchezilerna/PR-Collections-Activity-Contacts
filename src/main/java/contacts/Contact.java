package contacts;

import java.util.*;

public class Contact {
    private String dni;
    private String name;
    private TypePhone typePhone;
    private String phone;
    private Set<Contact> contacts;

    public Contact(String dni, String name, TypePhone typePhone, String phone) {
        this.dni = dni.toUpperCase();
        this.name = name.toUpperCase();
        this.typePhone = typePhone;
        this.phone = phone;
        this.contacts = new HashSet<>();
    }

    public Contact(String dni, String name) {
        this(dni, name, TypePhone.H, "");
    }

    /**
     * Adds a new contact. Avoid adding contact yourself.
     *
     * @param contact to add
     * @return true if successful, false otherwise.
     */
    public boolean addContact(Contact contact) {
        if (this.equals(contact))
            return false;
        return contacts.add(contact);
    }

    /**
     * Deletes the first contact it finds with the data specified by argument
     *
     * @return true if it was deleted successfully, false otherwise.
     */
    public boolean removeFirstContact(String dni, String name, TypePhone typePhone, String phone) {
        return contacts.removeIf(contact -> contact.dni.equalsIgnoreCase(dni) &&
                                            contact.name.equalsIgnoreCase(name) &&
                                            contact.typePhone == typePhone &&
                                            contact.phone.equals(phone));
    }

    public void removeAllContacts() {
        contacts.clear();
    }

    /**
     * Returns a contact form the list by passing it a dni. This method returns
     * the first contact it finds from the list, if no contact is found, the
     * method will return null. The main will be able to know if a contact has
     * been found by consulting what the method returns.
     *
     * @param dni to search
     * @return the first contact it finds from the list.
     */
    public Contact searchContactByDni(String dni) {
        return contacts.stream()
                .filter(contact -> contact.dni.equalsIgnoreCase(dni))
                .findFirst()
                .orElse(null);
    }

    /**
     * Return a list of all contacts that contain the word search
     * in the attributes dni, name, typePhone or phone. If no contact is found,
     * the method will return an empty list. Main will be able to know if any
     * contact has been found by consulting what the method returns.
     *
     * @param search word to search
     * @return Set of all contacts that contain search word, empty list otherwise.
     */
    public Set<Contact> searchContacts(String search) {
        Set<Contact> result = new HashSet<>();
        for (Contact contact : result) {
            if (contact.dni.contains(search) ||
                contact.name.contains(search) ||
                contact.typePhone.name().contains(search) ||
                contact.phone.equals(search)) {
                result.add(contact);
            }
        }
        return result;
    }

    /**
     * String with the list of Contact objects with the following format: (Instead of displaying the typePhone attribute, you should display the corresponding text)
     * <p>
     * Contacts of: Pep
     * <p>
     * ================================================
     * <p>
     * DNI       NAME      TYPE PHONE     PHONE
     * <p>
     * ================================================
     * <p>
     * 99999J    MEL       MOBILE         99999999
     * 12345L    LIS       MOBILE         90000001
     *
     * @return String with the list of Contact objects
     */
    public String listContacts() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contacts of: ").append(name).append("\n")
                .append("================================================\n")
                .append("DNI       NAME      TYPE PHONE     PHONE     \n")
                .append("================================================\n");

        List<Contact> sortedContacts = new ArrayList<>(contacts);
        sortedContacts.sort(Comparator.comparing(Contact::getDni));

        for (Contact sortedContact : sortedContacts) {
            sb.append(String.format("%-10s%-10s%-15s%-15s\n",
                    sortedContact.dni, sortedContact.name.substring(0, 3).toUpperCase(), sortedContact.typePhone.getText(), sortedContact.phone));
        }

        return sb.toString();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypePhone getTypePhone() {
        return typePhone;
    }

    public void setTypePhone(TypePhone typePhone) {
        this.typePhone = typePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Contact contact = (Contact) o;
        return Objects.equals(dni, contact.dni) &&
               Objects.equals(name, contact.name) &&
               typePhone == contact.typePhone &&
               Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, name, typePhone, phone);
    }

    @Override
    public String toString() {
        return "Contact{" +
               "phone='" + phone + '\'' +
               ", typePhone=" + typePhone +
               ", name='" + name + '\'' +
               ", dni='" + dni + '\'' +
               '}';
    }
}
