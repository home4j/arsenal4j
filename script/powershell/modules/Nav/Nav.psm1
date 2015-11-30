# Quick navigate between folders.
# Work projects folder
function work {
	cd "$Env:FILES_HOME\Work\projects"
	
}

# Personal projects folder
function dev {
	cd "$Env:FILES_HOME\Dev\projects"
}

Export-ModuleMember -Function work
Export-ModuleMember -Function dev