!CombineArchive Web API 
========================
The !WebInterface exposes a lot of RESTful APIs. Mostly designed for internal purpose, are they also available for 3rd party developers. This document describes these interfaces, without any warranty to be up-to-date.

In the following, **!http://cat.web/** is the base URL of !CombineArchive Web.

Import and Share API 
---------------------
The share and import API allows the user to use simple links to share a workspace or import an archive form another webserver.

### Import an archive 
To import a !CombineArchive from a remote location, the //user// simple has to call following URL. In case of an error the web interface will show a simple text hint, otherwise the user gets redirected to his workspace. 

```
http://cat.web/rest/import?remote=REMOTEURL&name=NAME&type=TYPE
```
**REMOTEURL** specifies the URL to the archive [None](BR)
**NAME** is the name, which is displayed in the web interface. This filed is //optional//. If not given the application tries to guess a name. [None](BR)
**TYPE** defines which kind of source you want to import. The default value is //HTTP//.

Possible types:
  - **HTTP**
  - **GIT** to clone a GIT repository eg. from !GitHub or the !CellMl project

#### Advanced Import 
It is also possible to //POST// a json String to the end point, to utelize more advanced import features. Whereby the endpoint URL is the same, the /Content-Type should be either ```application/json``` or ```multipart/form-data```. When using the multipart request it is also possible to upload an archive as well as files, which should be packed into the !CombineArchive. However it is mandatory to send a json string following these pattern:
```
#!js
{
  "archiveName" : "Advanced POST Import Test",
  "ownVCard" : true,
  /* "type" : "http", */
  /* "remoteUrl" : "http://taylor.informatik.uni-rostock.de/blubb3.omex", */
  "vcard" : {
    "familyName" : "Test",
    "givenName" : "Test",
    "email" : "test@example.org",
    "organization" : "Uni Rostock"
  },
  "additionalFiles" : [
    {
      "remoteUrl" : "post://optimus.jpg",
      "archivePath" : "test/optimus.jpg",
      "fileFormat" : "http://purl.org/NET/mediatypes/image/jpeg",
      "metaData" : [
        {
          "type" : "omex",
          "creators" : [],
          "created" : "2020-09-30T00:00:00.000+0000",
          "modified" : ["2020-09-30T00:01:00.000+0000", "2020-09-30T02:00:00.000+0000"],
          "description" : "meta test"
        }
      ]
    },
    {
      "remoteUrl" : "http://localhost/octopus.svg",
      "archivePath" : "test/octo.svg",
      "metaData" : [
        {
          "type" : "omex",
          "creators" : [{
            "familyName" : "Wurst",
            "givenName" : "Hans",
            "email" : "hanswurst@example.org",
            "organization" : "TU Wurststadt"
          }],
          "created" : "2020-09-30T00:00:00.000+0000",
          "modified" : ["2020-09-30T00:01:00.000+0000", "2020-09-30T02:00:00.000+0000"],
          "description" : "beer rules"
        }
      ]
    }
  ]
}
```

In case of a multipart request following naming scheme is expected:
* ```request``` json string with import information (cf. above)
* ```archive``` (optional) !CombineArchive File
* ```additionalFile``` (optional list) Files which are suposed to be added to the !CombineArchive
##### Root Fields 
**archiveName**: Displayed name of the new !CombineArchive in the web interface.

**type**: Specifies the access method for remote import. See above for possible values.

**remoteUrl**: URL to the remote archive.

//**Note:**// Leave **type** and **remoteUrl** blank, if you want to add an archive to the post request or create a new blank archive.

**ownVCard**: //(Boolean)// If set to true, webCAT will add the information specified in **vcard** to the root node of the archive. Possible usage scenario is to store who generated this archive.

**vcard**: VCard of the creator.
```
#!js
"vcard" : {
  "familyName" : "Test",
  "givenName" : "Test",
  "email" : "test@example.org",
  "organization" : "Uni Rostock"
}
```

**additionalFiles**: List of files, to be added to the archive.

##### additionalFiles Fields 
**remoteUrl**: URL to the file. Start with ```post://``` followed by the filename used in the ```multipart/form-data``` to reference a file placed in the multipart request. (Posted files without an reference will not be added)

**archivePath**: Path within the archive.

**fileFormat**: purl.org or identifiers.org url, specifying the file format. Leave blank for auto guess.

**metaData**: List of meta data entries for this file.

##### metaData Fields 
**type**: Type of the meta data. Currently only ```omex``` is available.

##### omex metaData Fields 
**creators**: List of VCards, cf. above for details.

**created**: Time stamp in default java layout.
e.g. ```2020-09-30T00:00:00.000+0000```

**modified**: List of time stamps, confering the date of modification.

**description**: Text describing the file.

### Sharing a workspace 
The sharing URL enables user to share workspaces with colleagues and is always shown at the start page for the current active workspace.
```
http://cat.web/rest/share/WORKSPACE-ID
```
**WORKSPACE-ID** defines the internally id for the workspace, which the user want to obtain. If the specific workspace does not exists, a new one with a random generated id will be generated.

REST Interfaces 
----------------
TODO.[None](BR)
Meanwhile take a look into [[source:src/main/java/de/unirostock/sems/cbarchive/web/rest//RestApi.java|/RestApi.java]]