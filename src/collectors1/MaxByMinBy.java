
package collectors1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class MaxByMinBy {
    private String Name;
    private int Age;
    private double Salary;
    
    public MaxByMinBy(String Name,int Age,double Salary){
        this.Age=Age;
        this.Name=Name;
        this.Salary=Salary;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public double getSalary() {
        return Salary;
    }
    
     public String toString(){
        DecimalFormat dformat = new DecimalFormat(".##");
    return "Employee Name:"+this.Name
        + "  Age:"+this.Age
        + "  Salary:"+dformat.format(this.Salary);
  }
    public static List<MaxByMinBy> use(){
        List<MaxByMinBy> emp1=Arrays.asList(new MaxByMinBy("Tom", 23, 24000.0),
                    new MaxByMinBy("James", 45, 85000),
                    new MaxByMinBy("Ali", 98, 7500.99),
                    new MaxByMinBy("Ali", 19, 566.99),
                    new MaxByMinBy("Zain", 29, 866.99),
                    new MaxByMinBy("Ahmed", 22, 66.99),
                    new MaxByMinBy("Abu", 12, 686.99) );
         return emp1;
    }                     
       
   
}
