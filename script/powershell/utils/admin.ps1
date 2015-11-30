$currentUser = New-Object Security.Principal.WindowsPrincipal $([Security.Principal.WindowsIdentity]::GetCurrent())
if (-not $currentUser.IsInRole([Security.Principal.WindowsBuiltinRole]::Administrator)) {
	# Re-launch the script with full privileges.
	Start-Process powershell.exe -Verb RunAs -ArgumentList ('-NoProfile -File "{0}" "{1}"' -f ($MyInvocation.MyCommand.Definition, $args[0]))
	exit
}