$currentUser = New-Object Security.Principal.WindowsPrincipal $([Security.Principal.WindowsIdentity]::GetCurrent())
if (-not $currentUser.IsInRole([Security.Principal.WindowsBuiltinRole]::Administrator)) {
	# Re-launch the script with full privileges.
	Start-Process powershell.exe -Verb RunAs -ArgumentList ('-NoProfile -File "{0}" "{1}"' -f ($MyInvocation.MyCommand.Definition, $args[0]))
	exit
}

Start-Service -Name 'Spooler'
Write-Host "Press any key to stop `"" + "Print Spooler" + "`" service ..."
$host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown") | Out-Null
Stop-Service -Name 'Spooler'