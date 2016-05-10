#$currentUser = New-Object Security.Principal.WindowsPrincipal $([Security.Principal.WindowsIdentity]::GetCurrent())
#if (-not $currentUser.IsInRole([Security.Principal.WindowsBuiltinRole]::Administrator)) {
#	# Re-launch with full privileges.
#	Start-Process powershell.exe -Verb RunAs -ArgumentList ('-NoProfile -File "{0}"' -f ($MyInvocation.MyCommand.Definition))
#	exit
#}

sleep 3
$service = 'MySQL57'
$vpnService = Get-Service | ? {$_.Name -eq $service}
if ($vpnService.Status -eq 'Stopped') {
	Start-Service -Name $service
} else {
	Stop-Service -Name $service
}
sleep 3