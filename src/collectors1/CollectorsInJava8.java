
package collectors1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
public class CollectorsInJava8 {

    public static void main(String[] args) {
        System.out.println("---Joining()----");
        List<String> Example1=Arrays.asList("A","B","C","D","E","F","G","H");
        String result=Example1.stream().collect(Collectors.joining());
        String result1=Example1.stream().collect(Collectors.joining("-"));
        String result2=Example1.stream().collect(Collectors.joining("-","[","]"));
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        
        System.out.println("---MaxBy/MinBy Collectors in Java 8---");
        //Compare By Salary
        Optional<MaxByMinBy> Example2=MaxByMinBy.use().stream().collect(Collectors.maxBy(Comparator.comparing(MaxByMinBy::getSalary)));
        System.out.println(Example2.get());
        //Compare By age
        Optional<MaxByMinBy> Example3=MaxByMinBy.use().stream().collect(Collectors.maxBy(Comparator.comparing(MaxByMinBy::getAge)));
        System.out.println(Example3.isPresent()? Example3.get(): "Invalid ");
        //compare by minimum Salary
        Optional<MaxByMinBy> Example4=MaxByMinBy.use().stream().collect(Collectors.minBy(Comparator.comparing(MaxByMinBy::getSalary)));
        System.out.println(Example4.get());
        
        System.out.println("---Mapping----");
        List<String> getByEmpName=MaxByMinBy.use().stream().collect(Collectors.mapping(MaxByMinBy::getName, Collectors.toList()));
        System.out.println("List of Employees Name: "+getByEmpName);
        
        List<Integer> getByEmpAge=MaxByMinBy.use().stream().collect(Collectors.mapping(MaxByMinBy::getAge, Collectors.toList()));
        System.out.println("List of Employees Age:"+getByEmpAge);
        
        Optional<Integer> getByEmpAge1=MaxByMinBy.use().stream().collect(Collectors.mapping(MaxByMinBy:: getAge,Collectors.maxBy(Integer:: compareTo)));
        System.out.println("Maximum age in Employess:"+getByEmpAge1);
        // The difference btw filter and partitioning is filter only shows the correct result.
        // whereAs Partioning shows the true and false results.
        System.out.println("-----Partitioning By--------");
        //Partitioning and giving the details.
        Map<Boolean,List<MaxByMinBy>> partioningByName=MaxByMinBy.use().stream()
                .collect(Collectors.partitioningBy((MaxByMinBy g)->g.getAge()>30));
        System.out.println("Ages greater then 30: "+ partioningByName);
        
        //Partitioning and giving the number of employees according to true and false result.
        Map<Boolean,Long> partioningByNameCount=MaxByMinBy.use().stream()
                .collect(Collectors.partitioningBy((MaxByMinBy g)->g.getAge()>30,Collectors.counting()));
        System.out.println("Ages greater then 30: "+ partioningByNameCount);
        
        
    }
    
}
