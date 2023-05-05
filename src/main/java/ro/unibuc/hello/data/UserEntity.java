
package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

import java.util.Random;

public class UserEntity {
    @Id
    private long id = new Random().nextInt() & Integer.MAX_VALUE;;
    private String firstName;
    private String lastName;
    private String email;
    private String name;
    private String password;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, String email,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.name = firstName + " " + lastName;
        this.password = password;
    }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}


