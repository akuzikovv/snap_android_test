package androidAutomation.pages;

import org.junit.Before;
import org.junit.Test;
import org.yecht.Data;

public class Run {
    private UserController userController;

    @Before
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void testUserInfoResponse(String email, String timezone, String description) {
        User remoteUser = userController.getUserInfo( email, timezone,description );
        System.out.println(remoteUser);

    }

    @Test
    public void testgetall() throws Exception {
        try {
            userController.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
