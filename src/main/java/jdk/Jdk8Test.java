package jdk;


import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by think on 2019/12/26.
 */
public class Jdk8Test {
    List<Employee> employees = Arrays.asList(
            new Employee(1,"张三",22,5000.22),
            new Employee(2,"李四",25,3000.22),
            new Employee(3,"王五",23,4000.22),
            new Employee(4,"赵六",34,9000.22),
            new Employee(5,"钱七",52,1000.22),
            new Employee(6,"王八",62,3000.22),
            new Employee(7,"阿九",32,2000.22)
    );
    @Test
    public void test7(){
        List<Double> collect = employees.stream().map(Employee::getSalary).collect(Collectors.toList());
        collect.forEach(System.out::println);
        HashSet<String> collect1 = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        Map<Double, List<Employee>> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println(collect2);
    }
    @Test
    public void test6(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1.get());
    }

    @Test
    public void test5(){
        List<String> list = Arrays.asList("eaa1","bb2","3cc");
        //list.stream().flatMap(Jdk8Test::filterCharacter).forEach(System.out::println);
        //list.stream().sorted().forEach(System.out::println);
        long count = employees.stream().count();
        System.out.println(count);
        Optional<Employee> max = employees.stream().max((x, y) -> Double.compare(x.getSalary(), y.getSalary()));
        Employee employee = max.get();
        System.out.println(employee);
    }

    public static Stream<Character> filterCharacter(String str){
        List list = new ArrayList();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            list.add(c);
        }
        return list.stream();
    }
    @Test
    public void test(){
        List<String> list = Arrays.asList("1","2","3");
        list.forEach(System.out::print);
    }

    @Test
    public void test2(){
        //Consumer<String> con = x -> System.out.println(x);
        //Consumer<String> con1 = System.out::println;
        //employees.stream().filter(x -> x.getSalary()>5000)
        //        .forEach(System.out::println);
        employees.stream().map(Employee::getName)
                .forEach(System.out::println);
    }
    @Test
    public void test3(){
        Integer num = operator(100, x -> x * x);
        System.out.println(num);
    }

    public Integer operator(Integer num, Function<Integer,Integer> fun){
        return fun.apply(num);
    }
    @Test
    public void test4(){
        String s = strHander("  111   ", x -> x.trim());
        System.out.println(s);
    }
    private String strHander(String str,Function<String,String> fun){
        return fun.apply(str);
    }
}
