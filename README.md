# Spray Webjars Example #

This is an example demonstrating usage of [webjars](http://www.webjars.org/) together with
[spray-can](http://spray.io/documentation/1.2.1/spray-can/) and
[spray-routing](http://spray.io/documentation/1.2.1/spray-routing/).

Since having used webjars together with [playframework](https://www.playframework.com/) for some time, this was the
natural choice for getting some static assets dependencies into a [spray.io](http://www.pray.io/) project that
I was playing around with.

Searching for some example of using webjars with spray didn't give any really clear answer how to do this.
However it turned out to be really simple to get it working by using the buildt in directive
[getfromresourcedirectory](http://spray.io/documentation/1.2.1/spray-routing/file-and-resource-directives/getFromResourceDirectory/#getfromresourcedirectory).

Since webjars essentially is files stored in jar files, that makes them available on the classpath.
This directive can be used to make a specific directory on the classpath available through http.

The following code shows how to set up a route to make all webjars that the project depends on
available at the path **/webjars**.

```scala   
pathPrefix("webjars") {
  get {
    getFromResourceDirectory("META-INF/resources/webjars")
  }
}
```

If then the jquery webjar was added as a maven dependency, ie:

 ```scala
 "org.webjars" % "jquery" % "2.1.1",
 ```
 
 It could be referenced from a html page through:

 ```html
 <script type="text/javascript" src="/webjars/jquery/2.1.1/jquery.min.js"></script>
 ```
                                                                                                                                                                                                                                   
## Running ##
                                                                                                                                                                                                                      
The easiest way to run this application is with the following command in the base directory:                                                                                                                                    
```                                                                                                                                                                                                                                
./activator run
```                                                                                                                                                                                                                                
After this the application can be accessed from a web browser at **http://localhost:8080/**.                                                              
                                                                                                                                                                                                                                   

## Licence ##

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

Copyright &copy; 2014- Björn Westlin.

