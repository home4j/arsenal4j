$currentUser = New-Object Security.Principal.WindowsPrincipal $([Security.Principal.WindowsIdentity]::GetCurrent())
if (-not $currentUser.IsInRole([Security.Principal.WindowsBuiltinRole]::Administrator)) {
	# Re-launch with full privileges.
	Start-Process powershell.exe -Verb RunAs -ArgumentList ('-noprofile -file "{0}"' -f ($MyInvocation.MyCommand.Definition))
	exit
}

$etc = "$ENV:SystemRoot\System32\drivers\etc"

# Edit the hosts file and wait for notepad++ exit.
$process = Start-Process -FilePath "$ENV:SystemRoot\System32\notepad.exe" -Verb RunAs -ArgumentList("$etc\hosts") -PassThru

# Open the sample etc folder.
explorer.exe $etc

$process.WaitForExit()

# Close the sample hosts folder.
(New-Object -comObject Shell.Application).Windows() `
	| ? { ($_.LocationURL -eq 'file:///' + $etc.Replace('\', '/')) } | % { $_.Quit() }

ipconfig /flushdns | Out-Null