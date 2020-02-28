package PageObjects.tools;


public class ApplicationTexts {
    private static String apptext = null;

    public static String peopleNearbyText(String apptext) {
        apptext = "People Nearby";
        return apptext;
    }

    public static String getFullAccessText(String apptext) {
        apptext = "Get Full Access";
        return apptext;
    }

    public static String activateSubscriptionText(String apptext) {
        apptext = "Activate Subscription";
        return apptext;
    }

    public static String sendMessagesText(String apptext) {
        apptext = "Send Messages";
        return apptext;
    }

    public static String chatWithAnyMemberText(String apptext) {
        apptext = "Chat with any member:\nfree and paid users can reply";
        return apptext;
    }

    public static String buySubscriptionText(String apptext) {
        apptext = "BUY SUBSCRIPTION";
        return apptext;
    }
}
