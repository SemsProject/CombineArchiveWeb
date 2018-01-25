CombineArchive Web - Build and Installation Instructions 
==========================================================

Requirements 
-------------

The CombineArchive Web Project is a Java web application build with the maven build management tool, so to compile it on your own system, you will need following software packages:

* [Java SDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 7 or above
* [Maven](http://maven.apache.org/)3
* [Git](http://git-scm.com/)

In order to run the application you also need to install a servlet container like [tomcat](http://tomcat.apache.org/).

Download and Compile the Source 
--------------------------------

After you installed all neccessary tools, it is time to download the source of the main project with git. This can be accomplished by executing following command on the command line/bash:

```
git clone https://github.com/SemsProject/CombineArchiveWeb
```

This creates a new folder called `combinearchiveweb`. Switch into it and start the compiling process with maven:

```
mvn package
```

Maven will start to download all dependencies from the central maven repository and from the [SEMS maven repository](https://sems.uni-rostock.de/2013/10/maven-repository/) and than it will compile the sources and link all libraries into the target directory, which leads into the creation of a `.war` file in the `target` directory.

If you want to compile the SEMS libraries by your self, you can access them via our git repository. To compile and copy them to your local repository, you simply need to execute the maven install goal:

```
mvn install
```

For third-party libraries this should also work.

Deploy 
-------

For instructions on how to deploy the war to a server please refer to the [Build and Install](BuildAndInstall#deploy-the-binary) instructions.
