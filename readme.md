### How to make artifact
    * Execute "gradle build"

### Deploy KOFAX server(Windows)

  * **Deploy First time**
       1. Copy <GITHUB>/onbase-integration/kofax2onbase-daemon-windows/kofax2onbase-deploy/kofax2onbase-daemon-windows\kofax2onbase-deploy to C:\kofax2onbase-deploy
       2. open cmd with Administrator and go to C:\kofax2onbase-deploy
       3. execute "kofax2onbase-daemon.exe install" - should install a service with name "kofax2onbase-daemon"
       4. Now start/stop service just like Windows Service

  * **Deploy Incremental**

       1.  Build "kofax2onbase" project after code change with "gradle build"
       2.  Copy war file from build/libs/Kofax2Onbase-<version>.war
       3.  Stop window service "kofax2onbase-daemon"
       4.  DELETE old Kofax2Onbase-<version>.war from C:\kofax2onbase-deploy\lib (server)
       5.  Paste NEW Kofax2Onbase-<version>.war in C:\kofax2onbase-deploy\lib (server) and RENAME to Kofax2Onbase.war
       6.  Start window service "kofax2onbase-daemon"
       7.  LOG Location C:\kofax2onbase-deploy\logs

NOTE :

    * Refer : https://github.com/kohsuke/winsw for service related problem or reference
