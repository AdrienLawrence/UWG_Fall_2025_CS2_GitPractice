package edu.westga.cs1302.contact_manager.viewmodel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.viewmodel.MainWindowViewModel;

public class MainWindowViewModelTest {
    
    private MainWindowViewModel vm;
    
    @BeforeEach
    public void setUp() {
        this.vm = new MainWindowViewModel();
    }
    
    @Test
    public void testAddContactValid() {

        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("123-4567");
        
        this.vm.addContact();
        
        assertEquals(1, this.vm.getContacts().size());
        
        String contactString = this.vm.getContacts().get(0).toString();
        assertEquals("John, 123-4567", contactString);
    }
    
    @Test
    public void testFindContactByName() {
      
        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("123-4567");
        this.vm.addContact();
        
        this.vm.getSearchCriteria().set("John");
        
        String result = this.vm.findContact();
        
        assertEquals("John, 123-4567", result);
    }
    
    @Test
    public void testFindContactByPhoneNumber() {
        
        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("123-4567");
        this.vm.addContact();
        
        this.vm.getSearchCriteria().set("123-4567");
        
        String result = this.vm.findContact();
        
        assertEquals("John, 123-4567", result);
    }
    
    @Test
    public void testFindContactByPhoneNumberWithoutDash() {

        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("1234567");
        this.vm.addContact();
        
        this.vm.getSearchCriteria().set("1234567");
        
        String result = this.vm.findContact();
        
        assertEquals("John, 1234567", result);
    }
    
    @Test
    public void testFindContactNotFound() {
        
        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("123-4567");
        this.vm.addContact();
        
        this.vm.getSearchCriteria().set("Jane");
        
        String result = this.vm.findContact();
        
        assertEquals("No contact found.", result);
    }
    
    @Test
    public void testFindContactInvalidSearchCriteria() {
        
    	
        this.vm.getSearchCriteria().set("123"); 
        
   
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vm.findContact();
        });
        
        assertTrue(exception.getMessage().contains("not a valid name or phone number"));
    }
    
    @Test
    public void testAddMultipleContactsAndFindEach() {
  
        this.vm.getName().set("Alice");
        this.vm.getPhoneNumber().set("111-1111");
        this.vm.addContact();
        
        this.vm.getName().set("Bob");
        this.vm.getPhoneNumber().set("222-2222");
        this.vm.addContact();
        
        this.vm.getName().set("Charlie");
        this.vm.getPhoneNumber().set("333-3333");
        this.vm.addContact();
        
      
        this.vm.getSearchCriteria().set("Alice");
        assertEquals("Alice, 111-1111", this.vm.findContact());
        
        this.vm.getSearchCriteria().set("Bob");
        assertEquals("Bob, 222-2222", this.vm.findContact());
        
        this.vm.getSearchCriteria().set("Charlie");
        assertEquals("Charlie, 333-3333", this.vm.findContact());
        
 
        this.vm.getSearchCriteria().set("111-1111");
        assertEquals("Alice, 111-1111", this.vm.findContact());
        
        this.vm.getSearchCriteria().set("222-2222");
        assertEquals("Bob, 222-2222", this.vm.findContact());
        
        this.vm.getSearchCriteria().set("333-3333");
        assertEquals("Charlie, 333-3333", this.vm.findContact());
    }
    
    @Test
    public void testAddContactInvalidName() {

        this.vm.getName().set("John123"); 
        this.vm.getPhoneNumber().set("123-4567");
        
     
        assertThrows(IllegalArgumentException.class, () -> {
            this.vm.addContact();
        });
    }
    
    @Test
    public void testAddContactInvalidPhoneNumber() {
      
        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("123-456");
        
 
        assertThrows(IllegalArgumentException.class, () -> {
            this.vm.addContact();
        });
    }
    
    @Test
    public void testFindContactWhenNoContactsExist() {
   
        this.vm.getSearchCriteria().set("John");
        
    
        String result = this.vm.findContact();
        

        assertEquals("No contact found.", result);
    }
    
    @Test
    public void testSearchForNameWhenPhoneNumberExists() {
   
        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("123-4567");
        this.vm.addContact();
        
     
        this.vm.getSearchCriteria().set("123-4567");

        String result = this.vm.findContact();
        
        assertEquals("John, 123-4567", result);
    }
    
    @Test
    public void testAddContactDuplicateNameThrowsException() {

        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("123-4567");
        this.vm.addContact();
        
        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("987-6543");
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vm.addContact();
        });
        
        assertTrue(exception.getMessage().contains("A contact with this name already exists"));
        assertEquals(1, this.vm.getContacts().size());
    }

    @Test
    public void testAddContactDuplicatePhoneNumberThrowsException() {
        
        this.vm.getName().set("John");
        this.vm.getPhoneNumber().set("123-4567");
        this.vm.addContact();
        
        this.vm.getName().set("Jane");
        this.vm.getPhoneNumber().set("123-4567");
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            this.vm.addContact();
        });
        
        assertTrue(exception.getMessage().contains("A contact with this number already exists"));
        assertEquals(1, this.vm.getContacts().size());
    }

}