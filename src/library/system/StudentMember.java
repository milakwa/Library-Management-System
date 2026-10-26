package library.system;

public class StudentMember extends LibraryMember {

    public StudentMember(int MemberID, String Name, String Password) {
        super(MemberID, Name, Password, 3);
    }

    @Override
    public boolean canBorrow() {
        return super.canBorrow();
    }

}
