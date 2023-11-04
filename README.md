# Java demos - new language features from Java 11 to 21

This application helps to show some new features being introduced in Java versions until Java 21.

All relevant info is written down in comments inside sources.

## Prerequisites 
This project requires **Java JDK 21** to run. I namely use [GraalVM for JDK 21](https://medium.com/graalvm/graalvm-for-jdk-21-is-here-ee01177dd12d) for development and testing.

## Usage
Checkout the project and explore the files in your favorite IDE.

You can also `mvn clean install` the project and then just run `java --enable-preview --add-modules=jdk.incubator.vector -jar target\JavaDemos-2.0.jar`. 
But you may miss some important context and information without reading the comments in the source code. 

Note that `--enable-preview` and `--add-modules` options are necessary to make the newest Java language features available.

## Author
* alois.seckar@gmail.com
* http://alois-seckar.cz

## Extra - Java Features
[Java Features](JavaFeatures.md) is my list of all Java versions with all JEPs included in each release.

## Extra - Java Tech
[Java Tech](JavaTech.md) is my list of interesting projects based on Java.

## Extra - Java News
[Java News](JavaNews.md) is my list with interesting articles and information from Java world started since 09/2023.

## Extra - JEP Status
[JEP Status](JEPStatus.md) is my tracker of changes in [OpenJDK JEP Index](https://openjdk.org/jeps/0) since 09/2023.
