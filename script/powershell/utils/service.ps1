$currentUser = New-Object Security.Principal.WindowsPrincipal $([Security.Principal.WindowsIdentity]::GetCurrent())
if (-not $currentUser.IsInRole([Security.Principal.WindowsBuiltinRole]::Administrator)) {
	# Re-launch the script with full privileges.
	Start-Process powershell.exe -Verb RunAs -ArgumentList ('-NoProfile -File "{0}" "{1}"' -f ($MyInvocation.MyCommand.Definition, $args[0]))
	exit
}
$name = $args[0]
$service = Get-Service | ? {$_.Name -eq $name}
if (!$service) {
	echo "Service[$name] not found"
	exit
}

Start-Service -Name $service.ServiceName
Write-Host -NoNewline "Press any key to stop `""
# 用特殊的颜色区分服务名
Write-Host -NoNewline -ForegroundColor White -BackgroundColor Blue $service.DisplayName
Write-Host -NoNewline "`" service ..."
$host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown") | Out-Null
Stop-Service -Name $service.ServiceName