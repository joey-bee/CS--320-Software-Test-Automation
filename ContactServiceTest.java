import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(service.addContact(contact));
        assertEquals(contact, service.getContact("1234567890"));
    }

    @Test
    public void testAddContactWithDuplicateID() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "9876543210", "456 Oak Ave");
        
        service.addContact(contact1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testAddNullContact() {
        assertFalse(service.addContact(null));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        assertTrue(service.deleteContact("1234567890"));
        assertNull(service.getContact("1234567890"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertFalse(service.deleteContact("9999999999"));
    }

    @Test
    public void testDeleteWithNullID() {
        assertFalse(service.deleteContact(null));
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        assertTrue(service.updateFirstName("1234567890", "Jane"));
        assertEquals("Jane", service.getContact("1234567890").getFirstName());
    }

    @Test
    public void testUpdateFirstNameNonExistentContact() {
        assertFalse(service.updateFirstName("9999999999", "Jane"));
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        assertTrue(service.updateLastName("1234567890", "Smith"));
        assertEquals("Smith", service.getContact("1234567890").getLastName());
    }

    @Test
    public void testUpdateLastNameNonExistentContact() {
        assertFalse(service.updateLastName("9999999999", "Smith"));
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        assertTrue(service.updatePhone("1234567890", "9876543210"));
        assertEquals("9876543210", service.getContact("1234567890").getPhone());
    }

    @Test
    public void testUpdatePhoneNonExistentContact() {
        assertFalse(service.updatePhone("9999999999", "9876543210"));
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        
        assertTrue(service.updateAddress("1234567890", "456 Oak Ave"));
        assertEquals("456 Oak Ave", service.getContact("1234567890").getAddress());
    }

    @Test
    public void testUpdateAddressNonExistentContact() {
        assertFalse(service.updateAddress("9999999999", "456 Oak Ave"));
    }
}
