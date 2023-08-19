package models;

public enum Role {
    ADMIN("Admin"),
    Chef("Chef"),
	Restaurateur("Restaurateur");

    private String role;

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

