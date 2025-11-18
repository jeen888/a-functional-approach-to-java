//
// A FUNCTIONAL APPROACH TO JAVA
// Chapter 2 - Functional Java
//
// Example 2-3. Lambda variable capture
//

Runnable capture() {
    // The variable is declared in the scope of capture
    var theAnswer = 42;
    // int theAnswer = 42;

    Runnable printAnswer =
        // The lambda capture theAnswer for its operation
        () -> {
            // theAnswer++; // This would be a compile error: "Local variable defined in an enclosing scope must be final or effectively final"
            System.out.println("the answer is " + (theAnswer));
        };

    return printAnswer;
}


Runnable r = capture()
r.run()
Thread.sleep(1000);
r.run()
r.run()
/exit
