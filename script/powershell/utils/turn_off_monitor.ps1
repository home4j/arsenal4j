# Turn off the monitor power immediately.
if (-not ("me.joshua.powershell.MonitorUtil" -as [type])) {
	
$Source = @"
[DllImport("user32.dll")]
public static extern int PostMessage(int hWnd, int Msg, int wParam, int lParam);

public static void TurnOffMonitor() {
	// Use "PostMessage" since "SendMessage" may be blocked.
	PostMessage(0xffff, 0x0112, 0xF170, 2);
}
"@

	Add-Type -MemberDefinition $Source -name "MonitorUtil" -namespace "me.joshua.powershell"
}
[me.joshua.powershell.MonitorUtil]::TurnOffMonitor()