public class Passenger {
    private final String passengerID;
    private final String survived;
    private final String Pclass;
    private String name;        ///////
    private final String sex;
    private final String age;
    private final String SibSP;
    private final String Parch;
    private final String Ticket;
    private final String Fare;
    private final String Cabin;
    private final String Embarked;

   /* private final String seaPort1="C";
    private final String seaPort2="Q";
    private final String seaPort3="S";
    private final String sex1="male";
    private final String sex2="female";
    private final String class1="1";
    private final String class2="2";
    private final String class3="3";
    private final String status1="0"; // לא שרד
    private final String status2="1"; // שרד*/


    public Passenger(String[] values){
        this.passengerID = values[0];
        this.survived=values[1];
        this.Pclass=values[2];
        this.name = values[3];
        this.sex=values[5];
        this.age = values[6];
        this.SibSP = values[7];
        this.Parch = values[8];
        this.Ticket = values[9];
        this.Cabin = values[10];
        this.Fare = values[11];
        this.Embarked=values[12];


    }
    public String getPassengerID(){return this.passengerID;}
    public String getSurvived(){return this.survived;}
    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}
    public String getPclass(){return this.Pclass;}
    public String getSex(){return this.sex;}
    public String getAge(){return this.age;}
    public String getSibSP(){return this.SibSP;}
    public String getParch(){return this.Parch;}
    public String getTicket(){return this.Ticket;}
    public String getFare(){return this.Fare;}
    public String getCabin(){return this.Cabin;}
    public String getEmbarked(){return this.Embarked;}


}

