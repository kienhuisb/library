## Fross Common Library Classes

I had repeated several classes in many of my programs and updating that had become tiresome.  I have begun to extract common classes that are use quite a bit into it's own project.  This can now be setup as a dependency and when I need to update it, I only have to do so in one place and then rebuild the dependent programs.

## Install into Maven .M2 Cache

In Eclipse, in order to setup a dependency, you must install the **library** classes into the Maven local cache.  You'll need to perform these steps whenever it is updated, so that the applications that depend on it will get the latest.

 1. Clone the  **library** project and import it into Eclipse
 2. Ensure it builds correctly with **mvn package** command
 3. In the Library project, right click the pom.xml file and select RunAs|Maven install.  
 4. Assuming that was successful, you should see output that talks about a successful installation.
 
 If you are not using Eclipse, you can install the **library** classes into the Maven repostiory using:

    mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=<path-to-file>

## Setting Up a Project to Depend on Library
Ok, now that we have **library** built and installed, we need to set it up as an Eclipse dependency.

 1. In Eclipse, select the main project, right click and choose Maven|Add Dependency
 2. Add the GroupID as: **org.fross**
 3. Add the ArtifactID as: **library**
 4. Add the current version
 5. In the search field, enter: **fross** and you should see your open projects.  **Select org.fross library**
 6. This will add a dependency line in your pom.xml file as well as setting up Eclipse to use it.  You should now see library in your Maven Dependencies within Eclipse.

## Using the library classes
This is fairly simple.  Just import the class into your files as in:

    import org.fross.library.Output;

After this everything should compile fine and you'll be good to go.  Just  remember to update the Maven cache when library is changed or if you delete the cache for some reason.

## License
[The MIT License](https://opensource.org/licenses/MIT)  [https://opensource.org/licenses/MIT](https://opensource.org/licenses/MIT)

Copyright 2019 by Michael Fross

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
