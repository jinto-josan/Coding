package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class JStreams {

    public record Person(String name, int age) {}
    public static class Transaction {
        int id;
        double amount;
        String category;

        public Transaction(int id, double amount, String category) {
            this.id = id;
            this.amount = amount;
            this.category = category;
        }
    }

    /**
     * To filter out even numbers from a list of integers
     */
    public static void filterEvenNumber(List<Integer> integerList){
        List<Integer> evenNumbersList = integerList.stream()
                .filter(i -> i%2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers list: " + evenNumbersList);
    }
    /**
     * To group people by name and return age of person with same name
     */
    public static void groupPeopleByNameAndReturnAge(List<Person> peopleList){
        var groupedPeople = peopleList.stream()
                .collect(Collectors.groupingBy(Person::name,
                        Collectors.mapping(Person::age, Collectors.toList())));
        System.out.println("Grouped people: " + groupedPeople);
    }
    /**
     * To group people by name and age of person with same name
     */
    public static void groupPeopleByNameAndAge(List<Person> peopleList){
        var groupedPeople = peopleList.stream()
                .collect(Collectors.groupingBy(person -> person));
        System.out.println("Grouped people: " + groupedPeople);
    }
    /**
     * To find the sum of all elements in a list of list of integers
     */
    public static void sumOfAllElements(List<List<Integer>> listOfLists) {
        int sum = listOfLists.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of all elements: " + sum);
    }
    /**
     * To group a list of string by their length
     */
    public static void groupByStringLength(List<String> stringList) {
        var groupedStrings = stringList.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped strings: " + groupedStrings);
    }
    /**
     * To group a list of string by their first character
     */
    public static void groupByFirstCharacter(List<String> stringList) {
        var groupedStrings = stringList.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("Grouped strings: " + groupedStrings);
    }
    /**
     * To find the average of age of people by name
     */
    public static void averageAgeByName(List<Person> peopleList) {
        var averageAgeByName = peopleList.stream()
                .collect(Collectors.groupingBy(Person::name,
                        Collectors.averagingInt(Person::age)));
        System.out.println("Average age by name: " + averageAgeByName);
    }
    /**
     * Group people by age and partition them by whether they are adults or not
     */
    public static void groupByAgeAndPartitionByAdult(List<Person> peopleList) {
        var groupedPeople = peopleList.stream()
                .collect(Collectors.partitioningBy(person -> person.age() >= 18,
                        Collectors.groupingBy(Person::age)));
        System.out.println("Grouped people: " + groupedPeople);
    }
    /**
     * Given a list of Transaction objects with the following fields: id, amount, and category,
     * group the transactions by their category and partition the results into high and low amounts
     * based on a threshold (e.g., 500).
     */
    public static void groupByCategoryAndPartitionByAmount(List<Transaction> transactions, double threshold) {
        var groupedTransactions = transactions.stream()
                .collect(Collectors.groupingBy(t->t.category,
                        Collectors.partitioningBy(transaction -> transaction.amount > threshold)));
        System.out.println("Grouped transactions: " + groupedTransactions);
    }
    /**
     * To get min and max transaction for each category
     */
    public static void minMaxTransactionByCategory(List<Transaction> transactions) {
        var minMaxTransactions = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> transaction.category,
                        Collectors.collectingAndThen(Collectors.minBy((t1, t2) -> Double.compare(t1.amount, t2.amount)),
                                minTransaction -> minTransaction.get().amount + " " +
                                        transactions.stream()
                                                .filter(transaction -> transaction.category.equals(minTransaction.get().category))
                                                .max((t1, t2) -> Double.compare(t1.amount, t2.amount)).get().amount)));
        System.out.println("Min and max transactions: " + minMaxTransactions);
    }
    /**
     * From a list of list of transaction get all transaction of category "grocery"
     */
    public static void getAllGroceryTransactions(List<List<Transaction>> transactions) {
        List<Transaction> groceryTransactions = transactions.stream()
                .flatMap(List::stream)
                .filter(transaction -> transaction.category.equals("grocery"))
                .collect(Collectors.toList());
        System.out.println("Grocery transactions: " + groceryTransactions);
    }
}
