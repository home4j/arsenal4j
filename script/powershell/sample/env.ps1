[Environment]::SetEnvironmentVariable("TestVariable", "Test value Machine", "Machine")
[Environment]::GetEnvironmentVariable("TestVariable","Machine")

# �����õĻ�������Ҫ����Shell���ܻ�ȡ��������ȡ�ò����κ�ֵ
echo $Env:TestVariable



[Environment]::SetEnvironmentVariable("TestVariable", "Test value User", "User")
[Environment]::GetEnvironmentVariable("TestVariable","User")

# User����Ļ����������ȼ���Machine��Ҫ�ߣ�ͬ��Ҫ����������Ч
echo $Env:TestVariable



# ��Remove-Itemɾ��ֻ���ڵ�ǰ��������Ч��������Ḵԭ
Remove-Item Env:TestVariable
echo $Env:TestVariable



# ����ɾ����������
[Environment]::SetEnvironmentVariable("TestVariable",$null,"User")
[Environment]::SetEnvironmentVariable("TestVariable",$null,"Machine")