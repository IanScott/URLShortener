# URL Shortener

A URL shortener server in Java using Embedded Tomcat, Spring, and mysql.


## Getting Started

To build the application:

    mvn clean install

This command will compile, execute the tests, package an executable Jar file.


To run the application without Docker:
 
    cd target/
    java -jar urlshortener-0.0.1-SNAPSHOT.jar
    
    
## Entry points

The application has 3 entry points. 2 POSTs and 1 GET.

<BaseURl>/shortener/shorten
This entry point takes the following example JSON: {"longUrl": <url to shorten>} and returns 
{"shortUrl": <shotende url>}

<BaseURl>/shortener/enlarge
This entry point is an inversion of the first.

<BaseURl>/{unique Url Id}
This entry point redirects a short url to the original url.

## Application Configuration
All custom configuration is found in the application.properties file.
All properties but one are standard Spring Boot.
BaseUrl contains the baseurl of the application. This is needed so the application can create real working shortend urls.
 
