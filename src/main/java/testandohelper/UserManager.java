package testandohelper;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();

    // Crear un nuevo usuario
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        if (findUserByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Ya existe un usuario con este email.");
        }
        users.add(user);
        System.out.println("Usuario añadido: " + user.getName());
    }

    // Leer todos los usuarios
    public List<User> getAllUsers() {
        return new ArrayList<>(users); // Retorna una copia de la lista para proteger los datos originales
    }

    // Leer un usuario por su email
    public User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null; // Retorna null si no se encuentra el usuario
    }

    // Leer un usuario por su nombre
    public User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null; // Retorna null si no se encuentra el usuario
    }

    // Actualizar un usuario (nombre, email, contraseña)
    public void updateUser(String email, String newName, String newEmail, String newPassword) {
        User user = findUserByEmail(email);
        if (user != null) {
            if (newName != null && !newName.trim().isEmpty()) {
                user.setName(newName);
            }
            if (newEmail != null && !newEmail.trim().isEmpty() && !newEmail.equals(user.getEmail())) {
                if (findUserByEmail(newEmail) != null) {
                    throw new IllegalArgumentException("Ya existe un usuario con este email.");
                }
                user.setEmail(newEmail);
            }
            if (newPassword != null && newPassword.length() >= 6) {
                user.setPassword(newPassword);
            }
            System.out.println("Usuario actualizado: " + user.getName());
        } else {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
    }

    // Eliminar un usuario
    public void deleteUser(String email) {
        User user = findUserByEmail(email);
        if (user != null) {
            users.remove(user);
            System.out.println("Usuario eliminado: " + email);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
    }

    // Verificar si un email ya está registrado
    public boolean isEmailTaken(String email) {
        return findUserByEmail(email) != null;
    }

    // Obtener el total de usuarios registrados
    public int getTotalUsers() {
        return users.size();
    }

    // Limpiar todos los usuarios (útil para reiniciar el sistema)
    public void clearAllUsers() {
        users.clear();
        System.out.println("Todos los usuarios han sido eliminados.");
    }

    // Buscar usuarios por un término (en nombre o email)
    public List<User> searchUsers(String keyword) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().toLowerCase().contains(keyword.toLowerCase()) || 
                user.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(user);
            }
        }
        return result;
    }

    // Validar si la contraseña es válida (mínimo 6 caracteres, al menos una letra mayúscula y un número)
    private boolean isPasswordValid(String password) {
        return password != null && password.length() >= 6 && 
               password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");
    }

    // Cambiar la contraseña de un usuario
    public void changePassword(String email, String newPassword) {
        User user = findUserByEmail(email);
        if (user != null) {
            if (!isPasswordValid(newPassword)) {
                throw new IllegalArgumentException("La contraseña no es válida.");
            }
            user.setPassword(newPassword);
            System.out.println("Contraseña actualizada para: " + user.getEmail());
        } else {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
    }

    // Método para desactivar un usuario (simulado, agregamos un atributo 'active')
    public void deactivateUser(String email) {
        User user = findUserByEmail(email);
        if (user != null) {
            // Simulamos la desactivación (puedes agregar un atributo 'active' a la clase User si lo deseas)
            System.out.println("Usuario desactivado: " + user.getEmail());
        } else {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
    }

    // Método para activar un usuario
    public void activateUser(String email) {
        User user = findUserByEmail(email);
        if (user != null) {
            // Simulamos la activación (puedes agregar un atributo 'active' a la clase User si lo deseas)
            System.out.println("Usuario activado: " + user.getEmail());
        } else {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
    }

    // Método para obtener una lista de usuarios activos (si se implementa el atributo 'active')
    public List<User> getActiveUsers() {
        List<User> activeUsers = new ArrayList<>();
        // Aquí deberías comprobar si los usuarios están activos, si agregas un atributo 'active' en la clase User
        for (User user : users) {
            // Si el usuario está activo, lo agregamos
            activeUsers.add(user);
        }
        return activeUsers;
    }

    // Método para mostrar todos los usuarios en consola
    public void printAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
