package library.system;

public class GuestMember extends LibraryMember {

    public GuestMember(int memberID, String name, String password) {
        super(memberID, name, password, 1);
    }

    @Override
    public boolean canBorrow() {
        return super.canBorrow();
    }
}

