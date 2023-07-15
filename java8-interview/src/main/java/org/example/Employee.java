package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class Employee
{
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getGender()
    {
        return gender;
    }
    public String getDepartment()
    {
        return department;
    }
    public int getYearOfJoining()
    {
        return yearOfJoining;
    }
    public double getSalary()
    {
        return salary;
    }
    @Override
    public String toString()
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

//        getCountOfMaleAndFemale(employeeList);
//        namesOfDepartmentInOrg(employeeList);
//        avgAgeOfMaleAndFemaleEmp(employeeList);
//        empWhoJoingAfter2015(employeeList);
//        noEmpEachDepartment(employeeList);
//        avgSalaryEachDepartment(employeeList);
//        oldestEmpAgeAndDepartment(employeeList);
//        avgAndTotalSalOfOrg(employeeList);
        listEmpOfDepartment(employeeList);

        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        String str = "Java articles are Awesome";
        int[] nums = { 99, 55, 203, 99, 4, 91 };

        List<String> list1 = Arrays.asList("Java", "8", null);
        List<String> list2 = Arrays.asList("explained", "through", "programs");
//        findEvenNumbers(list);
//        numbersStartingWithOne(list);
//        duplicateElementInList(list);
//        nonRepetingCharacter(str);
//        findIfListHasDuplicatesOrNot(nums);
//        concateTwoList(list1, list2);
//        sortAndConvertToStream(nums);


    }

    private static void sortAndConvertToStream(int[] nums) {
        Arrays.parallelSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void concateTwoList(List<String> list1, List<String> list2) {
        List<String> concatList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        Optional.ofNullable(concatList)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    private static void findIfListHasDuplicatesOrNot(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(list);
        if(set.size() == list.size()) {
            System.out.println("no Duplicates in list");
        } else {
            System.out.println("Duplicates in list");
        }
    }

    private static void nonRepetingCharacter(String str) {
        str.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char)c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue()==1).findFirst().ifPresent(System.out::println);
//                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static void duplicateElementInList(List<Integer> list) {
        list.stream().filter(n -> Collections.frequency(list, n) >1).distinct().forEach(System.out::println);
        Set<Integer> set = new HashSet<>();
        System.out.println("second Method------");
        list.stream().filter(n -> !set.add(n)).forEach(System.out::println);
    }

    private static void numbersStartingWithOne(List<Integer> list) {

        list.stream().map(n -> n+"").filter(s -> s.startsWith("1")).forEach(System.out::println);
    }

    private static void findEvenNumbers(List<Integer> list) {
        List<Integer> data = list.stream().filter(n -> n%2==0).collect(Collectors.toList());
        Optional.ofNullable(data)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    private static void listEmpOfDepartment(List<Employee> employeeList) {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream().forEach(e -> e.getValue().stream().map(emp -> emp.getDepartment()+": "+ emp.getName()).forEach(System.out::println));

    }

    private static void avgAndTotalSalOfOrg(List<Employee> employeeList) {
        DoubleSummaryStatistics stats =  employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(stats.getAverage() + ": " + stats.getSum());
    }

    private static void oldestEmpAgeAndDepartment(List<Employee> employeeList) {
        employeeList.stream().max(Comparator.comparing(Employee::getAge)).ifPresent(e -> System.out.println(e.getAge() + ": "+ e.getDepartment()));
    }


    private static void avgSalaryEachDepartment(List<Employee> employeeList) {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream().forEach(e -> System.out.println(e.getKey()+": "+e.getValue()));
    }

    private static void noEmpEachDepartment(List<Employee> employeeList) {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().forEach(e -> System.out.println(e.getKey()+": "+ e.getValue()));
    }

    private static void empWhoJoingAfter2015(List<Employee> employeeList) {
        employeeList.stream().filter(e -> e.yearOfJoining > 2015).map(Employee::getName).forEach(System.out::println);
    }


    private static void avgAgeOfMaleAndFemaleEmp(List<Employee> employeeList) {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)))
                .entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    private static void namesOfDepartmentInOrg(List<Employee> employeeList) {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    public static void getCountOfMaleAndFemale(List<Employee> employeeList) {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
                .entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }


}
