package rsrepo.groupware.mygroupware;

public enum Role {
    ADMIN("ROLE_ADMIN"),
    GENERAL("ROLE_GENERAL"),
    ;

    private final String text;

    private Role(final String text) {
        this.text = text;
    }

    public String getString() {
        return this.text;
    }
}