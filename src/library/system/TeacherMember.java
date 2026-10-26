package library.system;

public class TeacherMember extends LibraryMember {

    public TeacherMember(int memberID, String name, String password) {
        super(memberID, name, password, 5);
    }

    @Override
    public boolean canBorrow() {
        return super.canBorrow();
    }
}

