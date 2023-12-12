package socialMedia;

import java.util.*;;

/**
 * RegularUser
 */

public class RegularUser extends User implements Post {
    private ArrayList<String> postList;

    public RegularUser(String userId, String userName, String email) {
        super(userId, userName, email);
        this.postList = new ArrayList<>();
    }

    @Override
    public void displayProfile() {
        System.out.println("Regular User Profile:");
        System.out.println("User ID: " + userId);
        System.out.println("User Name: " + userName);
        System.out.println("Email: " + email);
        System.out.println("Posts: " + postList.size());
    }

    @Override
    public void createPost(String content) {
        String postId = "P" + postList.size();
        postList.add(postId);
        System.out.println("Post created successfully with ID: " + postId);
    }

    @Override
    public void displayPost(String postId) {
        System.out.println("Displaying post : " + postList + " of " + postId);
    }
}