package com.example.pharmacymedicalshop;

public class UserData {
    String useremail;
    String userpassword;
    String username;
    String usernumber;
    String userpincode;
    String userlocality;
    String usercity;
    String userstate;
    String userlandmark;
    String useralternativenumber;
    String profileImg;


    public UserData() {
    }

    public UserData(String useremail, String userpassword, String username, String usernumber, String userpincode, String userlocality, String usercity, String userstate, String userlandmark, String useralternativenumber) {
        this.useremail = useremail;
        this.userpassword = userpassword;
        this.username = username;
        this.usernumber = usernumber;
        this.userpincode = userpincode;
        this.userlocality = userlocality;
        this.usercity = usercity;
        this.userstate = userstate;
        this.userlandmark = userlandmark;
        this.useralternativenumber = useralternativenumber;
        this.profileImg = profileImg;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getUserpincode() {
        return userpincode;
    }

    public void setUserpincode(String userpincode) {
        this.userpincode = userpincode;
    }

    public String getUserlocality() {
        return userlocality;
    }

    public void setUserlocality(String userlocality) {
        this.userlocality = userlocality;
    }

    public String getUsercity() {
        return usercity;
    }

    public void setUsercity(String usercity) {
        this.usercity = usercity;
    }

    public String getUserstate() {
        return userstate;
    }

    public void setUserstate(String userstate) {
        this.userstate = userstate;
    }

    public String getUserlandmark() {
        return userlandmark;
    }

    public void setUserlandmark(String userlandmark) {
        this.userlandmark = userlandmark;
    }

    public String getUseralternativenumber() {
        return useralternativenumber;
    }

    public void setUseralternativenumber(String useralternativenumber) {
        this.useralternativenumber = useralternativenumber;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}
