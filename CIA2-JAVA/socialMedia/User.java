package socialMedia;

/**
 * abstract class User
 */
abstract class User {
    protected String userId;
    protected String userName;
    protected String email;

    public User(String userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public abstract void displayProfile();
}