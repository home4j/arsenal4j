$currentUser = New-Object Security.Principal.WindowsPrincipal $([Security.Principal.WindowsIdentity]::GetCurrent())
if (-not $currentUser.IsInRole([Security.Principal.WindowsBuiltinRole]::Administrator)) {
	# Re-launch the script with full privileges.
	Start-Process powershell.exe -Verb RunAs -ArgumentList ('-NoProfile -File "{0}"' -f ($MyInvocation.MyCommand.Definition))
	exit
}

# Select the theme package
[System.Reflection.Assembly]::LoadWithPartialName("System.windows.forms") | Out-Null
$dialog = New-Object System.Windows.Forms.OpenFileDialog
$dialog.DefaultExt = '.themepack'
$dialog.Filter = 'Windows Theme Package|*.themepack|All Files|*.*'
$dialog.FilterIndex = 0
$dialog.InitialDirectory = [Environment]::GetFolderPath('Desktop')
$dialog.Multiselect = $false
$dialog.Title = "Select Theme Package"
$dialog.ValidateNames = $true

if([System.Windows.Forms.DialogResult]::OK -eq $dialog.ShowDialog()) {
	# Check if the theme was installed before, indicated by theme folder.
	$name = (Get-Item $dialog.FileName).Name
	$name = $name.Substring(0, $name.LastIndexOf('.'))
	if ($name.Length -gt 9) {
		# Windows 7 use the first 9 characters as theme folder name.
		$name = $name.Substring(0, 9).Trim()
	}
	$theme = [Environment]::GetFolderPath('LocalApplicationData') + "$ENV:LOCALAPPDATA\Microsoft\Windows\Themes\$name"
	if ((Test-Path "$ENV:LOCALAPPDATA\Microsoft\Windows\Themes\$name") -eq $false) {
		# Theme folder not exist which means theme hasn't be installed.
		Start-Process -wait $dialog.FileName
		# Exit the theme install window.
		(New-Object -comObject Shell.Application).Windows() `
			| ? { ($_.LocationURL -eq "") -and ($_.FullName.toLower().Endswith('\explorer.exe')) } `
			| % { $_.Quit() }
		echo 'Theme install successfully.'
	} else {
		echo 'The theme has been installed before, skip.'
	}
} else {
	echo 'No theme package selected.'
}

# TODO: 
# 使用FolderBrowserDialog体验不如OpenFileDialog好，所以用OpenFileDialog来选择默认的登陆壁纸，然后同时把同目录下的所有登陆图片Copy到登陆背景目录中。
$dialog = New-Object System.Windows.Forms.FolderBrowserDialog
$dialog.RootFolder = [System.Environment+SpecialFolder]'Desktop'
$dialog.ShowNewFolderButton = $true
$dialog.Description = "Select the folder which contains login screen background images"

if([System.Windows.Forms.DialogResult]::OK -eq $dialog.ShowDialog()) {
	$targetDir = "$ENV:WinDir\System32\oobe\info\backgrounds"
	if ((Test-Path -PathType Leaf $targetDir) -eq $true) {
		Remove-Item $targetDir -Recurse -Force
		echo 'Remove old login screen backgrounds.'
	}
	
	if ((Test-Path $targetDir) -eq $false) {
		New-Item -Path $targetDir -Type Directory | Out-Null
		echo 'Create login screen background folder.'
	}
	$sourceDir = $dialog.SelectedPath.ToString()
	Copy-Item "$sourceDir\background*.jpg" -Destination $targetDir -Force
	echo 'Copy login screen backgrounds.'

	# Set the register key to enable the login screen background.
	Remove-Item -Path HKLM:\SOFTWARE\Microsoft\Windows\CurrentVersion\Authentication\LogonUI\Background
	New-Item -Path HKLM:\SOFTWARE\Microsoft\Windows\CurrentVersion\Authentication\LogonUI\Background | Out-Null
	Set-ItemProperty -Path HKLM:\SOFTWARE\Microsoft\Windows\CurrentVersion\Authentication\LogonUI\Background -Name OEMBackground -Value 1
}

echo 'Done :)'
Start-Sleep 2