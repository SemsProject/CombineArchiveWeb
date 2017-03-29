CombineArchive WebInterface 
==============================

The [CombineArchive](http://co.mbine.org/documents/archive) is a zip like format to bundle latest research files and annotate them with meta data. The **CombineArchive !WebInterface** is a web based user interface to create, modify, and share !CombineArchives. **No need for registration.** Just [start using the web interface](http://cat.sems.uni-rostock.de/)! :)

Currently, the project is under heavy development, but contributions of any kind are welcome.

Development 
------------

The [sources](https://github.com/SemsProject/CombineArchiveWeb) are available from GitHub:

Known issues are tracked as [Issues](https://github.com/SemsProject/CombineArchiveWeb/issues). If you discover any bugs or if you have any problems, do not hesitate to [submit a new issue](https://github.com/SemsProject/CombineArchiveWeb/issues/new).


Build 
------
We use maven as build tool in this project. To build a binary file from our sources just execute following command:

```
mvn package
```

For more detailed instructions see the [build and install instructions](BuildAndInstall).

API 
----

We support open and interoperable software!
The CombineArchive WebInterface can be integrated without much hassle. To allow the Visitors of your website a good glimpse into the archive provided by you just add a link such as the following:

```
http://webcat.sems.uni-rostock.de/rest/import?remote=http://your.server/path&name=ANYNAME
```

The Webinterface [exposes several other interfaces](Api) for creating, modifying and deleting archives, archive-entries or meta-entries in a workspace. Most of them are meant for client-server communication, but can also be used by 3rd party software.
