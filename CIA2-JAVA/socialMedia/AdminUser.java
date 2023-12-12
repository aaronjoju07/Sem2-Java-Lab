package socialMedia;

public class AdminUser extends User {
    private String permissions;

    public AdminUser(String userId, String userName, String email, String permissions) {
        super(userId, userName, email);
        this.permissions = permissions;
    }

    @Override
    public void displayProfile() {
        System.out.println("Admin User Profile:");
        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Permissions: " + permissions);
    }
}