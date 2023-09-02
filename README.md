# Java demos - new language features from Java 11 to Java 21

This application helps to show some new features being introduced in Java versions until Java 21.

All relevant info is written down in comments inside sources.

## Java News
Since september 2023 [there is file](JavaNews.md) with interesting articles and information from Java world. 

## Usage
Checkout the project and explore the files in your favorite IDE.

You can also `mvn clean install` the project and then just run `java --enable-preview --add-modules=jdk.incubator.concurrent,jdk.incubator.vector -jar target\JavaDemos-2.0.jar`. 
But you may miss some important context and information without reading the comments in the source code. 

Note that `--enable-preview` and `--add-modules` options are necessary to make the newest Java language features available.

## Author
* alois.seckar@atos.net
* http://alois-seckar.cz
