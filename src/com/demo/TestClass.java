package com.demo;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public class TestClass {

	//BiFunction<String,Integer,Apple> c3 = (color,weight) -> new Apple(color,weight);
	Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
	   // stream.map(String::toUpperCase).forEach(System.out::println);
	
}
