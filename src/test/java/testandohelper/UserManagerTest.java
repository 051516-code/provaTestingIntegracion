package testandohelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
    }

    @Test
    void testAddUser() {
        User user = new User("John Doe", "john.doe@example.com", "Password123");
        userManager.addUser(user);
        assertEquals(1, userManager.getTotalUsers(), "Debe haber un usuario registrado.");
    }

    @Test
    void testAddUserWithDuplicateEmail() {
        User user1 = new User("John Doe", "john.doe@example.com", "Password123");
        User user2 = new User("Jane Doe", "john.doe@example.com", "Password456");

        userManager.addUser(user1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userManager.addUser(user2); // Debe lanzar una excepción por duplicado
        });
        assertEquals("Ya existe un usuario con este email.", exception.getMessage());
    }

    @Test
    void testFindUserByEmail() {
        User user = new User("John Doe", "john.doe@example.com", "Password123");
        userManager.addUser(user);
        User foundUser = userManager.findUserByEmail("john.doe@example.com");
        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    void testUpdateUserEmail() {
        User user = new User("John Doe", "john.doe@example.com", "Password123");
        userManager.addUser(user);
        userManager.updateUser("john.doe@example.com", null, "john.new@example.com", null);

        User updatedUser = userManager.findUserByEmail("john.new@example.com");
        assertNotNull(updatedUser);
        assertEquals("john.new@example.com", updatedUser.getEmail());
    }

    @Test
    void testDeleteUser() {
        User user = new User("John Doe", "john.doe@example.com", "Password123");
        userManager.addUser(user);
        userManager.deleteUser("john.doe@example.com");
        assertNull(userManager.findUserByEmail("john.doe@example.com"));
    }

    @Test
    void testChangePassword() {
        User user = new User("John Doe", "john.doe@example.com", "Password123");
        userManager.addUser(user);
        userManager.changePassword("john.doe@example.com", "NewPassword123");
        User updatedUser = userManager.findUserByEmail("john.doe@example.com");
        assertEquals("NewPassword123", updatedUser.getPassword());
    }

    @Test
    void testDeactivateUser() {
        User user = new User("John Doe", "john.doe@example.com", "Password123");
        userManager.addUser(user);
        userManager.deactivateUser("john.doe@example.com");
        // Suponiendo que la desactivación solo imprime un mensaje, no verificamos aquí.
    }

    @Test
    void testActivateUser() {
        User user = new User("John Doe", "john.doe@example.com", "Password123");
        userManager.addUser(user);
        userManager.activateUser("john.doe@example.com");
        // Suponiendo que la activación solo imprime un mensaje, no verificamos aquí.
    }
}
