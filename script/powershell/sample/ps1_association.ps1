# Associate ps1 file to PowerShell.
New-PSDrive -Name HKCR -PSProvider Registry -Root HKEY_CLASSES_ROOT
Set-ItemProperty -Path "HKCR:\Microsoft.PowerShellScript.1\Shell\open\command" -name '(Default)' -Value '"C:\Windows\System32\WindowsPowerShell\v1.0\powershell.exe" -noLogo -ExecutionPolicy unrestricted -file "%1"'