package com.example.coco.coconfctag.loginmodule;

/**
 * Created by cocoadmin on 6/8/2017.
 */

public class User
{


    private String PostalCode="";

    private String Region="";

    private String Email="";



    private String Address="";

    private String Password="";

    private String FirstName="";

    private String UserId="";



    private String LastName="";

    private String City="";

    private String Country="";
    private String Fax="";
    private String Phone="";

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPostalCode ()
    {
        return PostalCode;
    }

    public void setPostalCode (String PostalCode)
    {
        this.PostalCode = PostalCode;
    }

    public String getRegion ()
    {
        return Region;
    }

    public void setRegion (String Region)
    {
        this.Region = Region;
    }

    public String getEmail ()
    {
        return Email;
    }

    public void setEmail (String Email)
    {
        this.Email = Email;
    }


    public String getAddress ()
    {
        return Address;
    }

    public void setAddress (String Address)
    {
        this.Address = Address;
    }

    public String getPassword ()
    {
        return Password;
    }

    public void setPassword (String Password)
    {
        this.Password = Password;
    }

    public String getFirstName ()
    {
        return FirstName;
    }

    public void setFirstName (String FirstName)
    {
        this.FirstName = FirstName;
    }

    public String getUserId ()
    {
        return UserId;
    }

    public void setUserId (String UserId)
    {
        this.UserId = UserId;
    }



    public String getLastName ()
    {
        return LastName;
    }

    public void setLastName (String LastName)
    {
        this.LastName = LastName;
    }

    public String getCity ()
    {
        return City;
    }

    public void setCity (String City)
    {
        this.City = City;
    }

    @Override
    public String toString() {
        return "User{" +
                "PostalCode='" + PostalCode + '\'' +
                ", Region='" + Region + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", Password='" + Password + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", UserId='" + UserId + '\'' +
                ", LastName='" + LastName + '\'' +
                ", City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                ", Fax='" + Fax + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}