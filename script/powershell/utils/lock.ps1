# Lock windows and turn off the screen after 2 seconds.
rundll32.exe user32.dll,LockWorkStation
Start-Sleep -Seconds 2
. "$ENV:PSLibPath\utils\turn_off_monitor.ps1"