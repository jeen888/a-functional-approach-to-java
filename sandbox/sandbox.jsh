// Function<String, Integer> strToLen = s -> s.length();
// var result= strToLen.apply("Hello, World!");
// System.out.println(result);  // 13
// // System.out.println(strToLen("Hello, World!")); // compile error

// var hex = Integer.toHexString(255);
// System.out.println(hex); // "ff"

// #함수형 컴포지션 예제1
// Function<String, String> removeLowerCaseA=str->str.replace("a","");
// Function<String, String> upperCase= String::toUpperCase;
// Function<String, String> upperCase2= str->"PREPIX_"+str.toUpperCase();

// var input="Java has lambdas";
// var result=removeLowerCaseA.andThen(upperCase).andThen(upperCase2).apply(input);
// System.out.println(result); // "JV HS LMBDS"

// #함수형 컴포지션 예제2
// UnaryOperator<String> removeLowerCaseA=str->str.replace("a","");
// UnaryOperator<String> upperCase= String::toUpperCase;
// UnaryOperator<String> upperCase2= str->"PREPIX_"+str.toUpperCase();

// var input="Java has lambdas";
// var result=removeLowerCaseA.andThen(upperCase).andThen(upperCase2).apply(input);
// System.out.println(result); // "JV HS LMBDS"



/exit