package testandohelper;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Crear instancias de UserManager y EmpresaManager
        UserManager userManager = new UserManager();
        EmpresaManager empresaManager = new EmpresaManager();

        // Crear usuarios
        User user1 = new User("Alice", "alice@example.com", "Password123");
        User user2 = new User("Bob", "bob@example.com", "Password456");
        User user3 = new User("Charlie", "charlie@example.com", "Password789");
        
        // Agregar usuarios
        userManager.addUser(user1);
        userManager.addUser(user2);
        userManager.addUser(user3);

        // -------------------------- OPERACIONES DE USERMANAGER --------------------------
        System.out.println("\n----- OPERACIONES CON USUARIOS -----");

        // Ver todos los usuarios
        System.out.println("Usuarios registrados:");
        userManager.printAllUsers();

        // Buscar un usuario por email
        User foundUserByEmail = userManager.findUserByEmail("alice@example.com");
        System.out.println("Usuario encontrado por email: " + foundUserByEmail.getName());

        // Buscar un usuario por nombre
        User foundUserByName = userManager.findUserByName("Charlie");
        System.out.println("Usuario encontrado por nombre: " + foundUserByName.getName());

        // Actualizar un usuario
        userManager.updateUser("alice@example.com", "Alice Smith", "alice.smith@example.com", "NewPassword123");
        System.out.println("Usuario actualizado por email 'alice@example.com'");

        // Cambiar la contraseña de un usuario
        userManager.changePassword("alice.smith@example.com", "NewPassword456");
        System.out.println("Contraseña actualizada para: 'alice.smith@example.com'");

        // Verificar si un email está registrado
        boolean isEmailTaken = userManager.isEmailTaken("bob@example.com");
        System.out.println("¿Email 'bob@example.com' está registrado? " + isEmailTaken);

        // Eliminar un usuario
        userManager.deleteUser("bob@example.com");
        System.out.println("Usuario 'bob@example.com' eliminado.");

        // Verificar el total de usuarios
        System.out.println("Total de usuarios registrados: " + userManager.getTotalUsers());

        // Limpiar todos los usuarios
        userManager.clearAllUsers();
        System.out.println("Todos los usuarios han sido eliminados.");

        // -------------------------- OPERACIONES DE EMPRESAMANAGER --------------------------
        System.out.println("\n----- OPERACIONES CON EMPRESAS -----");

        // Crear empresas
        Empresa empresa1 = new Empresa("Tech Corp", "12345678000195", 1, "Empresa A", "Empresa A Ltda.", 
                                       "empresa@a.com", "40.7128", "-74.0060", "Manhattan", "100", "555-1234", 
                                       Arrays.asList("Lunes", "Martes"), Arrays.asList("Consultoría", "Soporte"), 
                                       "facebook.com/empresaA", "instagram.com/empresaA", "Calle 1");

        Empresa empresa2 = new Empresa("Green Energy", "98765432000198", 2, "Empresa B", "Empresa B Ltda.", 
                                       "empresaB@a.com", "40.7128", "-74.0060", "Manhattan", "200", "555-5678", 
                                       Arrays.asList("Miércoles", "Jueves"), Arrays.asList("Consultoría", "Ventas"),
                                       "facebook.com/empresaB", "instagram.com/empresaB", "Calle 2");
        
        // Agregar empresas
        empresaManager.addEmpresa(empresa1);
        empresaManager.addEmpresa(empresa2);

        // Ver todas las empresas
        System.out.println("\nEmpresas registradas:");
        empresaManager.printAllEmpresas();

        // Buscar empresa por CNPJ
        Empresa foundEmpresaByCNPJ = empresaManager.findEmpresaByCNPJ("12345678000195");
        System.out.println("Empresa encontrada por CNPJ: " + foundEmpresaByCNPJ.getCompanyName());

        // Buscar empresa por nombre
        Empresa foundEmpresaByName = empresaManager.findEmpresaByName("Green Energy");
        System.out.println("Empresa encontrada por nombre: " + foundEmpresaByName.getCompanyName());

        // Actualizar una empresa
        empresaManager.updateEmpresa("12345678000195", "Tech Corporation", "Tech Corporation Ltda.", 
                                     "newemail@techcorp.com", "987654321", Arrays.asList("Lunes", "Miércoles"), 
                                     Arrays.asList("Software Development"), "https://facebook.com/techcorpnew", 
                                     "https://instagram.com/techcorpnew");
        System.out.println("Empresa 'Tech Corp' actualizada.");

        // Actualizar la dirección de una empresa
        empresaManager.updateAddress("12345678000195", "New Street 123", "Tech District", "456", "40.7128N", "74.0060W");
        System.out.println("Dirección de la empresa 'Tech Corp' actualizada.");

        // Eliminar una empresa
        empresaManager.deleteEmpresa("98765432000198");
        System.out.println("Empresa 'Green Energy' eliminada.");

        // Verificar si un CNPJ está registrado
        boolean isCNPJTaken = empresaManager.isCNPJTaken("12345678000195");
        System.out.println("¿CNPJ '12345678000195' está registrado? " + isCNPJTaken);

        // Buscar empresas por tipo de servicio
        System.out.println("\nEmpresas que ofrecen 'Consultoría':");
        empresaManager.getEmpresasByServiceType("Consultoría").forEach(empresa -> System.out.println(empresa.getCompanyName()));

        // Buscar empresas que operan en un día específico
        System.out.println("\nEmpresas que operan los 'Lunes':");
        empresaManager.getEmpresasByServiceDay("Lunes").forEach(empresa -> System.out.println(empresa.getCompanyName()));

        // Buscar empresas por un término
        System.out.println("\nBuscar empresas que contienen 'Tech' en el nombre o CNPJ:");
        empresaManager.searchEmpresas("Tech").forEach(empresa -> System.out.println(empresa.getCompanyName()));

        // Limpiar todas las empresas
        empresaManager.clearAllEmpresas();
        System.out.println("Todas las empresas han sido eliminadas.");

        // Verificar el total de empresas
        System.out.println("Total de empresas registradas: " + empresaManager.getTotalEmpresas());
    }
}
