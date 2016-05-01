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
# ����Maven�������ļ�
function mvnConfig ($src, $dest = $MAVEN_SETTINGS) {
	if (Test-Path -LiteralPath $src) {
		Copy-Item -LiteralPath $src $dest -Force
	}
}

# ��ԭԭʼ��Maven���ã���o�� = ��Original��
function mvnOriginal {
	mvnConfig "$PSScriptRoot\[Original]settings.xml"
}
New-Alias -Name mvno -value mvnOriginal

# ���óɹ�����Maven�ֿ����ã�ʹ��OSChina�ľ��񣬡�p�� = ��Public��
function mvnPublic {
	mvnConfig "$PSScriptRoot\[OSC]settings.xml"
}
New-Alias -Name mvnp -value mvnPublic

# ���óɹ����õ�Maven�ֿ����ã���Ϊ�ǹ������ã������ļ�������Ŀ�У���w�� = ��Work��
function mvnWork {
	mvnConfig "$Env:FILES_HOME\AliDrive\Work\Config\Dev\maven_settings.xml"
}
New-Alias -Name mvnw -value mvnWork

export-modulemember -alias * -function *