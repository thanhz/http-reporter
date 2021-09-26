# http-reporter
## _Introduction_
A command line application to generate json report containing url, status code, content-length & date
## Features

- command line for ease of use
- Verifies validity of url
- Process urls in batch



## How to run

## Method 1
If you have an IDE like intellij installed, simply import/clone the project and run 'Runner.java'
To run the test, run HttpRequesterTest.java located in src/test/java/HttpRequesterTest.java

## Method 2
Navigate to where you extracted the application and type the following
```sh
cd src/main/java
javac Runner.java
java Runner
```
To run the test,
```sh
cd to src/test/java
javac HttpRequesterTest.java
java HttpRequesterTest
```
## Commands
After you've followed the steps above you should be prompted with the following options

| Option | Description |
| ------ | ------ |
| 0. Quit | Quits the application |
| 1. View current url list | View the list of urls ready for a report to be generated |
| 2. Add url to list | Add a new url to the above list (Urls will be validated prior to adding) |
| 3. Generate url report | Generates json from the list provided |
