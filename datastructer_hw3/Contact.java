    package datastructer_hw3;
    
    //Emre Karaburu 
    
    public class Contact {

        String firstName;
        String lastName;
        String phoneNumber;
        String emailAddress;

        public Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }

        @Override
        public String toString() {
            return String.format("%s,%s,%s,%s", firstName, lastName, phoneNumber, emailAddress);
        }
    }
