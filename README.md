# ShapeStacker
This was an interview project. The goal was to create a program that would take in a list of shapes and their dimensions, and stack them based on size.
The majority of the decisions like "how to tell when one shape will fit on another" and "identifying multiple shapes of the same type" were left up to me. 
This is built with Java in Idea, to test my familiarity with OOP.

Some notes:
```
-I wrote this in about 6 hours, most of it was just reducing the complexity of my original design. I went with the most simple decisions for fitsOn calculation, identifying multiple shapes, output formatting, etc.
-I got way too sidetracked thinking I needed to calculate largest inscribed shape inside another shape. Probably not necessary to do that much math, so I set the check to be a simple Shape1 area >= Shape2 area, so shapes stack when their area is equivalent or smaller. 
-I started with an interface for Shape but ran into some problems with passing it as an argument in the Shapestacker class methods.
-I also got a little tripped up just setting the abstract Shapes class to what seemed best, and whether the subclasses should have the Area field, getter methods, small stuff.
-I went with a console input prompt rather than command line arguments because that's what I'm most used to. I've done args but I wanted to get this done quickly. 
```

## Running
To run, open in Idea, or compile ShapeStacker and run in bash. The input prompt is pretty self explanatory.
