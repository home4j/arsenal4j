# Update DNS config.
function changeDns ($dns1, $dns2) {
	
	
	if ([string]::IsNullOrEmpty($dns2)) {
		if ([string]::IsNullOrEmpty($dns1)) {
			$dns = $null
		} else {
			$dns = $dns1
		}
	} else {
		$dns = $dns1, $dns2
	}

	# TODO: Windows Server 2012 R2 and Windows 8.1之后，应该可以使用新的命令，但Windows 7目前还不支持，希望PowerShell 4.0能提供
	# https://technet.microsoft.com/zh-cn/library/jj590772.aspx
	
	# Search network adapters by names.
	$names = "WiFi", "Wired"
	$adapters = Get-WmiObject -Class Win32_NetworkAdapter | where ({$_.NetConnectionID -in $names})
	$indexs = New-Object Collections.Generic.List[Int]
	foreach ($adapter in $adapters) {
		$indexs.Add($adapter.index)
	}

	# Get the config of adapters by index.
	$configs = Get-WmiObject -Class Win32_NetworkAdapterConfiguration | where ({$_.Index -in $indexs});
	foreach ($config in $configs) {
		# Update DNS through adapter config.
		$config.SetDNSServerSearchOrder($dns) | Out-Null
	}

	ipconfig /flushdns | Out-Null
}

function dnsGoogle {
	changeDns '8.8.8.8' '8.8.4.4'
}
New-Alias -Name dnsg -value dnsGoogle

function dnsAli {
	changeDns '223.5.5.5' '223.6.6.6'
}
New-Alias -Name dnsa -value dnsAli

function dnsDhcp {
	changeDns
}
New-Alias -Name dnsd -value dnsDhcp

function editHost {
	# Edit the hosts file and wait for notepad++ exit.
	$process = Start-Process -FilePath "${ENV:ProgramFiles(x86)}\Notepad++\notepad++.exe" -Verb RunAs -ArgumentList("$ENV:SystemRoot\System32\drivers\etc\hosts", '-multiInst -nosession') -PassThru
	$process.WaitForExit()

	ipconfig /flushdns | Out-Null
}

export-modulemember -alias * -function *