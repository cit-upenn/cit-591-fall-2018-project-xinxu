This project contains two packages with test and main. 

The main contains the main class called App which constructs all related objects and builds several windows. There are three separate classes that build three windows (ArtSearcherWindow, ErrorWindow and InformationWindow).

The ArtAnalysis class have two methods: getTitle() and getInfo(). The getTitle() method takes in the author name and return all the titles of paintings of this author into an ArrayList<String>. The getInfo() method takes in the title of painting and return all the related information regarding to the title into an ArrayList<String>. 

The Artwork class takes in String author, String lifespan, String title, String date, String technique, String location, String url, String form, String type, String school and String timeframe to construct the Artwork object. 

The CatalogFileReader reads in file, parses it and creates Artwork objects into an ArrayList<Artwork>.

The DataSender class reads in the html file and pass in the values of locations and titles of the art works.

The Geocoding sample.html takes in the locations and titles and generates related Google Map using the default browser.

The test contains test AppTest class that runs the test on all classes with coverage of 95-100% ( without testing GUI and setters in Artwork).

Test files from test0.txt to test9.txt are used to test the DataSender class.

