$currentUser = New-Object Security.Principal.WindowsPrincipal $([Security.Principal.WindowsIdentity]::GetCurrent())
if (-not $currentUser.IsInRole([Security.Principal.WindowsBuiltinRole]::Administrator)) {
	# Re-launch with full privileges.
	Start-Process powershell.exe -Verb RunAs -ArgumentList ('-NoProfile -File "{0}"' -f ($MyInvocation.MyCommand.Definition))
	exit
}

$service = 'vpnagent'
$vpnService = Get-Service | ? {$_.Name -eq $service}
$ciscoClient = "${ENV:ProgramFiles(x86)}\Cisco\Cisco AnyConnect Secure Mobility Client\vpncli.exe"
if ($vpnService.Status -eq 'Stopped') {
	Start-Service -Name $service
	Start-Process $ciscoClient -ArgumentList ('connect vpn.alibaba-inc.com')
} else {
	Start-Process $ciscoClient -ArgumentList ('disconnect')
	Stop-Service -Name $service
}