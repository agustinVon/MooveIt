package moovme.Users;

public class PhoneNumber {

    private final int number;

    public PhoneNumber(int number){
        this.number=number;
    }


    public boolean equals(Object o){
        if(o instanceof com.spacetech.moovme.Users.PhoneNumber){
            return ((com.spacetech.moovme.Users.PhoneNumber) o).getNumber()== this.getNumber();
        }
        else return false;
    }

    public int getNumber() {
        return number;
    }
}
