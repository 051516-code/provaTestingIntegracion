package testandohelper;

import java.util.ArrayList;
import java.util.List;

public class EmpresaManager {
    private List<Empresa> empresas = new ArrayList<>();

    // Crear una nueva empresa
    public void addEmpresa(Empresa empresa) {
        if (empresa == null) {
            throw new IllegalArgumentException("La empresa no puede ser nula.");
        }
        if (findEmpresaByCNPJ(empresa.getCnpj()) != null) {
            throw new IllegalArgumentException("Ya existe una empresa con este CNPJ.");
        }
        empresas.add(empresa);
        System.out.println("Empresa añadida: " + empresa.getCompanyName());
    }

    // Leer todas las empresas
    public List<Empresa> getAllEmpresas() {
        return new ArrayList<>(empresas); // Retorna una copia para proteger los datos originales
    }

    // Leer una empresa por su CNPJ
    public Empresa findEmpresaByCNPJ(String cnpj) {
        for (Empresa empresa : empresas) {
            if (empresa.getCnpj().equalsIgnoreCase(cnpj)) {
                return empresa;
            }
        }
        return null; // Retorna null si no se encuentra la empresa
    }

    // Leer una empresa por su nombre
    public Empresa findEmpresaByName(String companyName) {
        for (Empresa empresa : empresas) {
            if (empresa.getCompanyName().equalsIgnoreCase(companyName)) {
                return empresa;
            }
        }
        return null; // Retorna null si no se encuentra la empresa
    }

    // Actualizar los detalles de una empresa (nombre, CNPJ, email, etc.)
    public void updateEmpresa(String cnpj, String newCompanyName, String newCorporateName, String newEmail, 
                              String newPhone, List<String> newServiceDays, List<String> newServiceType, 
                              String newFacebook, String newInstagram) {
        Empresa empresa = findEmpresaByCNPJ(cnpj);
        if (empresa != null) {
            if (newCompanyName != null && !newCompanyName.trim().isEmpty()) {
                empresa.setCompanyName(newCompanyName);
            }
            if (newCorporateName != null && !newCorporateName.trim().isEmpty()) {
                empresa.setCorporateName(newCorporateName);
            }
            if (newEmail != null && !newEmail.trim().isEmpty()) {
                empresa.setEmail(newEmail);
            }
            if (newPhone != null && !newPhone.trim().isEmpty()) {
                empresa.setPhone(newPhone);
            }
            if (newServiceDays != null && !newServiceDays.isEmpty()) {
                empresa.setServiceDays(newServiceDays);
            }
            if (newServiceType != null && !newServiceType.isEmpty()) {
                empresa.setServiceType(newServiceType);
            }
            if (newFacebook != null && !newFacebook.trim().isEmpty()) {
                empresa.setFacebook(newFacebook);
            }
            if (newInstagram != null && !newInstagram.trim().isEmpty()) {
                empresa.setInstagram(newInstagram);
            }
            System.out.println("Empresa actualizada: " + empresa.getCompanyName());
        } else {
            throw new IllegalArgumentException("Empresa no encontrada.");
        }
    }

    // Eliminar una empresa por su CNPJ
    public void deleteEmpresa(String cnpj) {
        Empresa empresa = findEmpresaByCNPJ(cnpj);
        if (empresa != null) {
            empresas.remove(empresa);
            System.out.println("Empresa eliminada: " + empresa.getCompanyName());
        } else {
            throw new IllegalArgumentException("Empresa no encontrada.");
        }
    }

    // Verificar si un CNPJ ya está registrado
    public boolean isCNPJTaken(String cnpj) {
        return findEmpresaByCNPJ(cnpj) != null;
    }

    // Obtener el total de empresas registradas
    public int getTotalEmpresas() {
        return empresas.size();
    }

    // Limpiar todas las empresas (útil para reiniciar el sistema)
    public void clearAllEmpresas() {
        empresas.clear();
        System.out.println("Todas las empresas han sido eliminadas.");
    }

    // Buscar empresas por un término (en nombre, CNPJ, email, etc.)
    public List<Empresa> searchEmpresas(String keyword) {
        List<Empresa> result = new ArrayList<>();
        for (Empresa empresa : empresas) {
            if (empresa.getCompanyName().toLowerCase().contains(keyword.toLowerCase()) || 
                empresa.getCnpj().toLowerCase().contains(keyword.toLowerCase()) || 
                empresa.getEmail().toLowerCase().contains(keyword.toLowerCase()) || 
                empresa.getPhone().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(empresa);
            }
        }
        return result;
    }

    // Método para mostrar todas las empresas en consola
    public void printAllEmpresas() {
        if (empresas.isEmpty()) {
            System.out.println("No hay empresas registradas.");
        } else {
            for (Empresa empresa : empresas) {
                System.out.println(empresa);
            }
        }
    }

    // Método para obtener una lista de empresas que ofrecen un tipo de servicio específico
    public List<Empresa> getEmpresasByServiceType(String serviceType) {
        List<Empresa> result = new ArrayList<>();
        for (Empresa empresa : empresas) {
            if (empresa.getServiceType().contains(serviceType)) {
                result.add(empresa);
            }
        }
        return result;
    }

    // Método para obtener empresas por días de servicio
    public List<Empresa> getEmpresasByServiceDay(String serviceDay) {
        List<Empresa> result = new ArrayList<>();
        for (Empresa empresa : empresas) {
            if (empresa.getServiceDays().contains(serviceDay)) {
                result.add(empresa);
            }
        }
        return result;
    }

    // Método para actualizar la dirección de una empresa
    public void updateAddress(String cnpj, String newStreet, String newNeighborhood, String newNumber, 
                              String newLatitude, String newLongitude) {
        Empresa empresa = findEmpresaByCNPJ(cnpj);
        if (empresa != null) {
            empresa.setStreet(newStreet);
            empresa.setNeighborhood(newNeighborhood);
            empresa.setNumber(newNumber);
            empresa.setLatitude(newLatitude);
            empresa.setLongitude(newLongitude);
            System.out.println("Dirección actualizada para la empresa: " + empresa.getCompanyName());
        } else {
            throw new IllegalArgumentException("Empresa no encontrada.");
        }
    }
}
