Add-Type -TypeDefinition @"
namespace me.joshua.powershell
{
	public static class Hello
	{
		public static void say()
		{
			System.Console.Out.WriteLine("Hello PowerShell!");
		}
	}
}
"@
[me.joshua.powershell.Hello]::say()
# Sleep for a while to see the output.
Start-Sleep -s 4