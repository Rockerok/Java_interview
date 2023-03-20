package HW1.HW_1_1;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    // Пример Билдера, но на Спринге было бы быстрее и проще при подключении Ломбока и использованием анотаций
    //@Data @NoArgsConstructor и использованием плагина по созданию Билдера
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private Person (Builder builder) {
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setMiddleName(builder.middleName);
        setCountry(builder.country);
        setAddress(builder.address);
        setPhone(builder.phone);
        setAge(builder.age);
        setGender(builder.gender);
    }

    public static Builder newBuilder() {
        return new Builder();
    }
    private void Builder() {
    }

    public static Builder newBuilder(Person person) {
        Builder builder = new Builder();
        builder.firstName = person.getFirstName();
        builder.lastName = person.getLastName();
        builder.middleName = person.getMiddleName();
        builder.country = person.getCountry();
        builder.address = person.getAddress();
        builder.phone = person.getPhone();
        builder.age = person.getAge();
        builder.gender = person.getGender();
        return builder;
    }


    public static final class Builder {
        public String firstName;
        public String lastName;
        public String middleName;
        public String country;
        public String address;
        public String phone;
        public int age;
        public String gender;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
