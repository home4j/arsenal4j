# Quick navigate between folders.
# Work projects folder
function work {
	cd "$Env:FILES_HOME\Work\projects"
	
}

# Personal projects folder
function dev {
	cd "$Env:FILES_HOME\Dev\projects"
}

# Personal log folder
function log {
	cd "C:\Temp\logs"
}

Export-ModuleMember -Function work
Export-ModuleMember -Function dev
Export-ModuleMember -Function log