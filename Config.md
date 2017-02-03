Configuration 
==============

The configuration of webCAT is done via !ContextVariables, please refer to the manual of your !ServletContainer implementation, to see how to set them. For tomcat place a xml file in `$CATALINA_BASE/conf/[enginename]/[hostname]/CombineArchiveWeb.xml`. An example can be found in our [repository](/resources//CombineArchiveWeb-dummyContext.xml).

Common Settings 
----------------

* **LOGLEVEL** Determines how many and which messages are logged. Available levels are: `DEBUG`, `INFO`, `WARN`, `ERROR`, `NONE`. Default is `WARN`
* **STORAGE** should point to a permanent directory with read/write rights for the !ServletContainer user. WebCAT uses this directory to store every permanent information (archives and some reference information) so it should **not** adjusted to your server, due to the default configuration points this directory to `/tmp/CombineArchiveWebStorage`
* **MAX_STATS_AGE** is the max age of the cached satistical information. So if a client requests the stats and the cache is older than *MAX_STATS_AGE*, a rescan will be triggered (on a separate thread). This can produce some significant cpu load, so if you plan to provide a larger installation, you should increase the default 180 seconds (3min).
* **FEEDBACK_URL** is the URL used in the feedback button. By default it points to the *new ticket* page of this project. Feel free to set another URL or in case you want to disable the button, just set an empty string.
* **SEDML_WEBTOOLS** is the URL used in the *simulate* button on the archive page. A direct archive-download url is just concated to this string. By default this URL is not set, leading to hiding the *simulate* button in the interface.

Quotas 
-------

Quotas are limiting the resources, which are available for your users. By default all quota are set to *unlimited* (value = 0).
To prevent people from misuing webCAT as file storage, when accessable from the internet, you should limit at least some resources.

* **QUOTA_TOTAL_SIZE** defines the maximum size of *all* workspaces together, means the maximum space (+ some bytes for internal information) webCAT is able to obtain on your disk.
* **QUOTA_WORKSPACE_SIZE** sets the maximum size of *one* workspace.
* **QUOTA_WORKSPACE_AGE** defines the maximum age of a workspace in seconds, before the workspace is deleted. This prevents webCAT from getting spamed by alot of unused workspaces. A workspace can get older than configurated, because the stats/cleaning job does not run permanently.
* **QUOTA_ARCHIVE_SIZE** is the maximum size of one archive. If it is greater than `QUOTA_WORKSPACE_SIZE` this option has no effect.
* **QUOTA_ARCHIVE_LIMIT** limits the *number* of archives in one workspace.
* **QUOTA_FILE_LIMIT** limits the *number* of file in one archive. Should not be less than a couple hundred.
* **QUOTA_UPLOAD_SIZE** maximum size of file uploads, this also concerns the uploads of existing archives on the create page.
