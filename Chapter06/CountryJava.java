package chapter6;

/**
 * Created by vika on 24/07/17.
 */
public class CountryJava {
    private String name;
    private String capital;

    public CountryJava(String name, String capital){
        this.name = name;
        this.capital = capital;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    public void setCapital(String capital){this.capital = capital;}
    public String getCapital(){return this.capital;}
}

class CountryJavaApp {
    public static void main(String[] args) {
        CountryJava country = new CountryJava("France", "Paris");
        System.out.println("Country Name: "+ country.getName() + " and Capital: "+ country.getCapital());
    }
}


