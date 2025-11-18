// Function<String, Integer> strToLen = s -> s.length();
// var result= strToLen.apply("Hello, World!");
// System.out.println(result);  // 13
// // System.out.println(strToLen("Hello, World!")); // compile error

// var hex = Integer.toHexString(255);
// System.out.println(hex); // "ff"

Function<String, String> removeLowerCaseA=str->str.replace("a","");
Function<String, String> upperCase= String::toUpperCase;
Function<String, String> upperCase2= str->"PREPIX_"+str.toUpperCase();

var input="Java has lambdas";
var result=removeLowerCaseA.andThen(upperCase).andThen(upperCase2).apply(input);
System.out.println(result); // "JV HS LMBDS"

/exit