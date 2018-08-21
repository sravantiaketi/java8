package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApples {
	
	 public static void main(String ... args){
		 List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                 new Apple(155, "green"),
                 new Apple(120, "red"));
		 
		 List<Apple> greenApples =  filterApples(inventory,FilteringApples::isGreenApple);
		  System.out.println(greenApples);
		  
		  List<Apple> greenApples2 =  filterApples(inventory,(Apple a) -> "green".equals(a.getColor()));
		  System.out.println(greenApples2);
		  
		  //streams
		  List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(Collectors.toList());
		  System.out.println(heavyApples);
		  
		 inventory.sort((Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		 
		 System.out.print(inventory);
		 
		 Thread t = new Thread(() -> System.out.println("Hello World"));
		 
		 Function<BufferedReader, String> f =
				 (BufferedReader b) -> {
				 try {
				 return b.readLine();
				 }
				 catch(IOException e) {
				 throw new RuntimeException(e);
				 }
				 };
			//	 f.apply(t);
				// f.andThen(arg0)
		// t.start();
	 }
	 
	 public static List<Apple> filterHeavyApples(List<Apple> inventory){
	        List<Apple> result = new ArrayList<>();
	        for (Apple apple: inventory){
	            if (apple.getWeight() > 150) {
	                result.add(apple);
	            }
	        }
	        return result;
	    }
	 public static List<Apple> filterGreenApples(List<Apple> inventory){
	        List<Apple> result = new ArrayList<>();
	        for (Apple apple: inventory){
	            if ("green".equals(apple.getColor())) {
	                result.add(apple);
	            }
	        }
	        return result;
	    }
	  public static boolean isGreenApple(Apple apple) {
	        return "green".equals(apple.getColor()); 
	    }

	    public static boolean isHeavyApple(Apple apple) {
	        return apple.getWeight() > 150;
	    }
	  public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
	        List<Apple> result = new ArrayList<>();
	        for(Apple apple : inventory){
	            if(p.test(apple)){
	                result.add(apple);
	            }
	        }
	        return result;
	    }       
	 public static class Apple {
	        private int weight = 0;
	        private String color = "";

	        public Apple(int weight, String color){
	            this.weight = weight;
	            this.color = color;
	        }

	        public Integer getWeight() {
	            return weight;
	        }

	        public void setWeight(Integer weight) {
	            this.weight = weight;
	        }

	        public String getColor() {
	            return color;
	        }

	        public void setColor(String color) {
	            this.color = color;
	        }

	        public String toString() {
	            return "Apple{" +
	                   "color='" + color + '\'' +
	                   ", weight=" + weight +
	                   '}';
	        }
	    }
}
