import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    // Constructor
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add contact with unique ID
    public boolean addContact(Contact contact) {
        if (contact == null || contact.getContactID() == null) {
            return false;
        }
        
        // Check if ID already exists
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    // Delete contact by ID
    public boolean deleteContact(String contactID) {
        if (contactID == null || !contacts.containsKey(contactID)) {
            return false;
        }
        
        contacts.remove(contactID);
        return true;
    }

    // Update first name
    public boolean updateFirstName(String contactID, String firstName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }
        
        contact.setFirstName(firstName);
        return true;
    }

    // Update last name
    public boolean updateLastName(String contactID, String lastName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }
        
        contact.setLastName(lastName);
        return true;
    }

    // Update phone
    public boolean updatePhone(String contactID, String phone) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }
        
        contact.setPhone(phone);
        return true;
    }

    // Update address
    public boolean updateAddress(String contactID, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }
        
        contact.setAddress(address);
        return true;
    }

    // Get contact by ID (helper method for testing)
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
