package file_handling.service;

public enum UserActions {

    LIST_CLUBS("1"),
    ADD_CLUBS("2"),
    LIST_MEMBERS("3"),
    ADD_MEMBER("4"),
    REMOVE_MEMBER("5"),
    EXIT("6");

    private String value;

    UserActions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean containsAction(String value) {
        UserActions[] actions = UserActions.values();

        for (UserActions action : actions) {
            if (action.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }
}
