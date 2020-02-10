package mappers;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MyObjectMapper {

    private String name;
    private String lastName;
    private String email;
    private String msdmin;
    private Address address;
    private Operator operator;
    private PersonalData personalData;

    public MyObjectMapper() {
        name = "Marek";
        lastName = "Nowak";
        email = "kamil@assecods.pl";
        msdmin = "48123456789";
        address = new Address().setAdresLine1("ul. Polskich Marynarzy 111/111").setCity("Szczecin").setPostCode("71-050");
        operator = new Operator().setCode("123456").setName("OperatorJanek");
        personalData = new PersonalData().setValue("123456").setIdType("passport");
    }

    public String getName() {
        return name;
    }

    public MyObjectMapper setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public MyObjectMapper setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MyObjectMapper setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMsdmin() {
        return msdmin;
    }

    public MyObjectMapper setMsdmin(String msdmin) {
        this.msdmin = msdmin;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public MyObjectMapper setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Operator getOperator() {
        return operator;
    }

    public MyObjectMapper setOperator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public MyObjectMapper setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }
}

class Address {
    String AdresLine1;
    String city;
    String postCode;

    public String getAdresLine1() {
        return AdresLine1;
    }

    public Address setAdresLine1(String adresLine1) {
        AdresLine1 = adresLine1;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public Address setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }
}

class Operator {
    String Name;
    String code;

    public String getName() {
        return Name;
    }

    public Operator setName(String name) {
        Name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Operator setCode(String code) {
        this.code = code;
        return this;
    }
}

class PersonalData {
    String idType;
    String value;

    public String getIdType() {
        return idType;
    }

    public PersonalData setIdType(String idType) {
        this.idType = idType;
        return this;
    }

    public String getValue() {
        return value;
    }

    public PersonalData setValue(String value) {
        this.value = value;
        return this;
    }
}