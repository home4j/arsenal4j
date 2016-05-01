# Generate eclipse projects.
function mvnEclipse {
	mvn eclipse:clean eclipse:eclipse '-DdownloadSources=true'
}
New-Alias -Name mvnee -value mvnEclipse

# Install projects to local repository.
function mvnInstall {
	mvn clean install '-Dmaven.test.skip' '-Denv=release'
}
New-Alias -Name mvni -value mvnInstall

# Print maven dependency tree
function mvnDependencyTree {
	mvn dependency:tree '-Dverbose'
}
New-Alias -Name mvndt -value mvnDependencyTree

# Clean eclipse projects.
function mvnClean {
	mvn eclipse:clean clean
}
New-Alias -Name mvnc -value mvnClean

# Test maven project and fail the build afterwards
function mvnTest {
	mvn test -fae
}
New-Alias -Name mvnt -value mvnTest

$script:MAVEN_REPO = "$Env:USERPROFILE\.m2"
# Clean maven local repository useless maven configuration.
function mvnCleanRepository {
	Get-ChildItem -Path "$MAVEN_REPO\repository" -Include '*lastUpdated*' -Recurse | ForEach-Object ($_) { Remove-Item $_.FullName }
}
New-Alias -Name mvncr -value mvnCleanRepository

# Update version of Maven projects.
function mvnUpdateVersion ($version) {
	mvn versions:set "-DnewVersion=$($version)" '-DgenerateBackupPoms=false'
}
New-Alias -Name mvnuv -value mvnUpdateVersion

$script:MAVEN_SETTINGS = "$Env:USERPROFILE\.m2\settings.xml"
# 更新Maven的配置文件
function mvnConfig ($src, $dest = $MAVEN_SETTINGS) {
	if (Test-Path -LiteralPath $src) {
		Copy-Item -LiteralPath $src $dest -Force
	}
}

# 还原原始的Maven配置，“o” = “Original”
function mvnOriginal {
	mvnConfig "$PSScriptRoot\[Original]settings.xml"
}
New-Alias -Name mvno -value mvnOriginal

# 设置成公共的Maven仓库配置，使用OSChina的镜像，“p” = “Public”
function mvnPublic {
	mvnConfig "$PSScriptRoot\[OSC]settings.xml"
}
New-Alias -Name mvnp -value mvnPublic

# 设置成工作用的Maven仓库配置，因为是工作配置，所以文件不在项目中，“w” = “Work”
function mvnWork {
	mvnConfig "$Env:FILES_HOME\AliDrive\Work\Config\Dev\maven_settings.xml"
}
New-Alias -Name mvnw -value mvnWork

export-modulemember -alias * -function *