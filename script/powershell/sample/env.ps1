[Environment]::SetEnvironmentVariable("TestVariable", "Test value Machine", "Machine")
[Environment]::GetEnvironmentVariable("TestVariable","Machine")

# 新设置的环境变量要重启Shell才能获取到，现在取得不到任何值
echo $Env:TestVariable



[Environment]::SetEnvironmentVariable("TestVariable", "Test value User", "User")
[Environment]::GetEnvironmentVariable("TestVariable","User")

# User级别的环境变量优先级比Machine的要高，同样要重启才能生效
echo $Env:TestVariable



# 用Remove-Item删除只会在当前进程中生效，重启后会复原
Remove-Item Env:TestVariable
echo $Env:TestVariable



# 彻底删除环境变量
[Environment]::SetEnvironmentVariable("TestVariable",$null,"User")
[Environment]::SetEnvironmentVariable("TestVariable",$null,"Machine")