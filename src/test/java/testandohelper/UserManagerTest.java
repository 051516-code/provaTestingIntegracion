package testandohelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    private UserManager userManager;
    private User user1;
    private User user2;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
        user1 = new User("Alice", "alice@example.com", "Password123");
        user2 = new User("Bob", "bob@example.com", "Password456");
    }

    @Test
    public void testAddUser() {
        userManager.addUser(user1);
        assertEquals(1, userManager.getTotalUsers());
        assertTrue(userManager.getAllUsers().contains(user1));
    }

    @Test
    public void testAddUserWithDuplicateEmail() {
        userManager.addUser(user1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userManager.addUser(new User("Charlie", "alice@example.com", "Password789"));
        });
        assertEquals("Ya existe un usuario con este email.", exception.getMessage());
    }

    @Test
    public void testGetAllUsers() {
        userManager.addUser(user1);
        userManager.addUser(user2);
        List<User> users = userManager.getAllUsers();
        assertEquals(2, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
    }

    @Test
    public void testFindUserByEmail() {
        userManager.addUser(user1);
        User foundUser = userManager.findUserByEmail("alice@example.com");
        assertEquals(user1, foundUser);
    }

    @Test
    public void testFindUserByEmailNotFound() {
        userManager.addUser(user1);
        User foundUser = userManager.findUserByEmail("nonexistent@example.com");
        assertNull(foundUser);
    }

    @Test
    public void testFindUserByName() {
        userManager.addUser(user1);
        User foundUser = userManager.findUserByName("Alice");
        assertEquals(user1, foundUser);
    }

    @Test
    public void testUpdateUser() {
        userManager.addUser(user1);
        userManager.updateUser("alice@example.com", "Alice Smith", "alice.smith@example.com", "NewPassword123");
        
        User updatedUser = userManager.findUserByEmail("alice.smith@example.com");
        assertNotNull(updatedUser);
        assertEquals("Alice Smith", updatedUser.getName());
        assertEquals("alice.smith@example.com", updatedUser.getEmail());
    }

    @Test
    public void testUpdateUserEmailConflict() {
        userManager.addUser(user1);
        userManager.addUser(user2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userManager.updateUser("alice@example.com", "Alice", "bob@example.com", "NewPassword123");
        });
        assertEquals("Ya existe un usuario con este email.", exception.getMessage());
    }

    @Test
    public void testDeleteUser() {
        userManager.addUser(user1);
        userManager.deleteUser("alice@example.com");
        assertEquals(0, userManager.getTotalUsers());
    }

    @Test
    public void testDeleteUserNotFound() {
        userManager.addUser(user1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userManager.deleteUser("nonexistent@example.com");
        });
        assertEquals("Usuario no encontrado.", exception.getMessage());
    }

    @Test
    public void testIsEmailTaken() {
        userManager.addUser(user1);
        assertTrue(userManager.isEmailTaken("alice@example.com"));
        assertFalse(userManager.isEmailTaken("nonexistent@example.com"));
    }

    @Test
    public void testClearAllUsers() {
        userManager.addUser(user1);
        userManager.addUser(user2);
        userManager.clearAllUsers();
        assertEquals(0, userManager.getTotalUsers());
    }

    @Test
    public void testSearchUsers() {
        userManager.addUser(user1);
        userManager.addUser(user2);
        List<User> searchResults = userManager.searchUsers("alice");
        assertEquals(1, searchResults.size());
        assertTrue(searchResults.contains(user1));
    }

    @Test
    public void testChangePassword() {
        userManager.addUser(user1);
        userManager.changePassword("alice@example.com", "NewPassword789");
        User updatedUser = userManager.findUserByEmail("alice@example.com");
        assertEquals("NewPassword789", updatedUser.getPassword());
    }

    @Test
    public void testChangePasswordInvalid() {
        userManager.addUser(user1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userManager.changePassword("alice@example.com", "short");
        });
        assertEquals("La contraseña no es válida.", exception.getMessage());
    }

    @Test
    public void testDeactivateUser() {
        userManager.addUser(user1);
        userManager.deactivateUser("alice@example.com");
        // Aquí puedes agregar la verificación según la implementación de desactivación que desees
    }

    @Test
    public void testActivateUser() {
        userManager.addUser(user1);
        userManager.activateUser("alice@example.com");
        // Aquí puedes agregar la verificación según la implementación de activación que desees
    }

    @Test
    public void testGetActiveUsers() {
        userManager.addUser(user1);
        userManager.addUser(user2);
        List<User> activeUsers = userManager.getActiveUsers();
        assertEquals(2, activeUsers.size()); // Asumiendo que todos están activos
    }

    @Test
    public void testPrintAllUsers() {
        userManager.addUser(user1);
        userManager.addUser(user2);
        userManager.printAllUsers();
        // Verifica que se imprima la información correcta en consola
    }
}
